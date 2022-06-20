package tools.vitruv.extensions.dslsruntime.reactions

import org.eclipse.emf.common.command.Command
import java.util.List
import tools.vitruv.change.atomic.EChange
import tools.vitruv.change.correspondence.CorrespondenceModel

interface ReactionsExecutor {
	def List<Command> generateCommandsForEvent(EChange change, CorrespondenceModel correspondenceModel);
}