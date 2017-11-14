package tools;

import java.awt.Point;

/**
 * @author Abdullah
 * @version 2/23/2016     
 */
public class Rectangle extends Line {
    
    /**
     * The height of rectangle.
     */
    private final int myHeight;
    
    /**
     * The width of rectangle. 
     */
    private final int myWidth;
        

    /**
     * @param theStart Starting point of rectangle.
     * @param theEnd End point of rectangle.
     * @param theIndicator indicates shape
     */
    public Rectangle(final Point theStart, final Point theEnd, final int theIndicator) {
        super(theStart, theEnd, theIndicator);
        myHeight = Math.abs((int) (theEnd.getY() - theStart.getY()));
        myWidth = Math.abs((int) (theEnd.getX() - theStart.getX()));
    }
    
    /**
     * @return Returns the height of rectangle.
     */
    public int getHeight() {
        return myHeight;
    }

    /**
     * @return Returns the width of rectangle.
     */
    public int getWidth() {
        return myWidth;
    }

}
