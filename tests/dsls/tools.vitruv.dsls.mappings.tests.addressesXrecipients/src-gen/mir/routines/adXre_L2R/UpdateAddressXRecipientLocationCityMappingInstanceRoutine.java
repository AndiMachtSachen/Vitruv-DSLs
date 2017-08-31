package mir.routines.adXre_L2R;

import edu.kit.ipd.sdq.mdsd.addresses.Address;
import edu.kit.ipd.sdq.mdsd.addresses.Addresses;
import edu.kit.ipd.sdq.mdsd.recipients.City;
import edu.kit.ipd.sdq.mdsd.recipients.Location;
import edu.kit.ipd.sdq.mdsd.recipients.Recipient;
import edu.kit.ipd.sdq.mdsd.recipients.Recipients;
import java.io.IOException;
import mir.routines.adXre_L2R.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import tools.vitruv.dsls.mappings.tests.addressesXrecipients.mappings.aXr_all_or_nothing.conditions.AddressXRecipientLocationCityConditions;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class UpdateAddressXRecipientLocationCityMappingInstanceRoutine extends AbstractRepairRoutineRealization {
  private RoutinesFacade actionsFacade;
  
  private UpdateAddressXRecipientLocationCityMappingInstanceRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public String getRetrieveTag4(final Addresses aRoot, final Address a, final Recipients rRoot, final Recipient r, final Location l) {
      return "AddressXRecipientLocationCityMapping";
    }
    
    public EObject getCorrepondenceSourceRRoot(final Addresses aRoot, final Address a) {
      return aRoot;
    }
    
    public EObject getCorrepondenceSourceR(final Addresses aRoot, final Address a, final Recipients rRoot) {
      return a;
    }
    
    public String getRetrieveTag1(final Addresses aRoot, final Address a) {
      return "AdRootXReRootMapping";
    }
    
    public EObject getCorrepondenceSourceC(final Addresses aRoot, final Address a, final Recipients rRoot, final Recipient r, final Location l) {
      return a;
    }
    
    public String getRetrieveTag2(final Addresses aRoot, final Address a, final Recipients rRoot) {
      return "AddressXRecipientLocationCityMapping";
    }
    
    public String getRetrieveTag3(final Addresses aRoot, final Address a, final Recipients rRoot, final Recipient r) {
      return "AddressXRecipientLocationCityMapping";
    }
    
    public boolean checkMatcherPrecondition1(final Addresses aRoot, final Address a, final Recipients rRoot, final Recipient r, final Location l, final City c) {
      return AddressXRecipientLocationCityConditions.addressXRecipientLocationCityConditions().checkLeftConditions(aRoot, a);
    }
    
    public EObject getCorrepondenceSourceL(final Addresses aRoot, final Address a, final Recipients rRoot, final Recipient r) {
      return a;
    }
    
    public void callRoutine1(final Addresses aRoot, final Address a, final Recipients rRoot, final Recipient r, final Location l, final City c, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.enforceAddressXRecipientLocationCityMappingConditionsFromLeftToRight(aRoot, rRoot, a, r, l, c);
    }
  }
  
  public UpdateAddressXRecipientLocationCityMappingInstanceRoutine(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final Addresses aRoot, final Address a) {
    super(reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.adXre_L2R.UpdateAddressXRecipientLocationCityMappingInstanceRoutine.ActionUserExecution(getExecutionState(), this);
    this.actionsFacade = new mir.routines.adXre_L2R.RoutinesFacade(getExecutionState(), this);
    this.aRoot = aRoot;this.a = a;
  }
  
  private Addresses aRoot;
  
  private Address a;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine UpdateAddressXRecipientLocationCityMappingInstanceRoutine with input:");
    getLogger().debug("   aRoot: " + this.aRoot);
    getLogger().debug("   a: " + this.a);
    
    edu.kit.ipd.sdq.mdsd.recipients.Recipients rRoot = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceRRoot(aRoot, a), // correspondence source supplier
    	edu.kit.ipd.sdq.mdsd.recipients.Recipients.class,
    	(edu.kit.ipd.sdq.mdsd.recipients.Recipients _element) -> true, // correspondence precondition checker
    	userExecution.getRetrieveTag1(aRoot, a));
    if (rRoot == null) {
    	return;
    }
    registerObjectUnderModification(rRoot);
    edu.kit.ipd.sdq.mdsd.recipients.Recipient r = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceR(aRoot, a, rRoot), // correspondence source supplier
    	edu.kit.ipd.sdq.mdsd.recipients.Recipient.class,
    	(edu.kit.ipd.sdq.mdsd.recipients.Recipient _element) -> true, // correspondence precondition checker
    	userExecution.getRetrieveTag2(aRoot, a, rRoot));
    if (r == null) {
    	return;
    }
    registerObjectUnderModification(r);
    edu.kit.ipd.sdq.mdsd.recipients.Location l = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceL(aRoot, a, rRoot, r), // correspondence source supplier
    	edu.kit.ipd.sdq.mdsd.recipients.Location.class,
    	(edu.kit.ipd.sdq.mdsd.recipients.Location _element) -> true, // correspondence precondition checker
    	userExecution.getRetrieveTag3(aRoot, a, rRoot, r));
    if (l == null) {
    	return;
    }
    registerObjectUnderModification(l);
    edu.kit.ipd.sdq.mdsd.recipients.City c = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceC(aRoot, a, rRoot, r, l), // correspondence source supplier
    	edu.kit.ipd.sdq.mdsd.recipients.City.class,
    	(edu.kit.ipd.sdq.mdsd.recipients.City _element) -> true, // correspondence precondition checker
    	userExecution.getRetrieveTag4(aRoot, a, rRoot, r, l));
    if (c == null) {
    	return;
    }
    registerObjectUnderModification(c);
    if (!userExecution.checkMatcherPrecondition1(aRoot, a, rRoot, r, l, c)) {
    	return;
    }
    userExecution.callRoutine1(aRoot, a, rRoot, r, l, c, actionsFacade);
    
    postprocessElements();
  }
}
