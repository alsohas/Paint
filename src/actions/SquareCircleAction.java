/**
 * 
 */
package actions;

import gui.DrawPane;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;



/**
 * @author Abdullah
 * @version 11/13/2017
 */
public class SquareCircleAction extends AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * draw pane.
     */
    private DrawPane myDrawPane;


    /**
     * @param thePane pane.
     * @param theName name.
     */
    public SquareCircleAction(final DrawPane thePane, final String theName) {
        super(theName);
        myDrawPane = thePane;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myDrawPane.setMode(!myDrawPane.getMode());
    }

}
