/**
 * 
 */
package tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;

/**
 * @author Abdullah Islam
 * @version 2/23/2016
 *
 */
public abstract class AbstractShape implements Shape {
    /**
     * Color of shape.
     */
    private static final Color DEFAULT_COLOR = new Color(51, 0, 111);
    
    /**
     * Default stroke is 5.
     */
    private static final Stroke DEFAULT_STROKE = new BasicStroke(5);
    
    /**
     * The starting point.
     */
    private final Point myStartPoint;
    
    
    /**
     * The next point.
     */
    private Point myNextPoint;
        
    /**
     * Stroke of shape.
     */
    private Stroke myStroke;

    /**
     * The set color of shape.
     */
    private Color myColor;

    /**
     * indicator.
     */
    private int myIndicator;

    /**
     * Mode.
     */
    private boolean myMode;

    /**

     */
    /**
     * @param theStart is the starting point passed in.
     * @param theEnd is the end point passed in.
     * @param theIndicator shape indicator.
     */
    public AbstractShape(final Point theStart, final Point theEnd, final int theIndicator) {
        myStartPoint = theStart;
        myNextPoint = theEnd;
        myColor = DEFAULT_COLOR;
        myStroke = DEFAULT_STROKE;
        myIndicator = theIndicator;
        myMode = false;
    }


    /* (non-Javadoc)
     * @see tools.Shape#setNextPoint()
     */
    @Override
    public void setNextPoint(final Point thePoint) {
        myNextPoint = thePoint;

    }
    
    /**
     * @param theStroke Sets the stroke of shape.
     */
    public void setStroke(final Stroke theStroke) {
        myStroke = theStroke;
    }
    
    /**
     * @param theColor Sets the color of shape.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }

    /**
     * @return The stroke of shape.
     */
    public Stroke getStroke() {
        return myStroke;
    }
    
    /**
     * @return Returns the color of shape.
     */
    public Color getColor() {
        return myColor;
    }
    
    /* (non-Javadoc)
     * @see tools.Shape#getStartPoint()
     */
    @Override
    public Point getStartPoint() {
        return myStartPoint;
    }

    /* (non-Javadoc)
     * @see tools.Shape#getEndPoint()
     */
    @Override
    public Point getEndPoint() {
        return myNextPoint;
    }

    /* (non-Javadoc)
     * @see tools.Shape#getShape()
     */
    @Override
    public Shape getShape() {
        return this;
    }
    

    /* 
     * @see tools.Shape#getIndicator()
     */
    @Override
    public int getIndicator() {
        return myIndicator;
    }
    
    

    /* 
     * Set mode.
     * @param theMode mode.
     */
    @Override
    public void setMode(final boolean theMode) {
        myMode = theMode;
    }

    /**
     * @return mode
     */
    public boolean getMode() {
        return myMode;
    }
    
}
