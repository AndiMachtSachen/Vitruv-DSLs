/*
 * generated by Xtext 2.12.0
 */
package tools.vitruv.dsls.mappings.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.service.SingletonBinding
import tools.vitruv.dsls.mappings.ui.validation.MappingsLanguageEclipseValidator
import tools.vitruv.dsls.mappings.validation.MappingsLanguageValidator

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class MappingsLanguageUiModule extends AbstractMappingsLanguageUiModule {
	@SingletonBinding(eager=true)
	def Class<? extends MappingsLanguageValidator> bindMappingsLanguageValidator() {
		MappingsLanguageEclipseValidator
	}
}