/**
 * 
 */
package gui;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import tools.Ellipse;
import tools.Line;
import tools.Pencil;
import tools.Rectangle;
import tools.Shape;



/**
 * @author Abdullah
 * @version 2/23/2016
 */
/**
 * @author Abdullah
 * @version 11/13/2017
 */
public class DrawPane extends JPanel {

    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 4508370872771701644L;
    
    /**
     * Work around to the dot in the top left corner.
     */
    private static final Point DEFAULT_START = new Point(-1, -1);
    
    /**
     * Default stroke thickness.
     */
    private static final int DEFAULT_STROKE = 3;
    
    /**
     * Default color is purple.
     */
    private static final Color DEFAULT_COLOR = new Color(51, 0, 111);

    /**
     * 
     */
    private static final int PENCIL_INDICATOR = 4;

    /**
     * 
     */
    private static final int ELLIPSE_INDICATOR = 3;

    /**
     * 
     */
    private static final int RECTANGLE_INDICATOR = 2;

    /**
     * 
     */
    private static final int LINE_INDICATOR = 1;    
    /**
     * The default dimension of the image container.
     */
    private final Dimension myPanelDimension = new Dimension(500, 400);
    
    /**
     * This is needed to let the pencil drawer know when 
     * to stop adding points to the path list.
     */
    private boolean myMouseReleased;
    
    /**
     * List of all the shapes drawn.
     */
    private final List<Shape> myShapes;
    
    /**
     * The current shape which is being drawn.
     */
    private Shape myCurrentShape = new Line(DEFAULT_START, DEFAULT_START, 1);
    
    /**
     * Gets the x and y values for shapes.
     */
    private final MouseListener myMouseHandler = new MouseAdapter() {
        @Override
        public void mousePressed(final MouseEvent theE) {
            myX1 = theE.getX();
            myY1 = theE.getY();
            myX2 = theE.getX();
            myY2 = theE.getY();
            myMouseReleased = false;
        }
        
        @Override 
        public void mouseReleased(final MouseEvent theE) {
            myX2 = theE.getX();
            myY2 = theE.getY();
            myMouseReleased = true;
            myShapes.add(myCurrentShape);
        }
    };
    
    /**
     * Used by the draw tool.
     */
    private final MouseMotionListener myMouseMotionHandler = new MouseMotionAdapter() {
        @Override
        public void mouseDragged(final MouseEvent theE) {
            myX2 = theE.getX();
            myY2 = theE.getY();
            repaint();
        }
    };
    
    /**
     * Used by the mouse handlers and draw methods.
     */
    private int myX1;
    
    /**
     * Used by the mouse handlers and draw methods.
     */
    private int myY1;
    
    /**
     * Used by the mouse handlers and draw methods.
     */
    private int myX2;
        
    /**
     * Used by the mouse handlers and draw methods.
     */
    private int myY2;

    /**
     * Which shape to draw.
     */
    private int myShapeIndicator;
    
    /**
     * Stroke of the drawing.
     */
    private BasicStroke myCurrentStroke;

    /**
     * Color.
     */
    private Color myCurrentColor;

    /**
     * square or circle mode.
     */
    private boolean myCurrentMode;
    

    /**
     * 
     */
    public DrawPane() {
        super();
        setBackground(Color.WHITE);
        setPreferredSize(myPanelDimension);
        
        addMouseListener(myMouseHandler);
        addMouseMotionListener(myMouseMotionHandler);
        
        myShapes = new ArrayList<Shape>();
        myShapeIndicator = 1;
        myCurrentStroke = new BasicStroke(DEFAULT_STROKE);
        myCurrentColor =  DEFAULT_COLOR;
        myCurrentMode = false;
    }
    
    @Override
    public void paintComponent(final Graphics theG) {
        super.paintComponent(theG);
        final Graphics2D g2 = (Graphics2D) theG;
        
        for (int i = 0; i < myShapes.size(); i++) {
            anotherDrawMethod(myShapes.get(i), g2);
        }
        g2.setStroke(myCurrentStroke);
        g2.setColor(myCurrentColor);
        
        if (myShapeIndicator == LINE_INDICATOR) {
            myCurrentShape = new Line(new Point(myX1, myY1), new Point(myX2, myY2), 1);
            myCurrentShape.setStroke(myCurrentStroke);
            g2.drawLine(myX1, myY1, myX2, myY2);
        
        } else if (myShapeIndicator == RECTANGLE_INDICATOR) {
            myCurrentShape = new Rectangle(new Point(myX1, myY1), new Point(myX2, myY2), 2);
            myCurrentShape.setMode(myCurrentMode);
            myCurrentShape.setStroke(myCurrentStroke);
            drawRectangle(g2, (Rectangle) myCurrentShape);
        
        } else if (myShapeIndicator == ELLIPSE_INDICATOR) {
            myCurrentShape = new Ellipse(new Point(myX1, myY1), 
                                         new Point(myX2, myY2), ELLIPSE_INDICATOR);
            myCurrentShape.setMode(myCurrentMode);
            myCurrentShape.setStroke(myCurrentStroke);
            drawEllipse(g2, (Ellipse) myCurrentShape);
        
        } else if (myShapeIndicator == PENCIL_INDICATOR) { 
            myCurrentShape = new Pencil(new Point(myX1, myY1), 
                                        new Point(myX2, myY2), PENCIL_INDICATOR);
            myCurrentShape.setStroke(myCurrentStroke);    
            if (!myMouseReleased) {
                ((Pencil) myCurrentShape).setNextPoint(new Point(myX2, myY2));
            }
            myCurrentShape.setColor(myCurrentColor);
            myShapes.add(myCurrentShape);

        }
        myCurrentShape.setColor(myCurrentColor);

    }

    
    
