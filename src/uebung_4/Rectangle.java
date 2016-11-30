package uebung_4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 * A Rectangle using the Classes Point and Shape
 */
public class Rectangle extends Shape {

    /**
     * the second Point for the Rectangle
     */
    protected Point rightLowerCorner;
    protected Color colorFill, colorStroke;
    protected int typeStroke = 0;

    /**
     * Constructor
     */
    //public Rectangle(Point leftUpperCorner, Point rightLowerCorner, Color colorFill, Color colorStroke, Stroke typeStroke) {
    public Rectangle(Point leftUpperCorner, Point rightLowerCorner, Color colorFill, Color colorStroke, int typeStroke) {
        super(leftUpperCorner);
        this.rightLowerCorner = (Point) rightLowerCorner.clone();
        this.colorFill = colorFill;
        this.colorStroke = colorStroke;
        this.typeStroke = typeStroke;
        int x = (int) rightLowerCorner.x;
        int y = (int) rightLowerCorner.y;
        this.setBounds(x, y, (int) width(), (int) height());
        this.setOpaque(false);
    }

    /**
     * Area
     */
    public double area() {
        return (width() * height());
    }

    /**
     * Perimeter
     */
    public double perimeter() {
        return (2 * (width() + height()));
    }

    // helper
    /**
     * Returns the width of the rectangle
     */
    private double width() {
        return (Math.abs(rightLowerCorner.x - anchor.x));
    }

    /**
     * Returns the height of the rectangle
     */
    private double height() {
        return (Math.abs(anchor.y - rightLowerCorner.y));
    }

    /**
     * toString
     */
    public String toString() {
        return ("Rectangle at " + position()
                + " with width=" + width() + " and heigth=" + height());
    }

    /**
     * clone, makes a deep copy of the Rectange (clones both Points)
     */
    //public Object clone() {
    //    return new Rectangle((Point) anchor.clone(),
    //            (Point) rightLowerCorner.clone(), new Color(color.getRed(), color.getGreen(), color.getBlue()));
    //}
    /**
     * equals
     */
    public boolean equals(Object rr) {
        if (rr instanceof Rectangle) {
            Rectangle r = (Rectangle) rr;
            return (anchor.equals(r.anchor)
                    && rightLowerCorner.equals(r.rightLowerCorner));
        } else {
            return false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int x = (int) rightLowerCorner.x;
        int y = (int) rightLowerCorner.y;

        if (typeStroke == 1 && typeStroke == 0) {
            g2.setStroke(new BasicStroke(5.0f));
        } else if (typeStroke == 2) {
            g2.setStroke(new BasicStroke(15.0f));
        } else if (typeStroke == 3) {
            float dash[] = {10.0f};
            g2.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
        }

        g2.setColor(colorFill);
        g2.fillRect(0, 0, (int) width(), (int) height());
        g2.setPaint(colorStroke);
        g2.drawRect(0, 0, (int) width(), (int) height());
    }
}
