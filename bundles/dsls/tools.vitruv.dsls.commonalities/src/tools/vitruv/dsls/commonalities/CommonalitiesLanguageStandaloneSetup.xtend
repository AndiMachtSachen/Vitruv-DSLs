/*
 * generated by Xtext 2.12.0
 */
package tools.vitruv.dsls.commonalities

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class CommonalitiesLanguageStandaloneSetup extends CommonalitiesLanguageStandaloneSetupGenerated {

	def static void doSetup() {
		new CommonalitiesLanguageStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
