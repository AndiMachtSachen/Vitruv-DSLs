/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.reactions.reactionsLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tools.vitruv.dsls.mirbase.mirBase.MetamodelReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reactions Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment#getName <em>Name</em>}</li>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment#getFromMetamodel <em>From Metamodel</em>}</li>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment#getToMetamodel <em>To Metamodel</em>}</li>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment#getReactions <em>Reactions</em>}</li>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment#getRoutines <em>Routines</em>}</li>
 * </ul>
 *
 * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getReactionsSegment()
 * @model
 * @generated
 */
public interface ReactionsSegment extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getReactionsSegment_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>From Metamodel</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From Metamodel</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From Metamodel</em>' containment reference.
   * @see #setFromMetamodel(MetamodelReference)
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getReactionsSegment_FromMetamodel()
   * @model containment="true"
   * @generated
   */
  MetamodelReference getFromMetamodel();

  /**
   * Sets the value of the '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment#getFromMetamodel <em>From Metamodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From Metamodel</em>' containment reference.
   * @see #getFromMetamodel()
   * @generated
   */
  void setFromMetamodel(MetamodelReference value);

  /**
   * Returns the value of the '<em><b>To Metamodel</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Metamodel</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Metamodel</em>' containment reference.
   * @see #setToMetamodel(MetamodelReference)
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getReactionsSegment_ToMetamodel()
   * @model containment="true"
   * @generated
   */
  MetamodelReference getToMetamodel();

  /**
   * Sets the value of the '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment#getToMetamodel <em>To Metamodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Metamodel</em>' containment reference.
   * @see #getToMetamodel()
   * @generated
   */
  void setToMetamodel(MetamodelReference value);

  /**
   * Returns the value of the '<em><b>Reactions</b></em>' containment reference list.
   * The list contents are of type {@link tools.vitruv.dsls.reactions.reactionsLanguage.Reaction}.
   * It is bidirectional and its opposite is '{@link tools.vitruv.dsls.reactions.reactionsLanguage.Reaction#getReactionsSegment <em>Reactions Segment</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reactions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reactions</em>' containment reference list.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getReactionsSegment_Reactions()
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.Reaction#getReactionsSegment
   * @model opposite="reactionsSegment" containment="true"
   * @generated
   */
  EList<Reaction> getReactions();

  /**
   * Returns the value of the '<em><b>Routines</b></em>' containment reference list.
   * The list contents are of type {@link tools.vitruv.dsls.reactions.reactionsLanguage.Routine}.
   * It is bidirectional and its opposite is '{@link tools.vitruv.dsls.reactions.reactionsLanguage.Routine#getReactionsSegment <em>Reactions Segment</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Routines</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Routines</em>' containment reference list.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage#getReactionsSegment_Routines()
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.Routine#getReactionsSegment
   * @model opposite="reactionsSegment" containment="true"
   * @generated
   */
  EList<Routine> getRoutines();

} // ReactionsSegment
