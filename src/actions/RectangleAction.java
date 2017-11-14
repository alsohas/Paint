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
public class RectangleAction extends AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 6287914153984659919L;
    
    /**
     * Drawing pane.
     */
    private final DrawPane myPane;


    /**
     * @param thePane Drawing pane where things will be drawn.
     */
    public RectangleAction(final DrawPane thePane) {
        super("Rectangle");
        myPane = thePane;
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
        putValue(Action.SELECTED_KEY, true);
    }


    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent theE) {
        myPane.setShape(2);

    }

}
