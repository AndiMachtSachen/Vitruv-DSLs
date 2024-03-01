package tools.vitruv.dsls.reactions.codegen.changetyperepresentation

import org.eclipse.emf.ecore.EClass
import tools.vitruv.dsls.reactions.language.toplevelelements.Trigger
import tools.vitruv.change.atomic.EChange
import tools.vitruv.change.atomic.feature.reference.ReferencePackage
import tools.vitruv.change.atomic.root.RootPackage
import tools.vitruv.dsls.reactions.language.ModelElementChange
import tools.vitruv.change.atomic.eobject.EobjectPackage
import tools.vitruv.dsls.reactions.language.ModelAttributeChange
import tools.vitruv.change.atomic.feature.attribute.AttributePackage
import tools.vitruv.dsls.reactions.language.ModelAttributeRemovedChange
import tools.vitruv.dsls.reactions.language.ModelAttributeReplacedChange
import tools.vitruv.dsls.reactions.language.ModelAttributeInsertedChange
import org.eclipse.emf.ecore.EObject
import tools.vitruv.dsls.reactions.language.ElementCreationChangeType
import tools.vitruv.dsls.reactions.language.ElementDeletionChangeType
import tools.vitruv.dsls.reactions.language.ElementInsertionAsRootChangeType
import tools.vitruv.dsls.reactions.language.ElementRemovalAsRootChangeType
import tools.vitruv.dsls.reactions.language.ElementInsertionInListChangeType
import tools.vitruv.dsls.reactions.language.ElementRemovalFromListChangeType
import tools.vitruv.dsls.reactions.language.ElementReplacementChangeType
import tools.vitruv.dsls.reactions.language.ElementRootChangeType
import tools.vitruv.dsls.reactions.language.ElementExistenceChangeType
import tools.vitruv.dsls.reactions.language.ElementReferenceChangeType
import static extension tools.vitruv.dsls.reactions.codegen.helper.ReactionsLanguageHelper.*
import org.eclipse.emf.ecore.EcorePackage

final class ChangeTypeRepresentationExtractor {
	static val CREATE_CHANGE_NAME = "createChange"
	static val DELET_CHANGE_NAME = "deleteChange"
	static val INSERT_CHANGE_NAME = "insertChange"
	static val REMOVE_CHANGE_NAME = "removeChange"
	static val REPLACE_CHANGE_NAME = "replaceChange"
	static val GENERAL_CHANGE_NAME = "change"
	
	static def dispatch ChangeTypeRepresentation extractChangeType(Trigger trigger) {
		val atomicChange = new ChangeTypeRepresentation(GENERAL_CHANGE_NAME, EChange, null, null, false, false, null, false)
		return atomicChange
	}
	
	static def dispatch ChangeTypeRepresentation extractChangeType(ModelAttributeChange modelAttributeChange) {
		var hasOldValue = false
		var hasNewValue = false
		var hasIndex = false
		var EClass clazz = null
		var name = ""
		switch (modelAttributeChange) {
			ModelAttributeInsertedChange: {
				clazz = AttributePackage.Literals.INSERT_EATTRIBUTE_VALUE
				hasNewValue = true
				hasIndex = true
				name = INSERT_CHANGE_NAME
			}
			ModelAttributeRemovedChange: {
				clazz = AttributePackage.Literals.REMOVE_EATTRIBUTE_VALUE
				hasOldValue = true
				hasIndex = true
				name = REMOVE_CHANGE_NAME
			}
			ModelAttributeReplacedChange: {
				clazz = AttributePackage.Literals.REPLACE_SINGLE_VALUED_EATTRIBUTE
				hasOldValue = true
				hasNewValue = true
				name = REPLACE_CHANGE_NAME
			}
		}
		val affectedEObject = modelAttributeChange.feature.metaclass.javaClassName
		val affectedValue = modelAttributeChange.feature.feature.EType.javaClassName
		val affectedFeature = modelAttributeChange.feature.feature
		val atomicChange = new ChangeTypeRepresentation(name, clazz.instanceClass, affectedEObject, affectedValue, hasOldValue, hasNewValue, affectedFeature, hasIndex)
		return atomicChange
	}
			
