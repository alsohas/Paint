/**
 * 
 */
package actions;

import gui.DrawPane;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author Abdullah
 * @version 11/13/2017
 */
public class ExitAction extends AbstractAction {


    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Draw pane.
     */
    private DrawPane myPane;
    
    /**
     * Parent frame.
     */
    private JFrame myFrame;




    /**
     * @param thePane pane.
     */
    public ExitAction(final DrawPane thePane) {
        myPane = thePane;
        myFrame = (JFrame) SwingUtilities.getWindowAncestor(myPane);
    }




    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myFrame.dispose();

    }

}
