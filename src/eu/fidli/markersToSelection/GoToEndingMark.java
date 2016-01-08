/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fidli.markersToSelection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.JTextComponent;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
	category = "Edit",
	id = "eu.fidli.markersToSelection.GoToEndingMark"
)
@ActionRegistration(
	displayName = "#CTL_GoToEndingMark"
)
@ActionReferences({
    @ActionReference(path = "Menu/GoTo", position = 275),
    @ActionReference(path = "Shortcuts", name = "O-S")
})
@Messages("CTL_GoToEndingMark=Go to ending mark")
public final class GoToEndingMark extends MarkerBase{

   @Override
    protected void doEditorAction(JTextComponent textComponent, OpenedFileData fileData) {
	if(fileData.markerEnd != -1){
	    textComponent.getCaret().setDot(fileData.markerEnd);
	}
    }
}