	static def dispatch ChangeTypeRepresentation extractChangeType(ModelElementChange modelElementChange) {
		if (modelElementChange?.changeType === null) {
			return new ChangeTypeRepresentation(GENERAL_CHANGE_NAME, EChange, null, null, false, false, null, false)
		} else {
			return generateChangeTypeRepresentation(modelElementChange.changeType, modelElementChange.elementType?.metaclass as EClass)
		}
	}	
	
	private static def dispatch ChangeTypeRepresentation generateChangeTypeRepresentation(ElementRootChangeType modelElementChange, EClass elementClass) {
		var EClass clazz = null
		var hasNewValue = false
		var name = ""
		switch (modelElementChange) {
			ElementInsertionAsRootChangeType: {
				clazz = RootPackage.Literals.INSERT_ROOT_EOBJECT
				hasNewValue = true
				name = INSERT_CHANGE_NAME
			}
			ElementRemovalAsRootChangeType: {
				clazz = RootPackage.Literals.REMOVE_ROOT_EOBJECT
				name = REMOVE_CHANGE_NAME
			}
		} 
		val affectedEObject = null
		val affectedValue = if (elementClass !== null) elementClass.javaClassName else EObject.canonicalName
		return new ChangeTypeRepresentation(name, clazz.instanceClass, affectedEObject, affectedValue, !hasNewValue, hasNewValue, null, true)
	}
	
	private static def dispatch ChangeTypeRepresentation generateChangeTypeRepresentation(ElementReferenceChangeType modelElementChange, EClass elementClass) {
		var hasOldValue = false
		var hasNewValue = false
		var hasIndex = false
		var EClass clazz = null
		var name = ""
		switch (modelElementChange) {
			ElementInsertionInListChangeType: {
				clazz = ReferencePackage.Literals.INSERT_EREFERENCE
				hasNewValue = true
				hasIndex = true
				name = INSERT_CHANGE_NAME
			}
			ElementRemovalFromListChangeType: {
				clazz = ReferencePackage.Literals.REMOVE_EREFERENCE
				hasOldValue = true
				hasIndex = true
				name = REMOVE_CHANGE_NAME
			}
			ElementReplacementChangeType: {
				clazz = ReferencePackage.Literals.REPLACE_SINGLE_VALUED_EREFERENCE
				hasOldValue = true
				hasNewValue = true
				name = REPLACE_CHANGE_NAME
			}
		}
		val affectedEObject = modelElementChange.feature?.metaclass?.javaClassName
		val affectedValue = if (elementClass !== null) elementClass.javaClassName else modelElementChange.feature?.feature?.EType?.javaClassName
		
		val affectedFeature = modelElementChange.feature?.feature
		return new ChangeTypeRepresentation(name, clazz.instanceClass, affectedEObject, affectedValue, hasOldValue, hasNewValue, affectedFeature, hasIndex, #[EObject.canonicalName])
	}
	
	private static def dispatch ChangeTypeRepresentation generateChangeTypeRepresentation(ElementExistenceChangeType modelElementChange, EClass elementClass) {
		var EClass clazz = null
		var name = ""
		switch (modelElementChange) {
			ElementCreationChangeType: {
				clazz = EobjectPackage.Literals.CREATE_EOBJECT
				name = CREATE_CHANGE_NAME
			}
			ElementDeletionChangeType: {
				clazz = EobjectPackage.Literals.DELETE_EOBJECT
				name = DELET_CHANGE_NAME
			}
		}
		val affectedEObject = if (elementClass !== null) elementClass.javaClassName else EcorePackage.eINSTANCE.EObject.javaClassName
		val affectedValue = null
		return new ChangeTypeRepresentation(name, clazz.instanceClass, affectedEObject, affectedValue, false, false, null, false)
	}
}
