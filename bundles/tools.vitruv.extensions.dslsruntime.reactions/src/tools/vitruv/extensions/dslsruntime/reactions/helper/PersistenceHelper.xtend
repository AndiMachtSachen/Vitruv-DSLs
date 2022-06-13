package tools.vitruv.extensions.dslsruntime.reactions.helper

import org.eclipse.emf.ecore.EObject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.URI
import static edu.kit.ipd.sdq.commons.util.org.eclipse.emf.common.util.URIUtil.getIFileForEMFUri
import static extension tools.vitruv.framework.propagation.ProjectMarker.getProjectRootFolder
import java.nio.file.Path
import static edu.kit.ipd.sdq.commons.util.org.eclipse.emf.common.util.URIUtil.createFileURI

final class PersistenceHelper {
	private new() {}
	
	static def EObject getModelRoot(EObject modelObject) {
		var result = modelObject
		while (result.eContainer !== null) {
			result = result.eContainer
		}
		return result
	}

	private static def URI getURIOfElementResourceFolder(EObject element) {
		return element.eResource.URI.trimSegments(1)
	}

	private static def URI getURIOfElementProject(EObject element) {
		val elementUri = element.eResource.URI
		if (elementUri.isPlatform) {
			val IFile sourceModelFile = getIFileForEMFUri(elementUri)
			val IProject projectSourceModel = sourceModelFile.project
			var String srcFolderPath = projectSourceModel.fullPath.toString
			return URI.createPlatformResourceURI(srcFolderPath, true)
		} else if (elementUri.isFile) {
			val elementPath = Path.of(elementUri.toFileString)
			return createFileURI(elementPath.projectRootFolder.toFile())
		} else {
			throw new UnsupportedOperationException("Other URI types than file and platform are currently not supported");
		}
	}

	private static def URI appendPathToURI(URI baseURI, String relativePath) {
		val newModelFileSegments = relativePath.split("/")
		if (!newModelFileSegments.last.contains(".")) {
			throw new IllegalArgumentException("File extension must be specified")
		}
		return baseURI.appendSegments(newModelFileSegments)
	}

	static def URI getURIFromSourceResourceFolder(EObject source, String relativePath) {
		val baseURI = getURIOfElementResourceFolder(source)
		return baseURI.appendPathToURI(relativePath)
	}
	
	/**
	 * Returns the URI of the project folder, relative as specified in <code>relativePath</code>
	 * to the project root, determined from the element <code>source</code>.
	 * 
	 * @param source -
	 * 		An {@link EObject} that is persisted within a resource of the project
	 * @param relativePath -
	 * 		The relative path within the project to get the {@link URI} for, using "/" as separator char
	 * 
	 * @returns the {@link URI} of the folder within the project of the given element
	 */
	static def URI getURIFromSourceProjectFolder(EObject source, String relativePath) {
		val baseURI = getURIOfElementProject(source);
		return baseURI.appendPathToURI(relativePath);
	}

}
