/**
 * 
 */
package tools;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abdullah
 * @version 2/23/2016
 */
public class Pencil extends AbstractShape {
    

    /**
     * List for storing coordinates.
     */
    private ArrayList<Point> myPoints;
 

    /**
     * @param theStart Starting point of the shape.
     * @param theNext Following point of the shape.
     * @param theIndicator indicator.
     */
    public Pencil(final Point theStart, final Point theNext, final int theIndicator) {
        super(theStart, theNext, theIndicator);
        myPoints = new ArrayList<Point>();
        
        myPoints.add(theStart);
        myPoints.add(theNext);
    }

    @Override
    public Shape getShape() {
        return this;
    }

    @Override
    public void setNextPoint(final Point thePoint) {
        myPoints.add(thePoint);
        
    }

    @Override
    public Point getStartPoint() {
        return myPoints.get(0);
    }

    @Override
    public Point getEndPoint() {
        return myPoints.get(myPoints.size() - 1);
    }
    
    /**
     * @return Returns a list with all the x coordinates.
     */
    public List<Point> getCoordinates() {
        return myPoints;
    }

    @Override
    public boolean getMode() {
        return false;
    }
}
