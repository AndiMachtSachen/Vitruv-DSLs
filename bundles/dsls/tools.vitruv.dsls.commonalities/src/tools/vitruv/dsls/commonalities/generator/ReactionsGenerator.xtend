package tools.vitruv.dsls.commonalities.generator

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.function.Supplier
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XbaseFactory
import tools.vitruv.dsls.commonalities.language.Participation
import tools.vitruv.dsls.commonalities.language.ParticipationClass
import tools.vitruv.dsls.commonalities.language.ParticipationRelation
import tools.vitruv.dsls.reactions.api.generator.IReactionsGenerator
import tools.vitruv.dsls.reactions.builder.FluentReactionBuilder
import tools.vitruv.dsls.reactions.builder.FluentReactionBuilder.ReactionTypeProvider
import tools.vitruv.dsls.reactions.builder.FluentReactionBuilder.TriggerBuilder
import tools.vitruv.dsls.reactions.builder.FluentRoutineBuilder.RoutineTypeProvider
import tools.vitruv.extensions.dslruntime.commonalities.IntermediateModelManagement
import tools.vitruv.extensions.dslruntime.commonalities.intermediatemodelbase.IntermediateModelBasePackage
import tools.vitruv.framework.domains.VitruvDomainProviderRegistry

import static tools.vitruv.dsls.commonalities.generator.ParticipationRelationUtil.*

import static extension tools.vitruv.dsls.commonalities.generator.JvmTypeProviderHelper.*
import static extension tools.vitruv.dsls.commonalities.generator.ReactionsGeneratorConventions.*
import static extension tools.vitruv.dsls.commonalities.language.extensions.CommonalitiesLanguageModelExtensions.*

