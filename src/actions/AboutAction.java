/**
 * 
 */
package actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 * @author Abdullah
 * @version 2/23/2016
 */
public class AboutAction extends AbstractAction {


    /**
     * Serial.
     */
    private static final long serialVersionUID = 9034692605574162347L;
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    /**
     * Icon.
     */
    //private static final ImageIcon IMAGE_ICON = new ImageIcon("w.png");

    @Override
    public void actionPerformed(final ActionEvent theE) {
        JOptionPane.showMessageDialog(null, "Abdullah Islam", 
                        "About", 0, null);

    }

}
