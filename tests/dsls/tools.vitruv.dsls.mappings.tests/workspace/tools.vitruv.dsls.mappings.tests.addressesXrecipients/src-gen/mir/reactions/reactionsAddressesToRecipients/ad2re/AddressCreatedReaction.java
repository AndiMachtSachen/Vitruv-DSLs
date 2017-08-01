package mir.reactions.reactionsAddressesToRecipients.ad2re;

import edu.kit.ipd.sdq.mdsd.addresses.Address;
import mir.routines.ad2re.RoutinesFacade;
import org.eclipse.xtext.xbase.lib.Extension;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.eobject.CreateEObject;

@SuppressWarnings("all")
class AddressCreatedReaction extends AbstractReactionRealization {
  public void executeReaction(final EChange change) {
    CreateEObject<Address> typedChange = (CreateEObject<Address>)change;
    Address affectedEObject = typedChange.getAffectedEObject();
    mir.routines.ad2re.RoutinesFacade routinesFacade = new mir.routines.ad2re.RoutinesFacade(this.executionState, this);
    mir.reactions.reactionsAddressesToRecipients.ad2re.AddressCreatedReaction.ActionUserExecution userExecution = new mir.reactions.reactionsAddressesToRecipients.ad2re.AddressCreatedReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(affectedEObject, routinesFacade);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return CreateEObject.class;
  }
  
  private boolean checkChangeProperties(final EChange change) {
    CreateEObject<Address> relevantChange = (CreateEObject<Address>)change;
    if (!(relevantChange.getAffectedEObject() instanceof Address)) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof CreateEObject)) {
    	return false;
    }
    getLogger().debug("Passed change type check of reaction " + this.getClass().getName());
    if (!checkChangeProperties(change)) {
    	return false;
    }
    getLogger().debug("Passed change properties check of reaction " + this.getClass().getName());
    getLogger().debug("Passed complete precondition check of reaction " + this.getClass().getName());
    return true;
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final Address affectedEObject, @Extension final RoutinesFacade _routinesFacade) {
      AddressXRecipientLocationCityMapping.registerAddress(affectedEObject);
    }
  }
}