package class ReactionsGenerator extends SubGenerator {

	private static val Logger logger = Logger.getLogger(ReactionsGenerator)

	val Supplier<IReactionsGenerator> reactionsGeneratorProvider
	val Supplier<CommonalityAttributeChangeReactionsBuilder> commonalityAttributeChangeReactionsBuilder
	val Supplier<ParticipationAttributeChangeReactionsBuilder> participationAttributeChangeReactionsBuilder
	val Supplier<ParticipationClassSpecialInitializationBuilder> participationClassSpecialInitializationBuilder
	val Supplier<ParticipationReferenceChangeReactionsBuilder> participationReferenceChangeReactionsBuilder
	val Supplier<CommonalityReferenceChangeReactionsBuilder> commonalityReferenceChangeReactionsBuilder
	@Inject Provider<ReactionsGenerationContext> reactionsGeneratorContextProvider
	@Inject CommonalitiesGenerationSettings generationSettings
	extension ReactionsGenerationContext reactionsGenerationContext

	@Inject
	new(
		Provider<IReactionsGenerator> reactionsGeneratorProvider,
		Provider<CommonalityAttributeChangeReactionsBuilder> commonalityAttributeChangeReactionsBuilderProvider,
		Provider<ParticipationAttributeChangeReactionsBuilder> participationAttributeChangeReactionsBuilderProvider,
		Provider<ParticipationClassSpecialInitializationBuilder> participationClassSpecialInitBuilderProvider,
		Provider<ParticipationReferenceChangeReactionsBuilder> participationReferenceChangeReactionsBuilderProvider,
		Provider<CommonalityReferenceChangeReactionsBuilder> commonalityReferenceChangeReactionsBuilderProvider
	) {
		this.reactionsGeneratorProvider = [
			reactionsGeneratorProvider.get() => [
				useResourceSet(resourceSet)
			]
		]
		this.commonalityAttributeChangeReactionsBuilder = [
			commonalityAttributeChangeReactionsBuilderProvider.get.withGenerationContext(reactionsGenerationContext)
		]
		this.participationAttributeChangeReactionsBuilder = [
			participationAttributeChangeReactionsBuilderProvider.get.withGenerationContext(reactionsGenerationContext)
		]
		this.participationClassSpecialInitializationBuilder = [
			participationClassSpecialInitBuilderProvider.get.withGenerationContext(reactionsGenerationContext)
		]
		this.participationReferenceChangeReactionsBuilder = [
			participationReferenceChangeReactionsBuilderProvider.get.withGenerationContext(reactionsGenerationContext)
		]
		this.commonalityReferenceChangeReactionsBuilder = [
			commonalityReferenceChangeReactionsBuilderProvider.get.withGenerationContext(reactionsGenerationContext)
		]
	}

	override generate() {
		logger.debug('''Generating reactions for commonality «commonalityFile.concept.name»::«commonality.name»''')
		if (commonality.participations.length + commonality.allMembers.length == 0) {
			// nothing to generate
			return;
		}

		val generator = reactionsGeneratorProvider.get()
		reactionsGenerationContext = reactionsGeneratorContextProvider.get.wrappingContext(generationContext)

		val reactionFile = create.reactionsFile(commonality.name)
		for (participation : commonalityFile.commonality.participations) {
			reactionFile +=
				create.reactionsSegment('''«commonality.name»To«participation.name»''').
					inReactionToChangesIn(commonalityFile.concept.vitruvDomain)
					.executeActionsIn(participation.domain.vitruvDomain) +=
						commonalityChangeReactions(participation)

			reactionFile +=
				create.reactionsSegment('''«commonality.name»From«participation.name»''')
					.inReactionToChangesIn(participation.domain.vitruvDomain)
					.executeActionsIn(commonalityFile.concept.name) +=
						participationChangeReactions(participation)

		}

		logger.debug('''Temporarily registering concept domains: «generatedConcepts»''')
		for (String conceptName : generatedConcepts) {
			VitruvDomainProviderRegistry.registerDomainProvider(conceptName, conceptName.vitruvDomain.provider)
		}

		try {
			generator.addReactionsFile(reactionFile)
			generator.generate(fsa)

			if (generationSettings.createReactionFiles) {
				generator.writeReactions(fsa)
			}
		} finally {
			logger.debug('''Unregistering concept domains again: «generatedConcepts»''')
			for (String conceptName : generatedConcepts) {
				VitruvDomainProviderRegistry.unregisterDomainProvider(conceptName)
			}
		}
	}

	def private commonalityChangeReactions(Participation participation) {
		(
			#[
				reactionForCommonalityCreate(participation),
				reactionForCommonalityDelete(participation),
				reactionForCommonalityRootInsert(participation)
			]
			+ participation.reactionsForCommonalityAttributeChange
			+ participation.reactionsForCommonalityReferenceChange
		).filterNull
	}

	def private participationChangeReactions(Participation participation) {
		(
			participation.classes
			.filter[!isForResource]
			.flatMap[#[
				reactionForParticipationClassCreate,
				reactionForParticipationClassDelete,
				reactionForParticipationRootInsert
			]]
			+ participation.reactionsForParticipationAttributeChange
			+ participation.reactionsForParticipationReferenceChange
		).filterNull
	}

	def private reactionForCommonalityDelete(Participation participation) {
		create.reaction('''«commonality.concept.name»_«commonality.name»Delete''')
			.afterElement(commonalityFile.changeClass).deleted
			.call [
				match [
					for (participationClass : participation.classes) {
						vall('''corresponding_«participationClass.name»''').retrieveAsserted(participationClass.changeClass)
							.correspondingTo.affectedEObject
							.taggedWith(participationClass.correspondenceTag)
					}
				]
				action [
					for (participationClass : participation.classes) {
						delete('''corresponding_«participationClass.name»''')
					}
				]
			]
	}

	def private reactionForParticipationClassDelete(ParticipationClass participationClass) {
		create.reaction('''«participationClass.participation.name»_«participationClass.name»Delete''')
			.afterElement(participationClass.changeClass).deleted
			.call [
				match [
					vall('corresponding_intermediate').retrieveAsserted(commonalityFile.changeClass)
						.correspondingTo.affectedEObject
				]
				action [
					delete('corresponding_intermediate')
				]
			]
	}

	def private reactionForCommonalityCreate(Participation participation) {
		create.reaction('''«commonality.concept.name»_«commonality.name»Create''')
			.afterElement(commonalityFile.changeClass).created
			.call [
				match [
					for (participationClass : participation.classes) {
						requireAbsenceOf(participationClass.changeClass).correspondingTo.affectedEObject
							.taggedWith(participationClass.correspondenceTag)
					}
				]
				.action [
					for (participationClass : participation.classes) {
						val corresponding = participationClass.correspondingVariableName
						val specialInitBuilder = participationClassSpecialInitializationBuilder.get.forParticipationClass(participationClass)
						vall(corresponding).create(participationClass.changeClass) => [
							if (participation.isCommonalityParticipation || specialInitBuilder.hasSpecialInitialization) {
								andInitialize [ typeProvider |
									XbaseFactory.eINSTANCE.createXBlockExpression => [
										expressions += #[
											(participation.isCommonalityParticipation) ?
												assignStagingId(typeProvider, typeProvider.variable(corresponding)) : null,
											(specialInitBuilder.hasSpecialInitialization) ?
												specialInitBuilder.getSpecialInitializer(typeProvider, [
													typeProvider.variable(correspondingVariableName)
												]) : null
										].filterNull
									]
								]
							}
						]
						addCorrespondenceBetween.affectedEObject.and(corresponding)
							.taggedWith(participationClass.correspondenceTag)
					}
				]
			]
	}

	def private reactionForParticipationClassCreate(ParticipationClass participationClass) {
		create.reaction('''«participationClass.participation.name»_«participationClass.name»Create''')
			.afterElement(participationClass.changeClass).created
			.call [
				match [
					requireAbsenceOf(commonality.changeClass).correspondingTo.affectedEObject
						.taggedWith(participationClass.correspondenceTag)
				]
				.action [
					vall('newIndermediate').create(commonalityFile.changeClass).andInitialize [
						assignStagingId(variable('newIndermediate'))
					]
					addCorrespondenceBetween('newIndermediate').and.affectedEObject
						.taggedWith(participationClass.correspondenceTag)
				]
			]
	}

	// Picks the correct 'inserted as root' trigger depending on whether the given change class belongs to a
	// commonality or a regular participation class
	def static private afterElementInsertedAsRoot(TriggerBuilder reactionTriggerBuilder, EClass changeClass) {
		if (changeClass.ESuperTypes.contains(IntermediateModelBasePackage.eINSTANCE.intermediate)) {
			// trigger for Commonality root insert:
			reactionTriggerBuilder.afterElement(changeClass).insertedIn(IntermediateModelBasePackage.eINSTANCE.root_Intermediates)
		} else {
			// trigger for non-commonality participation class root insert:
			reactionTriggerBuilder.afterElement(changeClass).insertedAsRoot
		}
	}

	def private reactionForParticipationRootInsert(ParticipationClass participationClass) {
		create.reaction('''«participationClass.participation.name»_«participationClass.name»RootInsert''')
			// note: may be a commonality participation
			.afterElementInsertedAsRoot(participationClass.changeClass)
			.call(#[
				participationClass.intermediateResourceBridgeRoutine,
				getInsertRoutine(participationClass.participation, commonality)
			].filterNull)
	}

	def private reactionForCommonalityRootInsert(Participation participation) {
		// Check for participation relations that trigger on inserts:
		val relations = newHashMap(participation.classes
			.map[optionalParticipationRelation]
			.filterNull
			.toSet
			.map [it -> operator.findOptionalImplementedMethod('afterInserted')]
			.filter[value !== null])

		if (relations.size > 0 || participation.isCommonalityParticipation) {
			// TODO participation domains
			val reactionStart = create.reaction('''«commonality.concept.name»_«commonality.name»RootInsert''')
				.afterElementInsertedAsRoot(commonalityFile.changeClass)

			var FluentReactionBuilder reaction = null;
			if (relations.size > 0) {
				reaction = reactionStart.call [
					match [
						for (partClass : relations.keySet.flatMap [participationClasses]) {
							vall(partClass.correspondingVariableName).retrieveAsserted(partClass.changeClass)
								.correspondingTo.newValue
								.taggedWith(partClass.correspondenceTag)
						}
					]
					.action [
						for (entry : relations.entrySet) {
							val relation = entry.key
							val insertOperation = entry.value
							execute [
								callOperationOnRelation(relation, insertOperation)
							]
						}
					]
				]
			}

			// Each participating commonality is implicitly contained inside the root of its intermediate model.
			// This containment relation is realized when the current commonality instance is inserted into its root.
			// TODO In case relations between commonalities are a thing: Only apply implicit root containment for those
			// commonalities without relation? Or make the root relation explicit (similar to 'in Resource')?
			if (participation.isCommonalityParticipation) {
				for (participationClass : participation.classes) {
					val participatingCommonality = participationClass.participatingCommonality // assert: not null
					reaction = reactionStart.call(getInsertRoutine(participation, participatingCommonality))
				}
			}
			reaction
		}
	}

	def private reactionsForCommonalityAttributeChange(Participation participation) {
		commonality.attributes.flatMap [ attribute |
			commonalityAttributeChangeReactionsBuilder.get.forAttribute(attribute).regardingParticipation(participation).reactions
		]
	}

	def private reactionsForCommonalityReferenceChange(Participation participation) {
		commonality.references.flatMap [ reference |
			commonalityReferenceChangeReactionsBuilder.get.forReference(reference).regardingParticipation(participation).reactions
		]
	}

	def private reactionsForParticipationAttributeChange(Participation participation) {
		participationAttributeChangeReactionsBuilder.get.forParticipation(participation).reactions
	}

	def private reactionsForParticipationReferenceChange(Participation participation) {
		participationReferenceChangeReactionsBuilder.get.forParticipation(participation).reactions
	}

	def hasResource(extension ReactionTypeProvider typeProvider, XFeatureCall element) {
		XbaseFactory.eINSTANCE.createXBinaryOperation => [
			leftOperand = XbaseFactory.eINSTANCE.createXMemberFeatureCall => [
				memberCallTarget = element
				feature = typeProvider.findMethod(EClass, 'eResource')
			]
			feature = typeProvider.findMethod(ObjectExtensions, 'operator_tripleNotEquals')
			rightOperand = XbaseFactory.eINSTANCE.createXNullLiteral
		]
	}

	def private assignStagingId(extension RoutineTypeProvider typeProvider, XFeatureCall element) {
		XbaseFactory.eINSTANCE.createXMemberFeatureCall => [
			memberCallTarget = element
			feature = typeProvider.findMethod(IntermediateModelManagement, 'claimStagingId').staticExtensionWildcardImported
			explicitOperationCall = true
		]
	}

	def private callOperationOnRelation(extension RoutineTypeProvider typeProvider,
		ParticipationRelation relation, JvmOperation operation) {
		XbaseFactory.eINSTANCE.createXMemberFeatureCall => [
			memberCallTarget = createOperatorConstructorCall(relation, typeProvider, [variable(correspondingVariableName)])
			feature = operation
			explicitOperationCall = true
		]
	}
}
