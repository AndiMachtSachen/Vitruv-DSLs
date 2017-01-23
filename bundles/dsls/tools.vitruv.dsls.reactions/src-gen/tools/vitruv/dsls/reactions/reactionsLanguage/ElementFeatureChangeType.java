/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.reactions.reactionsLanguage;

import org.eclipse.emf.ecore.EObject;

import tools.vitruv.dsls.mirbase.mirBase.MetaclassFeatureReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Feature Change Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.ElementFeatureChangeType#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getElementFeatureChangeType()
 * @model
 * @generated
 */
public interface ElementFeatureChangeType extends EObject
{
  /**
   * Returns the value of the '<em><b>Feature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' containment reference.
   * @see #setFeature(MetaclassFeatureReference)
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getElementFeatureChangeType_Feature()
   * @model containment="true"
   * @generated
   */
  MetaclassFeatureReference getFeature();

  /**
   * Sets the value of the '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ElementFeatureChangeType#getFeature <em>Feature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' containment reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(MetaclassFeatureReference value);

} // ElementFeatureChangeType