    /**
     * @param theShape The shape is passed on to this method to be drawn.
     * @param g2 The graphics panel send this to be drawn onto.
     * 
     */
    private void anotherDrawMethod(final Shape theShape, final Graphics2D g2) {
        
        g2.setStroke(theShape.getStroke());
        g2.setColor(theShape.getColor());
        final Point start = theShape.getStartPoint();
        final Point end = theShape.getEndPoint();
        
        if (theShape.getIndicator() == LINE_INDICATOR) {
            g2.drawLine(start.x, start.y, end.x, end.y);
        
        } else if (theShape.getIndicator() == RECTANGLE_INDICATOR) {
            drawRectangle(g2, (Rectangle) theShape);
        
        } else if (theShape.getIndicator() == ELLIPSE_INDICATOR) {
            drawEllipse(g2, (Ellipse) theShape);   
            
        } else if (theShape.getIndicator() == PENCIL_INDICATOR) { //And this. 
            final List<Point> coords = ((Pencil) theShape).getCoordinates();
            for (int i = 1; i < coords.size() - 1; i++) {
                g2.drawLine(coords.get(i).x, coords.get(i).y, 
                            coords.get(i + 1).x, coords.get(i + 1).y);
            }
        }
    }
    
    
    /**
     * @param g2 graphics.
     * @param theEllipse 
     */
    private void drawEllipse(final Graphics2D g2, final Ellipse theEllipse) {
        final int x1 = theEllipse.getStartPoint().x;
        final int y1 = theEllipse.getStartPoint().y;
        final int x2 = theEllipse.getEndPoint().x;
        final int y2 = theEllipse.getEndPoint().y;
        
        int height = theEllipse.getHeight();
        int width = theEllipse.getWidth();
        
        if (theEllipse.getMode()) {
            if (Math.abs(height) >= Math.abs(width)) {
                width = height;
            } else {
                height = width;
            }
        }
        
        if (x2 > x1) {
            if (y2 > y1) {
                g2.drawOval(x1, y1, width, height);
            } else {
                g2.drawOval(x1, y2, width, height);
            }
        } else if (x2 < x1) {
            if (y2 < y1) {
                g2.drawOval(x2, y2, width, height);
            } else {
                g2.drawOval(x2, y1, width, height);
            }
        }
    }    
    
    /**
     * @param g2 graphics.
     * @param theRectangle 
     */
    private void drawRectangle(final Graphics2D g2, final Rectangle theRectangle) {
        final int x1 = theRectangle.getStartPoint().x;
        final int y1 = theRectangle.getStartPoint().y;
        final int x2 = theRectangle.getEndPoint().x;
        final int y2 = theRectangle.getEndPoint().y;
        
        
        int height = theRectangle.getHeight();
        int width = theRectangle.getWidth();
        
        if (theRectangle.getMode()) {
            if (Math.abs(height) >= Math.abs(width)) {
                width = height;
            } else {
                height = width;
            }
        }
        
        if (x2 > x1) {
            if (y2 > y1) {
                g2.drawRect(x1, y1, width, height);
            } else {
                g2.drawRect(x1, y2, width, height);
            }
        } else if (x2 < x1) {
            if (y2 < y1) {
                g2.drawRect(x2, y2, width, height);
            } else {
                g2.drawRect(x2, y1, width, height);
            }
        }
    }
    
    /**
     * @param theShapeIndicator Sets which shape the user has selected.
     */
    public void setShape(final int theShapeIndicator) {
        myShapeIndicator = theShapeIndicator;
        
    }

    /**
     * @param theColor Sets current color.
     */
    public void setPanelColor(final Color theColor) {
        myCurrentColor = theColor;
        myCurrentShape.setColor(myCurrentColor);
    }
    
    /**
     * @param theStroke Sets current stroke.
     */
    public void setCurrentStroke(final BasicStroke theStroke) {
        myCurrentStroke = theStroke;
    }
    /**
     * Resets the drawing pane.
     */
    public void reset() {
        myCurrentShape = new Line(DEFAULT_START, DEFAULT_START, 1);
        myShapeIndicator = 1;
        myShapes.clear();
        myCurrentStroke = new BasicStroke(DEFAULT_STROKE);
        myCurrentColor = DEFAULT_COLOR;
        repaint();
    }

    /**
     * set shape mode.
     * @param theMode sq/circle mode.
     */
    public void setMode(final boolean theMode) {
        myCurrentMode = theMode;
    }
    
    /**
     * @return mode.
     */
    public boolean getMode() {
        return myCurrentMode;
    }
}
