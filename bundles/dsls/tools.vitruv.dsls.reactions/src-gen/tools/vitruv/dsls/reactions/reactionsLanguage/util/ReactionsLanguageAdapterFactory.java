/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.reactions.reactionsLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tools.vitruv.dsls.mirbase.mirBase.MetaclassReference;
import tools.vitruv.dsls.mirbase.mirBase.MirBaseFile;

import tools.vitruv.dsls.reactions.reactionsLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage
 * @generated
 */
public class ReactionsLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ReactionsLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionsLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ReactionsLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReactionsLanguageSwitch<Adapter> modelSwitch =
    new ReactionsLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseReactionsFile(ReactionsFile object)
      {
        return createReactionsFileAdapter();
      }
      @Override
      public Adapter caseReactionsSegment(ReactionsSegment object)
      {
        return createReactionsSegmentAdapter();
      }
      @Override
      public Adapter caseReaction(Reaction object)
      {
        return createReactionAdapter();
      }
      @Override
      public Adapter caseReactionRoutineCall(ReactionRoutineCall object)
      {
        return createReactionRoutineCallAdapter();
      }
      @Override
      public Adapter caseInvariantViolationEvent(InvariantViolationEvent object)
      {
        return createInvariantViolationEventAdapter();
      }
      @Override
      public Adapter caseTrigger(Trigger object)
      {
        return createTriggerAdapter();
      }
      @Override
      public Adapter caseModelChange(ModelChange object)
      {
        return createModelChangeAdapter();
      }
      @Override
      public Adapter caseConcreteModelElementChange(ConcreteModelElementChange object)
      {
        return createConcreteModelElementChangeAdapter();
      }
      @Override
      public Adapter caseAtomicConcreteModelElementChange(AtomicConcreteModelElementChange object)
      {
        return createAtomicConcreteModelElementChangeAdapter();
      }
      @Override
      public Adapter caseAtomicRootObjectChange(AtomicRootObjectChange object)
      {
        return createAtomicRootObjectChangeAdapter();
      }
      @Override
      public Adapter caseAtomicFeatureChange(AtomicFeatureChange object)
      {
        return createAtomicFeatureChangeAdapter();
      }
      @Override
      public Adapter caseAtomicMultiValuedFeatureChange(AtomicMultiValuedFeatureChange object)
      {
        return createAtomicMultiValuedFeatureChangeAdapter();
      }
      @Override
      public Adapter caseAtomicSingleValuedFeatureChange(AtomicSingleValuedFeatureChange object)
      {
        return createAtomicSingleValuedFeatureChangeAdapter();
      }
      @Override
      public Adapter caseArbitraryModelElementChange(ArbitraryModelElementChange object)
      {
        return createArbitraryModelElementChangeAdapter();
      }
      @Override
      public Adapter caseRoutine(Routine object)
      {
        return createRoutineAdapter();
      }
      @Override
      public Adapter caseRoutineInput(RoutineInput object)
      {
        return createRoutineInputAdapter();
      }
      @Override
      public Adapter caseMatcher(Matcher object)
      {
        return createMatcherAdapter();
      }
      @Override
      public Adapter caseMatcherStatement(MatcherStatement object)
      {
        return createMatcherStatementAdapter();
      }
      @Override
      public Adapter caseRetrieveModelElement(RetrieveModelElement object)
      {
        return createRetrieveModelElementAdapter();
      }
      @Override
      public Adapter caseMatcherCheckStatement(MatcherCheckStatement object)
      {
        return createMatcherCheckStatementAdapter();
      }
      @Override
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
      }
      @Override
      public Adapter caseRoutineCallStatement(RoutineCallStatement object)
      {
        return createRoutineCallStatementAdapter();
      }
      @Override
      public Adapter caseActionStatement(ActionStatement object)
      {
        return createActionStatementAdapter();
      }
      @Override
      public Adapter caseCreateModelElement(CreateModelElement object)
      {
        return createCreateModelElementAdapter();
      }
      @Override
      public Adapter caseDeleteModelElement(DeleteModelElement object)
      {
        return createDeleteModelElementAdapter();
      }
      @Override
      public Adapter caseUpdateModelElement(UpdateModelElement object)
      {
        return createUpdateModelElementAdapter();
      }
      @Override
      public Adapter caseCreateCorrespondence(CreateCorrespondence object)
      {
        return createCreateCorrespondenceAdapter();
      }
      @Override
      public Adapter caseRemoveCorrespondence(RemoveCorrespondence object)
      {
        return createRemoveCorrespondenceAdapter();
      }
      @Override
      public Adapter caseCodeBlock(CodeBlock object)
      {
        return createCodeBlockAdapter();
      }
      @Override
      public Adapter caseExecuteActionBlock(ExecuteActionBlock object)
      {
        return createExecuteActionBlockAdapter();
      }
      @Override
      public Adapter caseRoutineCallBlock(RoutineCallBlock object)
      {
        return createRoutineCallBlockAdapter();
      }
      @Override
      public Adapter caseTaggable(Taggable object)
      {
        return createTaggableAdapter();
      }
      @Override
      public Adapter caseExistingElementReference(ExistingElementReference object)
      {
        return createExistingElementReferenceAdapter();
      }
      @Override
      public Adapter caseTagCodeBlock(TagCodeBlock object)
      {
        return createTagCodeBlockAdapter();
      }
      @Override
      public Adapter casePreconditionCodeBlock(PreconditionCodeBlock object)
      {
        return createPreconditionCodeBlockAdapter();
      }
      @Override
      public Adapter caseCorrespondingObjectCodeBlock(CorrespondingObjectCodeBlock object)
      {
        return createCorrespondingObjectCodeBlockAdapter();
      }
      @Override
      public Adapter caseExecutionCodeBlock(ExecutionCodeBlock object)
      {
        return createExecutionCodeBlockAdapter();
      }
      @Override
      public Adapter caseReturnStatement(ReturnStatement object)
      {
        return createReturnStatementAdapter();
      }
      @Override
      public Adapter caseInsertRootChange(InsertRootChange object)
      {
        return createInsertRootChangeAdapter();
      }
      @Override
      public Adapter caseRemoveRootChange(RemoveRootChange object)
      {
        return createRemoveRootChangeAdapter();
      }
      @Override
      public Adapter caseMultiValuedFeatureInsertChange(MultiValuedFeatureInsertChange object)
      {
        return createMultiValuedFeatureInsertChangeAdapter();
      }
      @Override
      public Adapter caseMultiValuedFeatureRemoveChange(MultiValuedFeatureRemoveChange object)
      {
        return createMultiValuedFeatureRemoveChangeAdapter();
      }
      @Override
      public Adapter caseMultiValuedFeaturePermuteChange(MultiValuedFeaturePermuteChange object)
      {
        return createMultiValuedFeaturePermuteChangeAdapter();
      }
      @Override
      public Adapter caseSingleValuedFeatureReplace(SingleValuedFeatureReplace object)
      {
        return createSingleValuedFeatureReplaceAdapter();
      }
      @Override
      public Adapter caseMirBaseFile(MirBaseFile object)
      {
        return createMirBaseFileAdapter();
      }
      @Override
      public Adapter caseMetaclassReference(MetaclassReference object)
      {
        return createMetaclassReferenceAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsFile <em>Reactions File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsFile
   * @generated
   */
  public Adapter createReactionsFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment <em>Reactions Segment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment
   * @generated
   */
  public Adapter createReactionsSegmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.Reaction <em>Reaction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.Reaction
   * @generated
   */
  public Adapter createReactionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReactionRoutineCall <em>Reaction Routine Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReactionRoutineCall
   * @generated
   */
  public Adapter createReactionRoutineCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.InvariantViolationEvent <em>Invariant Violation Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.InvariantViolationEvent
   * @generated
   */
  public Adapter createInvariantViolationEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.Trigger
   * @generated
   */
  public Adapter createTriggerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ModelChange <em>Model Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ModelChange
   * @generated
   */
  public Adapter createModelChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ConcreteModelElementChange <em>Concrete Model Element Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ConcreteModelElementChange
   * @generated
   */
  public Adapter createConcreteModelElementChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.AtomicConcreteModelElementChange <em>Atomic Concrete Model Element Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.AtomicConcreteModelElementChange
   * @generated
   */
  public Adapter createAtomicConcreteModelElementChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.AtomicRootObjectChange <em>Atomic Root Object Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.AtomicRootObjectChange
   * @generated
   */
  public Adapter createAtomicRootObjectChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.AtomicFeatureChange <em>Atomic Feature Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.AtomicFeatureChange
   * @generated
   */
  public Adapter createAtomicFeatureChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.AtomicMultiValuedFeatureChange <em>Atomic Multi Valued Feature Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.AtomicMultiValuedFeatureChange
   * @generated
   */
  public Adapter createAtomicMultiValuedFeatureChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.AtomicSingleValuedFeatureChange <em>Atomic Single Valued Feature Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.AtomicSingleValuedFeatureChange
   * @generated
   */
  public Adapter createAtomicSingleValuedFeatureChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ArbitraryModelElementChange <em>Arbitrary Model Element Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ArbitraryModelElementChange
   * @generated
   */
  public Adapter createArbitraryModelElementChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.Routine <em>Routine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.Routine
   * @generated
   */
  public Adapter createRoutineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.RoutineInput <em>Routine Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.RoutineInput
   * @generated
   */
  public Adapter createRoutineInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.Matcher <em>Matcher</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.Matcher
   * @generated
   */
  public Adapter createMatcherAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.MatcherStatement <em>Matcher Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.MatcherStatement
   * @generated
   */
  public Adapter createMatcherStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.RetrieveModelElement <em>Retrieve Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.RetrieveModelElement
   * @generated
   */
  public Adapter createRetrieveModelElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.MatcherCheckStatement <em>Matcher Check Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.MatcherCheckStatement
   * @generated
   */
  public Adapter createMatcherCheckStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.RoutineCallStatement <em>Routine Call Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.RoutineCallStatement
   * @generated
   */
  public Adapter createRoutineCallStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ActionStatement <em>Action Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ActionStatement
   * @generated
   */
  public Adapter createActionStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.CreateModelElement <em>Create Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.CreateModelElement
   * @generated
   */
  public Adapter createCreateModelElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.DeleteModelElement <em>Delete Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.DeleteModelElement
   * @generated
   */
  public Adapter createDeleteModelElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.UpdateModelElement <em>Update Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.UpdateModelElement
   * @generated
   */
  public Adapter createUpdateModelElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.CreateCorrespondence <em>Create Correspondence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.CreateCorrespondence
   * @generated
   */
  public Adapter createCreateCorrespondenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.RemoveCorrespondence <em>Remove Correspondence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.RemoveCorrespondence
   * @generated
   */
  public Adapter createRemoveCorrespondenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.CodeBlock <em>Code Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.CodeBlock
   * @generated
   */
  public Adapter createCodeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ExecuteActionBlock <em>Execute Action Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ExecuteActionBlock
   * @generated
   */
  public Adapter createExecuteActionBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.RoutineCallBlock <em>Routine Call Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.RoutineCallBlock
   * @generated
   */
  public Adapter createRoutineCallBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.Taggable <em>Taggable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.Taggable
   * @generated
   */
  public Adapter createTaggableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ExistingElementReference <em>Existing Element Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ExistingElementReference
   * @generated
   */
  public Adapter createExistingElementReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.TagCodeBlock <em>Tag Code Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.TagCodeBlock
   * @generated
   */
  public Adapter createTagCodeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.PreconditionCodeBlock <em>Precondition Code Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.PreconditionCodeBlock
   * @generated
   */
  public Adapter createPreconditionCodeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.CorrespondingObjectCodeBlock <em>Corresponding Object Code Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.CorrespondingObjectCodeBlock
   * @generated
   */
  public Adapter createCorrespondingObjectCodeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ExecutionCodeBlock <em>Execution Code Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ExecutionCodeBlock
   * @generated
   */
  public Adapter createExecutionCodeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.ReturnStatement
   * @generated
   */
  public Adapter createReturnStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.InsertRootChange <em>Insert Root Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.InsertRootChange
   * @generated
   */
  public Adapter createInsertRootChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.RemoveRootChange <em>Remove Root Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.RemoveRootChange
   * @generated
   */
  public Adapter createRemoveRootChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.MultiValuedFeatureInsertChange <em>Multi Valued Feature Insert Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.MultiValuedFeatureInsertChange
   * @generated
   */
  public Adapter createMultiValuedFeatureInsertChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.MultiValuedFeatureRemoveChange <em>Multi Valued Feature Remove Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.MultiValuedFeatureRemoveChange
   * @generated
   */
  public Adapter createMultiValuedFeatureRemoveChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.MultiValuedFeaturePermuteChange <em>Multi Valued Feature Permute Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.MultiValuedFeaturePermuteChange
   * @generated
   */
  public Adapter createMultiValuedFeaturePermuteChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.reactions.reactionsLanguage.SingleValuedFeatureReplace <em>Single Valued Feature Replace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.reactions.reactionsLanguage.SingleValuedFeatureReplace
   * @generated
   */
  public Adapter createSingleValuedFeatureReplaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.mirbase.mirBase.MirBaseFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.mirbase.mirBase.MirBaseFile
   * @generated
   */
  public Adapter createMirBaseFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tools.vitruv.dsls.mirbase.mirBase.MetaclassReference <em>Metaclass Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tools.vitruv.dsls.mirbase.mirBase.MetaclassReference
   * @generated
   */
  public Adapter createMetaclassReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ReactionsLanguageAdapterFactory
