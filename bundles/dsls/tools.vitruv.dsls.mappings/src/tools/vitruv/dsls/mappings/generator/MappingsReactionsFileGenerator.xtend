package tools.vitruv.dsls.mappings.generator

import tools.vitruv.dsls.mappings.mappingsLanguage.MappingsSegment
import tools.vitruv.dsls.reactions.builder.FluentReactionsLanguageBuilder
import org.eclipse.xtend.lib.annotations.Accessors
import com.google.common.base.Supplier
import tools.vitruv.dsls.reactions.api.generator.IReactionsGenerator
import tools.vitruv.dsls.mappings.mappingsLanguage.MappingsFile
import org.eclipse.xtext.generator.IFileSystemAccess2
import com.google.inject.Inject
import com.google.inject.Provider
import tools.vitruv.dsls.reactions.generator.ExternalReactionsGenerator
import tools.vitruv.dsls.mappings.mappingsLanguage.Mapping
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet

class MappingsReactionsFileGenerator {
	@Accessors(PROTECTED_GETTER)
	val FluentReactionsLanguageBuilder create
	val MappingsFile mappingsFile;
	// not used atm
	var String basePackage
	var MappingGeneratorContext context
	var boolean left2right
	var MappingsSegment segment

	new(String basePackage, MappingsSegment segment, boolean left2right, FluentReactionsLanguageBuilder create,
		MappingsFile file) {
		this.segment = segment
		this.left2right = left2right
		this.basePackage = basePackage
		this.create = create
		this.mappingsFile = file
	}

	def generate() {
		createAndInitializeFile
		generateReactionsAndRoutines
		context
	}

	private def createAndInitializeFile() {
		val reactionsFile = create.reactionsFile(directedSegmentName)
		val segmentBuilder = create.reactionsSegment(directedSegmentName).inReactionToChangesIn(fromDomain.domain).
			executeActionsIn(toDomain.domain)
		reactionsFile += segmentBuilder
		context = new MappingGeneratorContext(reactionsFile, segmentBuilder, segment, mappingsFile, create, left2right)
	}

	private def generateReactionsAndRoutines() {
		val extractor = new MappingParameterExtractor(fromDomain)
		segment.mappings.forEach [
			extractor.extract(it)
			val from = extractor.fromParameters
			val to = extractor.toParameters
			val fromConditions = extractor.fromConditions
			val toConditions = extractor.toConditions
			val mappingsConditions = extractor.bidirectionalizableConditions
			val mappingRoutines = extractor.bidirectionalizableRoutines
			val mappingAttributes = extractor.observeChanges
			val reactionsBuilder = new DirectionalMappingReactionGenerator(from, to, it)
			println('''generate mapping «it.name» «IF (context.left2right)»left to right«ELSE»right to left«ENDIF»:''')
			reactionsBuilder.generate(context, fromConditions, toConditions, mappingsConditions, mappingRoutines,
				mappingAttributes)
		]
	}

	private def getFromDomain() {
		if(left2right) segment.leftDomain else segment.rightDomain
	}

	private def getToDomain() {
		if(left2right) segment.rightDomain else segment.leftDomain
	}

	private def String getDirectedSegmentName() '''«segment.name»«directionSuffix»'''

	private def String getDirectionSuffix() '''«IF left2right »_L2R«ELSE»_R2L«ENDIF»'''

}
