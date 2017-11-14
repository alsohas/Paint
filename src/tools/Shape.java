package tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;

/**
 * @author Abdullah
 * @version 2/23/2016
 */

public interface Shape {
    

    /**
     * @return Returns the information about the shape to be constructed.
     */
    Shape getShape();
    
    /**
     * @param theStroke Sets the stroke of shape.
     * @return 
     */
    void setStroke(Stroke theStroke);
    
    /**
     * @param theColor Sets the color of shape.
     */
    void setColor(Color theColor);

    /**
     * @return The stroke of shape.
     */
    Stroke getStroke();
    
    
    /**
     * @return Returns the color of shape.
     */
    Color getColor();
    
    
    /**
     * @param thePoint Sets the next point on which the shape is drawn. 
     */
    void setNextPoint(Point thePoint);
    
    /**
     * @return Returns the starting point where the shape is started to be drawn.
     */
    Point getStartPoint();
    
    /**
     * @return Returns the last point in the shape.
     */
    Point getEndPoint();
    
    /**
     * @return shape indicator
     */
    int getIndicator();
        
    /**
     * @return square/circle mode.
     */
    boolean getMode();

    /**
     * @param theMode mode.
     */
    void setMode(boolean theMode);


    

}
