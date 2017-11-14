import gui.DrawPane;
import gui.MenuBar;
import gui.Toolbar;
import java.awt.BorderLayout;
import javax.swing.JFrame;


/**
 * @author Abdullah Islam
 * @version 2/8/2016
 */


public class Paint extends JFrame {
    
    /**
     * Serial version id.
     */
    private static final long serialVersionUID = -6343090866765295116L;
    

    
//    /**
//     * Screen center to set start location of GUI.
//     */
//    private static final Dimension SCREEN_CENTER = 
    //Toolkit.getDefaultToolkit().getScreenSize();
    
    
    /**
     * Going to set up the window.
     */
    public Paint() {
        super("Paint");
        final DrawPane pane = new DrawPane();
        
        setLayout(new BorderLayout());
        add(pane, BorderLayout.CENTER);
        setJMenuBar(new MenuBar(pane));
        add(new Toolbar(pane), BorderLayout.SOUTH);
        pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
        

}
