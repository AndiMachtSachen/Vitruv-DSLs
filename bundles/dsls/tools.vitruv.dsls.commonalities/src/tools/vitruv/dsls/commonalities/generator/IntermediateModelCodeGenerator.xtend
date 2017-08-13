package tools.vitruv.dsls.commonalities.generator

import java.util.Collections
import org.eclipse.emf.codegen.ecore.generator.Generator
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage

import static extension tools.vitruv.dsls.commonalities.generator.GeneratorConstants.*

package class IntermediateModelCodeGenerator extends SubGenerator {
	static val GENERATED_CODE_COMPLIANCE_LEVEL = GenJDKLevel.JDK80_LITERAL
	static val GENERATED_CODE_FOLDER = "."
	
	override generate() {
		val generatedCodeDirectory = fsa.getURI(GENERATED_CODE_FOLDER)
		for (generatedConcept : generatedConcepts) {
			val generatedPackage = generatedConcept.generatedIntermediateModelPackage
			val generatedGenModel = generateGenModel(generatedPackage, generatedConcept, generatedCodeDirectory)
			generateModelCode(generatedGenModel)
		}
	}

	def private generateGenModel(EPackage generatedPackage, String conceptName, URI codeGenerationTargetFolder) {
		GenModelFactory.eINSTANCE.createGenModel() => [
			complianceLevel = GENERATED_CODE_COMPLIANCE_LEVEL
			modelDirectory = codeGenerationTargetFolder.toGeneratorUri().path()
			canGenerate = true
			modelName = conceptName
			initialize(Collections.singleton(generatedPackage))
			genPackages.get(0) => [
				prefix = conceptName.intermediateModelClassesPrefix
				basePackage = conceptName.conceptPackagePathPart
				adapterFactory = false
			]
		]
	}

	def private toGeneratorUri(URI uriFromFsa) {
		// we currently only know how to convert platform:/resource URIs. If you
		// ever see another in the wild (which will break the generation),
		// use the debugger and learn how to transform it!
		if (uriFromFsa.isPlatformResource) {
			// does anybody know any meaningful constant to remove this
			// hardcoded string?
			return uriFromFsa.deresolve(URI.createURI("platform:/resource/"))
		}
		return uriFromFsa
	}

	def private generateModelCode(GenModel generatedGenModel) {
		GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor(GenModelPackage.eNS_URI,
			GenModelGeneratorAdapterFactory.DESCRIPTOR)

		val generator = new Generator() => [
			input = generatedGenModel
		]
		val result = generator.generate(generatedGenModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor)
		if (result.severity != Diagnostic.OK) {
			throw new RuntimeException(result.message)
		}
	}
}
