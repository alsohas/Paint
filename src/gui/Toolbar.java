
package gui;

import actions.EllipseAction;
import actions.LineAction;
import actions.PencilAction;
import actions.RectangleAction;

import java.awt.Button;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * @author Abdullah
 * @version 2/23/2016
 */
public class Toolbar extends JToolBar {

    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 766564780799175882L;
    
    /**
     * Pencil toggle.
     */
    private final JToggleButton myPencilButton;
    
    /**
     * Line toggle.
     */
    private final JToggleButton myLineButton;
    
    /**
     * Rectangle toggle.
     */
    private final JToggleButton myRectangleButton;
    
    /**
     * Ellipse toggle.
     */
    private final JToggleButton myEllipseButton;


    /**
     * @param thePane drawPane.
     */
    public Toolbar(final DrawPane thePane) {
        super();
       
        myPencilButton = new JToggleButton(new PencilAction(thePane));

        myLineButton = new JToggleButton(new LineAction(thePane));

        myRectangleButton = new JToggleButton(new RectangleAction(thePane));

        myEllipseButton = new JToggleButton(new EllipseAction(thePane));
        
        setUpToolbar(thePane);
    }
    

    /**
     * @param thePane draw pane.
     */
    private void setUpToolbar(final DrawPane thePane) {
        
        
        final ButtonGroup buttonGroup = new ButtonGroup();   
        buttonGroup.add(myPencilButton);
        buttonGroup.add(myRectangleButton);
        buttonGroup.add(myEllipseButton);
        buttonGroup.add(myLineButton);
        

        add(myPencilButton);
        add(myLineButton);
        add(myRectangleButton);
        add(myEllipseButton);

        
    }
    
}
