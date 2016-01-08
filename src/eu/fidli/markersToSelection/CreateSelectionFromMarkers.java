/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fidli.markersToSelection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.text.JTextComponent;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.cookies.EditorCookie;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@ActionID(
	category = "Edit",
	id = "eu.fidli.markersToSelection.CreateSelectionFromMarkers"
)
@ActionRegistration(
	displayName = "#CTL_CreateSelectionFromMarkers"	
)
@ActionReferences({
    @ActionReference(path = "Menu/Edit", position = 1250),
    @ActionReference(path = "Shortcuts", name = "O-E"),
})
@Messages("CTL_CreateSelectionFromMarkers=Create selection from markers")
public final class CreateSelectionFromMarkers extends MarkerBase {

  
    
    @Override
    protected void doEditorAction(JTextComponent textComponent, OpenedFileData fileData) {
	int textLength = textComponent.getDocument().getLength();
	int markerEnd;
	int markerStart;
	if(fileData.markerEnd > fileData.markerStart){
	    markerEnd = fileData.markerEnd;
	    markerStart = fileData.markerStart;
	}else{
	    markerStart = fileData.markerEnd;
	    markerEnd = fileData.markerStart;
	}
	if(markerEnd >= 0 && markerStart >= 0 && markerEnd != markerStart && markerStart < textLength && markerEnd < textLength){
	    textComponent.setSelectionStart(markerStart);
	    textComponent.setSelectionEnd(markerEnd);
	  
	}
    }

  
}
