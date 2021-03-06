/**
 * 
 */
package actions;

import gui.DrawPane;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;



/**
 * @author Abdullah
 * @version 2/23/2016
 */
public class UndoAction extends AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = -3946015430555011037L;
   
    /**
     * This pane will be worked on.
     */
    private final DrawPane myPane;


    /**
     * @param thePane This pane will be erased.
     */
    public UndoAction(final DrawPane thePane) {
        super("Undo");
        myPane = thePane;
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_U);
        putValue(Action.SELECTED_KEY, true);
    }

   
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent theE) {
        myPane.reset();
    }
}
