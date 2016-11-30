/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.mirbase.mirBase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see tools.vitruv.dsls.mirbase.mirBase.MirBaseFactory
 * @model kind="package"
 * @generated
 */
public interface MirBasePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mirBase";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.kit.edu/ipd/sdq/vitruvius/dsls/mirbase/MirBase";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mirBase";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MirBasePackage eINSTANCE = tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl.init();

  /**
   * The meta object id for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.MirBaseFileImpl <em>File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBaseFileImpl
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getMirBaseFile()
   * @generated
   */
  int MIR_BASE_FILE = 1;

  /**
   * The feature id for the '<em><b>Metamodel Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIR_BASE_FILE__METAMODEL_IMPORTS = 0;

  /**
   * The number of structural features of the '<em>File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIR_BASE_FILE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.DummyEntryRuleImpl <em>Dummy Entry Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.DummyEntryRuleImpl
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getDummyEntryRule()
   * @generated
   */
  int DUMMY_ENTRY_RULE = 0;

  /**
   * The feature id for the '<em><b>Metamodel Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DUMMY_ENTRY_RULE__METAMODEL_IMPORTS = MIR_BASE_FILE__METAMODEL_IMPORTS;

  /**
   * The number of structural features of the '<em>Dummy Entry Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DUMMY_ENTRY_RULE_FEATURE_COUNT = MIR_BASE_FILE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.MetamodelImportImpl <em>Metamodel Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MetamodelImportImpl
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getMetamodelImport()
   * @generated
   */
  int METAMODEL_IMPORT = 2;

  /**
   * The feature id for the '<em><b>Package</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_IMPORT__PACKAGE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_IMPORT__NAME = 1;

  /**
   * The feature id for the '<em><b>Use Qualified Names</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_IMPORT__USE_QUALIFIED_NAMES = 2;

  /**
   * The number of structural features of the '<em>Metamodel Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_IMPORT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.NamedJavaElementImpl <em>Named Java Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.NamedJavaElementImpl
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getNamedJavaElement()
   * @generated
   */
  int NAMED_JAVA_ELEMENT = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_JAVA_ELEMENT__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_JAVA_ELEMENT__NAME = 1;

  /**
   * The number of structural features of the '<em>Named Java Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_JAVA_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.MetaclassReferenceImpl <em>Metaclass Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MetaclassReferenceImpl
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getMetaclassReference()
   * @generated
   */
  int METACLASS_REFERENCE = 4;

  /**
   * The feature id for the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METACLASS_REFERENCE__METAMODEL = 0;

  /**
   * The feature id for the '<em><b>Metaclass</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METACLASS_REFERENCE__METACLASS = 1;

  /**
   * The number of structural features of the '<em>Metaclass Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METACLASS_REFERENCE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.NamedMetaclassReferenceImpl <em>Named Metaclass Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.NamedMetaclassReferenceImpl
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getNamedMetaclassReference()
   * @generated
   */
  int NAMED_METACLASS_REFERENCE = 5;

  /**
   * The feature id for the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_METACLASS_REFERENCE__METAMODEL = METACLASS_REFERENCE__METAMODEL;

  /**
   * The feature id for the '<em><b>Metaclass</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_METACLASS_REFERENCE__METACLASS = METACLASS_REFERENCE__METACLASS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_METACLASS_REFERENCE__NAME = METACLASS_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named Metaclass Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_METACLASS_REFERENCE_FEATURE_COUNT = METACLASS_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.MetaclassFeatureReferenceImpl <em>Metaclass Feature Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MetaclassFeatureReferenceImpl
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getMetaclassFeatureReference()
   * @generated
   */
  int METACLASS_FEATURE_REFERENCE = 6;

  /**
   * The feature id for the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METACLASS_FEATURE_REFERENCE__METAMODEL = METACLASS_REFERENCE__METAMODEL;

  /**
   * The feature id for the '<em><b>Metaclass</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METACLASS_FEATURE_REFERENCE__METACLASS = METACLASS_REFERENCE__METACLASS;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METACLASS_FEATURE_REFERENCE__FEATURE = METACLASS_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Metaclass Feature Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METACLASS_FEATURE_REFERENCE_FEATURE_COUNT = METACLASS_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.MetamodelReferenceImpl <em>Metamodel Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MetamodelReferenceImpl
   * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getMetamodelReference()
   * @generated
   */
  int METAMODEL_REFERENCE = 7;

  /**
   * The feature id for the '<em><b>Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_REFERENCE__MODEL = 0;

  /**
   * The number of structural features of the '<em>Metamodel Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_REFERENCE_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link tools.vitruv.dsls.mirbase.mirBase.DummyEntryRule <em>Dummy Entry Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dummy Entry Rule</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.DummyEntryRule
   * @generated
   */
  EClass getDummyEntryRule();

  /**
   * Returns the meta object for class '{@link tools.vitruv.dsls.mirbase.mirBase.MirBaseFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>File</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MirBaseFile
   * @generated
   */
  EClass getMirBaseFile();

  /**
   * Returns the meta object for the containment reference list '{@link tools.vitruv.dsls.mirbase.mirBase.MirBaseFile#getMetamodelImports <em>Metamodel Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Metamodel Imports</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MirBaseFile#getMetamodelImports()
   * @see #getMirBaseFile()
   * @generated
   */
  EReference getMirBaseFile_MetamodelImports();

  /**
   * Returns the meta object for class '{@link tools.vitruv.dsls.mirbase.mirBase.MetamodelImport <em>Metamodel Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Metamodel Import</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetamodelImport
   * @generated
   */
  EClass getMetamodelImport();

  /**
   * Returns the meta object for the reference '{@link tools.vitruv.dsls.mirbase.mirBase.MetamodelImport#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Package</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetamodelImport#getPackage()
   * @see #getMetamodelImport()
   * @generated
   */
  EReference getMetamodelImport_Package();

  /**
   * Returns the meta object for the attribute '{@link tools.vitruv.dsls.mirbase.mirBase.MetamodelImport#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetamodelImport#getName()
   * @see #getMetamodelImport()
   * @generated
   */
  EAttribute getMetamodelImport_Name();

  /**
   * Returns the meta object for the attribute '{@link tools.vitruv.dsls.mirbase.mirBase.MetamodelImport#isUseQualifiedNames <em>Use Qualified Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Use Qualified Names</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetamodelImport#isUseQualifiedNames()
   * @see #getMetamodelImport()
   * @generated
   */
  EAttribute getMetamodelImport_UseQualifiedNames();

  /**
   * Returns the meta object for class '{@link tools.vitruv.dsls.mirbase.mirBase.NamedJavaElement <em>Named Java Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Java Element</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.NamedJavaElement
   * @generated
   */
  EClass getNamedJavaElement();

  /**
   * Returns the meta object for the containment reference '{@link tools.vitruv.dsls.mirbase.mirBase.NamedJavaElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.NamedJavaElement#getType()
   * @see #getNamedJavaElement()
   * @generated
   */
  EReference getNamedJavaElement_Type();

  /**
   * Returns the meta object for the attribute '{@link tools.vitruv.dsls.mirbase.mirBase.NamedJavaElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.NamedJavaElement#getName()
   * @see #getNamedJavaElement()
   * @generated
   */
  EAttribute getNamedJavaElement_Name();

  /**
   * Returns the meta object for class '{@link tools.vitruv.dsls.mirbase.mirBase.MetaclassReference <em>Metaclass Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Metaclass Reference</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetaclassReference
   * @generated
   */
  EClass getMetaclassReference();

  /**
   * Returns the meta object for the reference '{@link tools.vitruv.dsls.mirbase.mirBase.MetaclassReference#getMetamodel <em>Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Metamodel</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetaclassReference#getMetamodel()
   * @see #getMetaclassReference()
   * @generated
   */
  EReference getMetaclassReference_Metamodel();

  /**
   * Returns the meta object for the reference '{@link tools.vitruv.dsls.mirbase.mirBase.MetaclassReference#getMetaclass <em>Metaclass</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Metaclass</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetaclassReference#getMetaclass()
   * @see #getMetaclassReference()
   * @generated
   */
  EReference getMetaclassReference_Metaclass();

  /**
   * Returns the meta object for class '{@link tools.vitruv.dsls.mirbase.mirBase.NamedMetaclassReference <em>Named Metaclass Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Metaclass Reference</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.NamedMetaclassReference
   * @generated
   */
  EClass getNamedMetaclassReference();

  /**
   * Returns the meta object for the attribute '{@link tools.vitruv.dsls.mirbase.mirBase.NamedMetaclassReference#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.NamedMetaclassReference#getName()
   * @see #getNamedMetaclassReference()
   * @generated
   */
  EAttribute getNamedMetaclassReference_Name();

  /**
   * Returns the meta object for class '{@link tools.vitruv.dsls.mirbase.mirBase.MetaclassFeatureReference <em>Metaclass Feature Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Metaclass Feature Reference</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetaclassFeatureReference
   * @generated
   */
  EClass getMetaclassFeatureReference();

  /**
   * Returns the meta object for the reference '{@link tools.vitruv.dsls.mirbase.mirBase.MetaclassFeatureReference#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetaclassFeatureReference#getFeature()
   * @see #getMetaclassFeatureReference()
   * @generated
   */
  EReference getMetaclassFeatureReference_Feature();

  /**
   * Returns the meta object for class '{@link tools.vitruv.dsls.mirbase.mirBase.MetamodelReference <em>Metamodel Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Metamodel Reference</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetamodelReference
   * @generated
   */
  EClass getMetamodelReference();

  /**
   * Returns the meta object for the reference '{@link tools.vitruv.dsls.mirbase.mirBase.MetamodelReference#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Model</em>'.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetamodelReference#getModel()
   * @see #getMetamodelReference()
   * @generated
   */
  EReference getMetamodelReference_Model();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MirBaseFactory getMirBaseFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.DummyEntryRuleImpl <em>Dummy Entry Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.DummyEntryRuleImpl
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getDummyEntryRule()
     * @generated
     */
    EClass DUMMY_ENTRY_RULE = eINSTANCE.getDummyEntryRule();

    /**
     * The meta object literal for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.MirBaseFileImpl <em>File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBaseFileImpl
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getMirBaseFile()
     * @generated
     */
    EClass MIR_BASE_FILE = eINSTANCE.getMirBaseFile();

    /**
     * The meta object literal for the '<em><b>Metamodel Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MIR_BASE_FILE__METAMODEL_IMPORTS = eINSTANCE.getMirBaseFile_MetamodelImports();

    /**
     * The meta object literal for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.MetamodelImportImpl <em>Metamodel Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MetamodelImportImpl
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getMetamodelImport()
     * @generated
     */
    EClass METAMODEL_IMPORT = eINSTANCE.getMetamodelImport();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METAMODEL_IMPORT__PACKAGE = eINSTANCE.getMetamodelImport_Package();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METAMODEL_IMPORT__NAME = eINSTANCE.getMetamodelImport_Name();

    /**
     * The meta object literal for the '<em><b>Use Qualified Names</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METAMODEL_IMPORT__USE_QUALIFIED_NAMES = eINSTANCE.getMetamodelImport_UseQualifiedNames();

    /**
     * The meta object literal for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.NamedJavaElementImpl <em>Named Java Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.NamedJavaElementImpl
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getNamedJavaElement()
     * @generated
     */
    EClass NAMED_JAVA_ELEMENT = eINSTANCE.getNamedJavaElement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_JAVA_ELEMENT__TYPE = eINSTANCE.getNamedJavaElement_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_JAVA_ELEMENT__NAME = eINSTANCE.getNamedJavaElement_Name();

    /**
     * The meta object literal for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.MetaclassReferenceImpl <em>Metaclass Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MetaclassReferenceImpl
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getMetaclassReference()
     * @generated
     */
    EClass METACLASS_REFERENCE = eINSTANCE.getMetaclassReference();

    /**
     * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METACLASS_REFERENCE__METAMODEL = eINSTANCE.getMetaclassReference_Metamodel();

    /**
     * The meta object literal for the '<em><b>Metaclass</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METACLASS_REFERENCE__METACLASS = eINSTANCE.getMetaclassReference_Metaclass();

    /**
     * The meta object literal for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.NamedMetaclassReferenceImpl <em>Named Metaclass Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.NamedMetaclassReferenceImpl
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getNamedMetaclassReference()
     * @generated
     */
    EClass NAMED_METACLASS_REFERENCE = eINSTANCE.getNamedMetaclassReference();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_METACLASS_REFERENCE__NAME = eINSTANCE.getNamedMetaclassReference_Name();

    /**
     * The meta object literal for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.MetaclassFeatureReferenceImpl <em>Metaclass Feature Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MetaclassFeatureReferenceImpl
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getMetaclassFeatureReference()
     * @generated
     */
    EClass METACLASS_FEATURE_REFERENCE = eINSTANCE.getMetaclassFeatureReference();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METACLASS_FEATURE_REFERENCE__FEATURE = eINSTANCE.getMetaclassFeatureReference_Feature();

    /**
     * The meta object literal for the '{@link tools.vitruv.dsls.mirbase.mirBase.impl.MetamodelReferenceImpl <em>Metamodel Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MetamodelReferenceImpl
     * @see tools.vitruv.dsls.mirbase.mirBase.impl.MirBasePackageImpl#getMetamodelReference()
     * @generated
     */
    EClass METAMODEL_REFERENCE = eINSTANCE.getMetamodelReference();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METAMODEL_REFERENCE__MODEL = eINSTANCE.getMetamodelReference_Model();

  }

} //MirBasePackage
