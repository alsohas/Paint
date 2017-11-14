/**
 * 
 */
package gui;

import actions.AboutAction;
import actions.ColorAction;
import actions.EllipseAction;
import actions.ExitAction;
import actions.LineAction;
import actions.PencilAction;
import actions.RectangleAction;
import actions.SquareCircleAction;
import actions.UndoAction;
import java.awt.BasicStroke;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * @author Abdullah
 * @version 11/11/17
 */
public class MenuBar extends JMenuBar {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Deafult tick spacing.
     */
    private static final int DEAFULT_TICK_SPACING = 5;
    
    /**
     * 
     */
    private JMenu myFileMenu;
    
    /**
     * 
     */
    private JMenu myOptionMenu;
   
    /**
     * 
     */
    private JMenu myToolMenu;
    
    /**
     * 
     */
    private JMenu myHelpMenu;
    
    /**
     * 
     */
    private DrawPane myDrawPane;

    
    /**
     * @param thePane draw pane.
     */
    public MenuBar(final DrawPane thePane) {
        super();
        myFileMenu = new JMenu("File");
        myOptionMenu = new JMenu("Options");
        myToolMenu = new JMenu("Tools");
        myHelpMenu = new JMenu("Help");
        myDrawPane = thePane;
        
        setUpMenuBar();
    }

    /**
     * Setting up the menu bar.
     */
    private void setUpMenuBar() {
        
        //Setting up menu and corresponding buttons. 
        final JMenuItem undoMenuItem = new JMenuItem("Undo all changes");
        final JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ExitAction(myDrawPane));
        
        //Setting up mnemonics for the above buttons and menu.
        myFileMenu.setMnemonic(KeyEvent.VK_F);
        undoMenuItem.setMnemonic(KeyEvent.VK_U);
        undoMenuItem.addActionListener(new UndoAction(myDrawPane));
        exitMenuItem.setMnemonic(KeyEvent.VK_X);
        
        //Adding the buttons to the corresponding menu and then the menu to the menubar.
        myFileMenu.add(undoMenuItem);
        myFileMenu.addSeparator();
        myFileMenu.add(exitMenuItem);
        add(myFileMenu);
        
        //Setting up menu and corresponding buttons.
        final JMenuItem squarecircleMenuItem = new JCheckBoxMenuItem("Square/Circle only");
        squarecircleMenuItem.addActionListener(new SquareCircleAction(myDrawPane, "Mode"));
        final JMenu thicknessMenuItem = new JMenu("Thickness");
        final JMenuItem colorMenuItem = new JMenuItem("Color");
        
        colorMenuItem.addActionListener(new ColorAction(myDrawPane, "Choose Color"));
        
        final JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 20, 3);
        setupSlider(slider);
        thicknessMenuItem.add(slider);
        
        //Setting up mnemonics for the above buttons and menu.
        myOptionMenu.setMnemonic(KeyEvent.VK_O);
        squarecircleMenuItem.setMnemonic(KeyEvent.VK_S);
        thicknessMenuItem.setMnemonic(KeyEvent.VK_T);
        colorMenuItem.setMnemonic(KeyEvent.VK_C);
        
        //Adding the buttons to the corresponding menu and then the menu to the menubar.
        myOptionMenu.add(squarecircleMenuItem);
        myOptionMenu.addSeparator();
        myOptionMenu.add(thicknessMenuItem);
        myOptionMenu.addSeparator();
        myOptionMenu.add(colorMenuItem);
        add(myOptionMenu);
        
       


        

        setUpTools();

        //Adding the menu to the menubar.
        add(myToolMenu);
        
        final JMenuItem aboutMenuItem = new JMenuItem("About");
        
        myHelpMenu.setMnemonic(KeyEvent.VK_H);
        aboutMenuItem.setMnemonic(KeyEvent.VK_A);
        
        myHelpMenu.add(aboutMenuItem);
        add(myHelpMenu);
        
        aboutMenuItem.addActionListener(new AboutAction());      

    }

    /**
     * stroke slider setup.
     * @param theSlider slider.
     */
    private void setupSlider(final JSlider theSlider) {
        theSlider.setMajorTickSpacing(DEAFULT_TICK_SPACING);
        theSlider.setMinorTickSpacing(1);
        theSlider.setPaintLabels(true);
        theSlider.setPaintTicks(true);
        
        theSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent theEvent) {
                final int value = theSlider.getValue();
                myDrawPane.setCurrentStroke(new BasicStroke(value));
            }
        });
        
    }
    
    /**
     * Set up tool selectors.
     */
    private void setUpTools() {
        //Setting up menu and corresponding buttons.
        final JMenuItem pencilMenuItem = new JRadioButtonMenuItem("Pencil");
        final JMenuItem lineMenuItem = new JRadioButtonMenuItem("Line");
        final JMenuItem rectangleMenuItem = new JRadioButtonMenuItem("Rectangle");
        final JMenuItem ellipseMenuItem = new JRadioButtonMenuItem("Ellipse");
        
        //Setting up mnemonics for the above buttons and menu.
        myToolMenu.setMnemonic(KeyEvent.VK_T);
        pencilMenuItem.setMnemonic(KeyEvent.VK_P);
        lineMenuItem.setMnemonic(KeyEvent.VK_L);
        rectangleMenuItem.setMnemonic(KeyEvent.VK_R);
        ellipseMenuItem.setMnemonic(KeyEvent.VK_E);
        
        //These buttons need a group so only one can be selected at a time.
        final ButtonGroup selectionButtons = new ButtonGroup(); 
        selectionButtons.add(pencilMenuItem);
        selectionButtons.add(lineMenuItem);
        selectionButtons.add(rectangleMenuItem);
        selectionButtons.add(ellipseMenuItem);
        
        //Adding the buttons to the corresponding menu.
        myToolMenu.add(pencilMenuItem);
        myToolMenu.add(lineMenuItem);
        myToolMenu.add(rectangleMenuItem);
        myToolMenu.add(ellipseMenuItem);
        
        ellipseMenuItem.addActionListener(new EllipseAction(myDrawPane));
        rectangleMenuItem.addActionListener(new RectangleAction(myDrawPane));
        lineMenuItem.addActionListener(new LineAction(myDrawPane));
        pencilMenuItem.addActionListener(new PencilAction(myDrawPane));
    }
}
