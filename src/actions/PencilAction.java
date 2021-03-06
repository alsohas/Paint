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
public class PencilAction extends AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 6287914153984659919L;
    
    /**
     * Which shape am i? tells the pane.
     */
    private static final int INDICATOR = 4;
    
    /**
     * Drawing pane.
     */
    private final DrawPane myPane;


    /**
     * @param thePane Drawing pane where things will be drawn.
     */
    public PencilAction(final DrawPane thePane) {
        super("Pencil");
        myPane = thePane;
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
        putValue(Action.SELECTED_KEY, true);
    }


    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent theE) {
        myPane.setShape(INDICATOR); 

    }

}
