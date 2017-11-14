/**
 * @author Abdullah
 * @version 11/13/2017
 */
package actions;
import gui.DrawPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

/**
 * @author Abdullah
 * @version 11/13/2017
 */
public class ColorAction extends AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * draw pane.
     */
    private DrawPane myPane;

    
    /**
     * @param thePane draw pane.
     * @param theName title.
     */
    public ColorAction(final DrawPane thePane, final String theName) {
        super(theName);
        myPane = thePane;
    }


    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Color color = JColorChooser.showDialog(myPane, "Choose Color", null);
        if (color != null) {
            myPane.setPanelColor(color);
        }

    }

}
