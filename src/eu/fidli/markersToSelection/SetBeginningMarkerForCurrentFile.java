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
	id = "eu.fidli.markersToSelection.SetBeginningMarkerForCurrentFile"
)
@ActionRegistration(
	displayName = "#CTL_SetBeginningMarkerForCurrentFile"
)
@ActionReferences({
    @ActionReference(path = "Menu/Edit", position = 1250),
    @ActionReference(path = "Shortcuts", name = "O-Q")
})
@Messages("CTL_SetBeginningMarkerForCurrentFile=Set beginning marker")
public final class SetBeginningMarkerForCurrentFile extends MarkerBase {

    @Override
    protected void doEditorAction(JTextComponent textComponent, OpenedFileData fileData) {
	fileData.markerStart = getCaretPosition(textComponent);
    }

  
}
