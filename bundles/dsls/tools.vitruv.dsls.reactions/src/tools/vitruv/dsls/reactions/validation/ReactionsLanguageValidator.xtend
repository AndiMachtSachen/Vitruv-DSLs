/*
 * generated by Xtext 2.9.0
 */
package tools.vitruv.dsls.reactions.validation

import com.google.inject.Inject
import org.eclipse.xtext.validation.Check
import tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage
import java.util.HashMap
import tools.vitruv.dsls.reactions.reactionsLanguage.Routine
import tools.vitruv.dsls.reactions.reactionsLanguage.RetrieveModelElement
import tools.vitruv.dsls.reactions.reactionsLanguage.CreateModelElement
import tools.vitruv.dsls.reactions.reactionsLanguage.Reaction
import tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment
import tools.vitruv.dsls.reactions.reactionsLanguage.ModelElementChange
import tools.vitruv.dsls.reactions.reactionsLanguage.ElementReferenceChangeType
import org.eclipse.emf.ecore.EClass
import tools.vitruv.dsls.reactions.reactionsLanguage.ElementCreationAndInsertionChangeType
import tools.vitruv.dsls.reactions.reactionsLanguage.ElementChangeType
import tools.vitruv.dsls.reactions.reactionsLanguage.ElementDeletionAndRemovalChangeType
import tools.vitruv.dsls.reactions.reactionsLanguage.ElementDeletionAndCreationAndReplacementChangeType
import tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsFile
import tools.vitruv.dsls.reactions.scoping.ReactionsImportScopeHelper
import tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsImport
import static extension tools.vitruv.dsls.reactions.codegen.helper.ReactionsLanguageHelper.*
import static extension tools.vitruv.dsls.reactions.codegen.helper.ReactionsImportsHelper.*
import static extension tools.vitruv.dsls.reactions.util.ReactionsLanguageUtil.*

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class ReactionsLanguageValidator extends AbstractReactionsLanguageValidator {

	@Inject ReactionsImportScopeHelper reactionsImportScopeHelper;

	@Check
	def checkReactionsFile(ReactionsFile reactionsFile) {
		// check for duplicate reactions segment names in same file:
		val alreadyCheckedSegments = new HashMap<String, ReactionsSegment>();
		for (reactionsSegment : reactionsFile.reactionsSegments) {
			val reactionsSegmentName = reactionsSegment.formattedName;
			if (alreadyCheckedSegments.putIfAbsent(reactionsSegmentName, reactionsSegment) !== null) {
				val errorMessage = "Duplicate reactions segment name: " + reactionsSegmentName;
				error(errorMessage, reactionsSegment, ReactionsLanguagePackage.Literals.REACTIONS_SEGMENT__NAME);
				val duplicateNameSegment = alreadyCheckedSegments.get(reactionsSegmentName);
				error(errorMessage, duplicateNameSegment, ReactionsLanguagePackage.Literals.REACTIONS_SEGMENT__NAME);
			}
		}
	}

	@Check
	def checkReactionsSegment(ReactionsSegment reactionsSegment) {
		// validate segment name:
		val segmentName = reactionsSegment.name;
		val segmentFormattedName = reactionsSegment.formattedName;
		if (segmentName.startsWith("_")) {
			error("Reactions segment names must not start with an underscore.",
				ReactionsLanguagePackage.Literals.REACTIONS_SEGMENT__NAME);
		}
		if (!Character.isLowerCase(segmentName.charAt(0))) {
			warning("Reactions segment names should start lower case.",
				ReactionsLanguagePackage.Literals.REACTIONS_SEGMENT__NAME);
		}

		// check for duplicate reactions segment names globally:
		val resource = reactionsSegment.eResource;
		val visibleReactionsSegmentDescs = reactionsImportScopeHelper.getVisibleReactionsSegmentDescriptions(reactionsSegment);
		val duplicateNameSegmentDesc = visibleReactionsSegmentDescs.findFirst[it.name.toString.formattedReactionsSegmentName.equals(segmentFormattedName)];
		if (duplicateNameSegmentDesc !== null) {
			// path relative to current file:
			val pathToOtherSegment = duplicateNameSegmentDesc.EObjectURI.trimFragment.deresolve(resource.URI);
			warning(
				"Duplicate reactions segment name '" + segmentFormattedName + "': Already defined in " + pathToOtherSegment,
				reactionsSegment,
				ReactionsLanguagePackage.Literals.REACTIONS_SEGMENT__NAME
			);
		}

		// validate reactions imports:

		// check for different metamodel pairs in imports:
		checkNoDifferentMetamodelPairImports(reactionsSegment);

		// check for duplicate imports:
		checkNoDuplicateImports(reactionsSegment);

		// check for cyclic imports:
		checkNoCyclicImports(reactionsSegment);

		// check for duplicately included reactions:
		checkNoDuplicateIncludedReactions(reactionsSegment);

		// check for name-clashes in included routines:
		checkNoIncludedRoutinesNameClashes(reactionsSegment);

		// check for name-clashes in included routines facades:
		checkNoIncludedRoutinesFacadesNameClashes(reactionsSegment);

		// check for duplicate reaction names in same segment:
		checkNoDuplicateReactionNames(reactionsSegment);

		// warning when declaring regular reactions with names already existing in imported segments:
		checkNoDuplicateReactionNamesInIncludedReactions(reactionsSegment);

		// check for duplicate routine names in same segment:
		checkNoDuplicateRoutineNames(reactionsSegment);
	}

	private def void checkNoDifferentMetamodelPairImports(ReactionsSegment reactionsSegment) {
		// imported reactions segments need to use the same metamodel pair:
		val metamodelPairName = reactionsSegment.formattedMetamodelPair;
		for (reactionsImport : reactionsSegment.reactionsImports) {
			val importedSegment = reactionsImport.importedReactionsSegment;
			val importedMetamodelPairName = importedSegment.formattedMetamodelPair;
			if (!metamodelPairName.equals(importedMetamodelPairName)) {
				val errorMessage = "Cannot import reactions segment using a different metamodel pair: " + importedMetamodelPairName;
				error(errorMessage, reactionsImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
			}
		}
	}

	private def void checkNoDuplicateImports(ReactionsSegment reactionsSegment) {
		// imported reactions segment name -> import
		val alreadyCheckedImports = new HashMap<String, ReactionsImport>();
		for (reactionsImport : reactionsSegment.reactionsImports) {
			val importedSegment = reactionsImport.importedReactionsSegment;
			val importedSegmentFormattedName = importedSegment.formattedName;
			val duplicateImport = alreadyCheckedImports.putIfAbsent(importedSegmentFormattedName, reactionsImport);
			if (duplicateImport !== null) {
				val errorMessage = "Duplicate reactions import: " + importedSegmentFormattedName;
				error(errorMessage, reactionsImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
				error(errorMessage, duplicateImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
			}
		}
	}

	private def void checkNoCyclicImports(ReactionsSegment reactionsSegment) {
		// no imported reactions segment can transitively import the currently being checked reactions segment:
		val segmentFormattedName = reactionsSegment.formattedName;
		for (reactionsImport : reactionsSegment.reactionsImports) {
			val importedSegment = reactionsImport.importedReactionsSegment;
			val importImportedSegments = importedSegment.routinesImportHierarchy.values;
			if (importImportedSegments.findFirst[it.formattedName.equals(segmentFormattedName)] !== null) {
				val errorMessage = "Cyclic reactions import! Cannot transitively import self: " + segmentFormattedName;
				error(errorMessage, reactionsImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
			}
		}
	}

	private def void checkNoDuplicateIncludedReactions(ReactionsSegment reactionsSegment) {
		// corresponding formatted reactions segment name -> import
		val alreadyCheckedIncludedReactions = new HashMap<String, ReactionsImport>();
		for (reactionsImport : reactionsSegment.reactionsImports.filter[!it.isRoutinesOnly]) {
			val importedSegment = reactionsImport.importedReactionsSegment;
			val importIncludedReactionsSegments = importedSegment.reactionsImportHierarchy.values;
			for (includedReactionsSegment : importIncludedReactionsSegments) {
				val includedReactionsSegmentFormattedName = includedReactionsSegment.formattedName;
				val duplicateReactionsImport = alreadyCheckedIncludedReactions.putIfAbsent(includedReactionsSegmentFormattedName, reactionsImport);
				if (duplicateReactionsImport !== null) {
					val errorMessage = "Cannot (possibly transitively) import reactions of the same reactions segment ('" 
							+ includedReactionsSegmentFormattedName + "') more than once. Consider importing only the routines for one of them.";
					error(errorMessage, reactionsImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
					error(errorMessage, duplicateReactionsImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
				}
			}
		}
	}

	private def void checkNoDuplicateReactionNamesInIncludedReactions(ReactionsSegment reactionsSegment) {
		// formatted reaction name -> reaction
		val localReactions = reactionsSegment.regularReactions.toMap[formattedName];
		val importedReactions = reactionsSegment.reactionsImportHierarchy.filter [
			importPath, segment | importPath.length > 1
		].values.map[regularReactions].flatten;
		for (importedReaction : importedReactions) {
			val importedReactionName = importedReaction.formattedName;
			// warning if a reaction is declared locally with a name already existing in imported segments:
			val duplicateReaction = localReactions.get(importedReactionName);
			if (duplicateReaction !== null) {
				val errorMessage = "A reaction with this name ('" + importedReactionName + "') already exists in segment '" 
						+ importedReaction.reactionsSegment.formattedName + "'. Consider using a different name.";
				warning(errorMessage, duplicateReaction, ReactionsLanguagePackage.Literals.REACTION__NAME);
			}
		}
	}

	private def void checkNoIncludedRoutinesNameClashes(ReactionsSegment reactionsSegment) {
		// formatted routine name -> routine
		val localRoutines = reactionsSegment.regularRoutines.toMap[formattedName];
		// formatted routine name -> import
		val alreadyCheckedIncludedRoutines = new HashMap<String, ReactionsImport>();
		for (reactionsImport : reactionsSegment.reactionsImports.filter[!it.useQualifiedNames]) {
			val importedSegment = reactionsImport.importedReactionsSegment;
			val importIncludedRoutines = importedSegment.getIncludedRoutines(true, false).keySet;
			for (includedRoutine : importIncludedRoutines) {
				val includedRoutineName = includedRoutine.formattedName;

				// check for name clashes with local routines:
				val duplicateRoutine = localRoutines.get(includedRoutineName);
				if (duplicateRoutine !== null) {
					val errorMessage = "Name-clash between imported and local routine ('" + includedRoutineName + "'). Consider importing using qualified names.";
					error(errorMessage, reactionsImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
					error(errorMessage, duplicateRoutine, ReactionsLanguagePackage.Literals.ROUTINE__NAME);
				}

				// check for name clashes with included routines from other imports:
				val duplicateReactionsImport = alreadyCheckedIncludedRoutines.putIfAbsent(includedRoutineName, reactionsImport);
				if (duplicateReactionsImport !== null) {
					val errorMessage = "Name-clash between imported routines ('" + includedRoutineName + "'). Consider importing one of them using qualified names.";
					error(errorMessage, reactionsImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
					error(errorMessage, duplicateReactionsImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
				}
			}
		}
	}

	private def void checkNoIncludedRoutinesFacadesNameClashes(ReactionsSegment reactionsSegment) {
		// corresponding formatted reactions segment name -> import
		val alreadyCheckedIncludedRoutinesFacades = new HashMap<String, ReactionsImport>();
		for (reactionsImport : reactionsSegment.reactionsImports) {
			val importedSegment = reactionsImport.importedReactionsSegment;
			if (reactionsImport.useQualifiedNames) {
				// imported segment's routines facade is included:
				val includedRoutinesFacadeName = importedSegment.formattedName;
				// check for name clashes with included routines facades from other imports:
				val duplicateReactionsImport = alreadyCheckedIncludedRoutinesFacades.putIfAbsent(includedRoutinesFacadeName, reactionsImport);
				if (duplicateReactionsImport !== null) {
					errorIncludedRoutinesFacadesNameClash(reactionsImport, duplicateReactionsImport, includedRoutinesFacadeName);
				}
			} else {
				// check for transitively included routines facades:
				val importIncludedRoutinesFacadeSegments = importedSegment.includedRoutinesFacades.keySet;
				for (includedRoutinesFacadeSegment : importIncludedRoutinesFacadeSegments) {
					val includedRoutinesFacadeName = includedRoutinesFacadeSegment.formattedName;
					// check for name clashes with included routines facades from other imports:
					val duplicateReactionsImport = alreadyCheckedIncludedRoutinesFacades.putIfAbsent(includedRoutinesFacadeName, reactionsImport);
					if (duplicateReactionsImport !== null) {
						errorIncludedRoutinesFacadesNameClash(reactionsImport, duplicateReactionsImport, includedRoutinesFacadeName);
					}
				}
			}
		}
	}

	private def void errorIncludedRoutinesFacadesNameClash(ReactionsImport checkedImport, ReactionsImport conflictingImport, String conflictingSegmentName) {
		val errorMessage = "Name-clash between routines imported (possibly transitively) with qualified names ('" + conflictingSegmentName
			+ "'). Consider importing one of them without qualified names.";
		error(errorMessage, checkedImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
		error(errorMessage, conflictingImport, ReactionsLanguagePackage.Literals.REACTIONS_IMPORT__IMPORTED_REACTIONS_SEGMENT);
	}

	private def void checkNoDuplicateReactionNames(ReactionsSegment reactionsSegment) {
		val alreadyCheckedReactions = new HashMap<String, Reaction>();
		for (reaction : reactionsSegment.reactions) {
			val reactionName = reaction.displayName;
			if (alreadyCheckedReactions.putIfAbsent(reactionName, reaction) !== null) {
				val errorMessage = "Duplicate reaction name: " + reactionName;
				error(errorMessage, reaction, ReactionsLanguagePackage.Literals.REACTION__NAME);
				error(
					errorMessage,
					alreadyCheckedReactions.get(reactionName),
					ReactionsLanguagePackage.Literals.REACTION__NAME
				);
			}
		}
	}

	private def void checkNoDuplicateRoutineNames(ReactionsSegment reactionsSegment) {
		val alreadyCheckedRoutines = new HashMap<String, Routine>();
		for (routine : reactionsSegment.routines) {
			val routineName = routine.displayName;
			if (alreadyCheckedRoutines.putIfAbsent(routineName, routine) !== null) {
				val errorMessage = "Duplicate routine name: " + routineName;
				error(errorMessage, routine, ReactionsLanguagePackage.Literals.ROUTINE__NAME);
				val duplicateNameRoutine = alreadyCheckedRoutines.get(routineName);
				error(errorMessage, duplicateNameRoutine, ReactionsLanguagePackage.Literals.ROUTINE__NAME);
			}
		}
	}

	@Check
	def checkRetrieveElementName(RetrieveModelElement element) {
		if (!element.name.nullOrEmpty && element.name.startsWith("_")) {
			error("Element names must not start with an underscore.",
				ReactionsLanguagePackage.Literals.RETRIEVE_MODEL_ELEMENT__NAME);
		}
	}
	
		@Check
	def checkCreateElementName(CreateModelElement element) {
		if (!element.name.nullOrEmpty && element.name.startsWith("_")) {
			error("Element names must not start with an underscore.",
				ReactionsLanguagePackage.Literals.CREATE_MODEL_ELEMENT__NAME);
		}
	}

//	@Check
//	def checkEffects(Effect effect) {
//		if (effect.impact.codeBlock === null && !effect.impact..filter(CorrespondingModelElementCreate).nullOrEmpty) {
//			warning("Created elements must be initialized and inserted into the target model in the execute block.",
//				ReactionsLanguagePackage.Literals.EFFECT__CODE_BLOCK);
//		}
//	}
	
//	@Check
//	def checkEffectInput(RoutineInput effectInput) {
//		if (!effectInput.javaInputElements.empty) {
//			warning("Using plain Java elements is discouraged. Try to use model elements and make list inputs to single valued input of other effect that is called for each element.",
//				ReactionsLanguagePackage.Literals.ROUTINE_INPUT__JAVA_INPUT_ELEMENTS);
//		}
//	}
	
	@Check
	def checkRoutine(Routine routine) {
		if (routine.name.startsWith("_")) {
			error("Routine names must not start with an underscore.",
				ReactionsLanguagePackage.Literals.ROUTINE__NAME);
		}
		if (!Character.isLowerCase(routine.name.charAt(0))) {
			warning("Routine names should start lower case",
				ReactionsLanguagePackage.Literals.ROUTINE__NAME);
		}

		// validate routine overrides:
		if (routine.isOverride) {
			val overrideImportPath = routine.overrideImportPath.toReactionsImportPath;
			if (!routine.overrideImportPath.isComplete) {
				// incomplete override import path:
				val errorMessage = "Incomplete override import path: " + overrideImportPath.pathString;
				error(errorMessage, routine, ReactionsLanguagePackage.Literals.ROUTINE__OVERRIDE_IMPORT_PATH);
			} else {
				val overriddenReactionsSegment = routine.reactionsSegment.getReactionsSegment(overrideImportPath);
				if (overriddenReactionsSegment === null) {
					// invalid override import path:
					val errorMessage = "Can not find overridden reactions segment for this import path: " + overrideImportPath.pathString;
					error(errorMessage, routine, ReactionsLanguagePackage.Literals.ROUTINE__OVERRIDE_IMPORT_PATH);
				} else {
					// check for matching name:
					val routineName = routine.formattedName;
					val overriddenRoutine = overriddenReactionsSegment.regularRoutines.findFirst[it.formattedName.equals(routineName)];
					if (overriddenRoutine === null) {
						val errorMessage = "Routine name does not match any routine in the overridden reactions segment: " + routineName;
						error(errorMessage, routine, ReactionsLanguagePackage.Literals.ROUTINE__NAME);
					} else {
						// check for matching parameters / signature:
						val inputSignature = routine.inputSignature;
						val overriddenInputSignature = overriddenRoutine.inputSignature;
						if (!inputSignature.equals(overriddenInputSignature)) {
							val errorMessage = "Input parameters need to match those of the overridden routine: " + overriddenInputSignature;
							error(errorMessage, routine, ReactionsLanguagePackage.Literals.ROUTINE__INPUT);
						}
					}
				}
			}
		}
	}
	
	private def String getInputSignature(Routine routine) {
		val signature = new StringBuilder();
		signature.append('(');
		for (modelInputElement : routine.input.modelInputElements) {
			signature.append(modelInputElement.metaclass.javaClassName);
		}
		for (javaInputElement : routine.input.javaInputElements) {
			// includes type parameters:
			signature.append(javaInputElement.type.identifier);
		}
		signature.append(')');
		return signature.toString;
	}
	
	@Check
	def checkReaction(Reaction reaction) {
		if (!Character.isUpperCase(reaction.name.charAt(0))) {
			warning("Reaction names should start upper case",
				ReactionsLanguagePackage.Literals.REACTION__NAME);
		}

		// reaction overrides must have matching name:
		if (reaction.isOverride) {
			val reactionName = reaction.formattedName;
			val overriddenReaction = reaction.overriddenReactionsSegment.regularReactions.findFirst[it.formattedName.equals(reactionName)];
			if (overriddenReaction === null) {
				val errorMessage = "Reaction name does not match any reaction in the overridden reactions segment: " + reactionName;
				error(errorMessage, reaction, ReactionsLanguagePackage.Literals.REACTION__NAME);
			}
		}
	}
	
	@Check
	def checkMetaclassFeature(ModelElementChange elementChange) {
		val elementType = elementChange?.elementType?.metaclass;
		val elementChangeType = elementChange?.changeType;
		// Only continue if element type is specified and its a feature change
		var ElementChangeType atomicChangeType = null;
		if (elementChangeType instanceof ElementReferenceChangeType) {
			atomicChangeType = elementChangeType;
		} else if (elementChangeType instanceof ElementCreationAndInsertionChangeType) {
			atomicChangeType = elementChangeType.insertChange;
		} else if (elementChangeType instanceof ElementDeletionAndRemovalChangeType) {
			atomicChangeType = elementChangeType.removeChange;
		} else if (elementChangeType instanceof ElementDeletionAndCreationAndReplacementChangeType) {
			atomicChangeType = elementChangeType.replacedChange;
		}
		if (atomicChangeType instanceof ElementReferenceChangeType) {
			val featureType = atomicChangeType.feature?.feature?.EType as EClass;
			if (elementType !== null && featureType !== null) {
				if (!elementType.equals(featureType) && !elementType.EAllSuperTypes.contains(featureType) && !featureType.EAllSuperTypes.contains(elementType)) {
					warning("Element of specified type cannot be contained in the specified features",
						elementChange, ReactionsLanguagePackage.Literals.MODEL_ELEMENT_CHANGE__ELEMENT_TYPE
					)
				}
			}
		}
	}

}
