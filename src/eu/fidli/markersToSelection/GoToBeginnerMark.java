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
	id = "eu.fidli.markersToSelection.GoToBeginnerMark"
)
@ActionRegistration(
	displayName = "#CTL_GoToBeginnerMark"
)
@ActionReferences({
    @ActionReference(path = "Menu/GoTo", position = 275),
    @ActionReference(path = "Shortcuts", name = "O-A")
})
@Messages("CTL_GoToBeginnerMark=Go to beginning mark")
public final class GoToBeginnerMark extends MarkerBase
{

    @Override
    protected void doEditorAction(JTextComponent textComponent, OpenedFileData fileData) {
	if(fileData.markerStart != -1){
	    textComponent.getCaret().setDot(fileData.markerStart);
	}
    }


}
