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
	id = "eu.fidli.markersToSelection.SetEndingMarkerForCurrentFile"
)
@ActionRegistration(
	displayName = "#CTL_SetEndingMarkerForCurrentFile"
)
@ActionReferences({
    @ActionReference(path = "Menu/Edit", position = 1250),
    @ActionReference(path = "Shortcuts", name = "O-W")
})
@Messages("CTL_SetEndingMarkerForCurrentFile=Set ending marker")
public final class SetEndingMarkerForCurrentFile extends MarkerBase {

    @Override
    protected void doEditorAction(JTextComponent textComponent, OpenedFileData fileData) {
	fileData.markerEnd = getCaretPosition(textComponent);
    }

  
}
