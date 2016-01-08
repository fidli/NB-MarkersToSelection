/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fidli.markersToSelection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JEditorPane;
import javax.swing.text.JTextComponent;
import org.openide.cookies.EditorCookie;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author Fidli
 */
abstract public class MarkerBase implements ActionListener{
    
    public static HashMap<String, OpenedFileData> MarkerDatabase = new HashMap<String, OpenedFileData>();
    
    public TopComponent active = null;
    
    @Override
    public void actionPerformed(ActionEvent e) {
	active = TopComponent.getRegistry().getActivated();
	String activeId = WindowManager.getDefault().findTopComponentID(active);
	String className = active.getClass().getName();
	//we are editor
	if(className.equals("org.netbeans.core.multiview.MultiViewCloneableTopComponent")){
                 EditorCookie edit = (active.getActivatedNodes()[0]).getCookie(EditorCookie.class);
		 JEditorPane[] panes = edit.getOpenedPanes();
                 if (panes != null) {
                     for (int i = 0; i < panes.length; i++) {
                         if (active.isAncestorOf(panes[i])) {
			     
			     if (MarkerBase.MarkerDatabase.containsKey(activeId)){
				 if (active == null || !active.isOpened() || !active.isVisible()) {
				     MarkerBase.MarkerDatabase.remove(activeId);
				 } else {
				    doEditorAction(panes[i], MarkerBase.MarkerDatabase.get(activeId));
				 }
			     } else {
				 if (!(active == null || !active.isOpened() || !active.isVisible())) {
				     OpenedFileData ofd = new OpenedFileData();
				    doEditorAction(panes[i], ofd);
				     MarkerBase.MarkerDatabase.put(activeId, ofd);
				 }
			     }

			     
                             break;
                         }
                     }
                 }
	}
    }
    
    protected int getCaretPosition(final JTextComponent textComponent){
	return textComponent.getCaret().getDot();
    }
    
    abstract protected void doEditorAction(final JTextComponent textComponent, OpenedFileData fileData);
}
