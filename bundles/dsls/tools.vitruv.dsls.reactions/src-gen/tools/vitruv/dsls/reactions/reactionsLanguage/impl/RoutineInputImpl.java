/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.reactions.reactionsLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.vitruv.dsls.mirbase.mirBase.NamedJavaElement;
import tools.vitruv.dsls.mirbase.mirBase.NamedMetaclassReference;

import tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage;
import tools.vitruv.dsls.reactions.reactionsLanguage.RoutineInput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Routine Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.impl.RoutineInputImpl#getModelInputElements <em>Model Input Elements</em>}</li>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.impl.RoutineInputImpl#getJavaInputElements <em>Java Input Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoutineInputImpl extends MinimalEObjectImpl.Container implements RoutineInput
{
  /**
   * The cached value of the '{@link #getModelInputElements() <em>Model Input Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelInputElements()
   * @generated
   * @ordered
   */
  protected EList<NamedMetaclassReference> modelInputElements;

  /**
   * The cached value of the '{@link #getJavaInputElements() <em>Java Input Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaInputElements()
   * @generated
   * @ordered
   */
  protected EList<NamedJavaElement> javaInputElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RoutineInputImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ReactionsLanguagePackage.Literals.ROUTINE_INPUT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NamedMetaclassReference> getModelInputElements()
  {
    if (modelInputElements == null)
    {
      modelInputElements = new EObjectContainmentEList<NamedMetaclassReference>(NamedMetaclassReference.class, this, ReactionsLanguagePackage.ROUTINE_INPUT__MODEL_INPUT_ELEMENTS);
    }
    return modelInputElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NamedJavaElement> getJavaInputElements()
  {
    if (javaInputElements == null)
    {
      javaInputElements = new EObjectContainmentEList<NamedJavaElement>(NamedJavaElement.class, this, ReactionsLanguagePackage.ROUTINE_INPUT__JAVA_INPUT_ELEMENTS);
    }
    return javaInputElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.ROUTINE_INPUT__MODEL_INPUT_ELEMENTS:
        return ((InternalEList<?>)getModelInputElements()).basicRemove(otherEnd, msgs);
      case ReactionsLanguagePackage.ROUTINE_INPUT__JAVA_INPUT_ELEMENTS:
        return ((InternalEList<?>)getJavaInputElements()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.ROUTINE_INPUT__MODEL_INPUT_ELEMENTS:
        return getModelInputElements();
      case ReactionsLanguagePackage.ROUTINE_INPUT__JAVA_INPUT_ELEMENTS:
        return getJavaInputElements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.ROUTINE_INPUT__MODEL_INPUT_ELEMENTS:
        getModelInputElements().clear();
        getModelInputElements().addAll((Collection<? extends NamedMetaclassReference>)newValue);
        return;
      case ReactionsLanguagePackage.ROUTINE_INPUT__JAVA_INPUT_ELEMENTS:
        getJavaInputElements().clear();
        getJavaInputElements().addAll((Collection<? extends NamedJavaElement>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.ROUTINE_INPUT__MODEL_INPUT_ELEMENTS:
        getModelInputElements().clear();
        return;
      case ReactionsLanguagePackage.ROUTINE_INPUT__JAVA_INPUT_ELEMENTS:
        getJavaInputElements().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.ROUTINE_INPUT__MODEL_INPUT_ELEMENTS:
        return modelInputElements != null && !modelInputElements.isEmpty();
      case ReactionsLanguagePackage.ROUTINE_INPUT__JAVA_INPUT_ELEMENTS:
        return javaInputElements != null && !javaInputElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RoutineInputImpl
