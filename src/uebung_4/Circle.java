package uebung_4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * A Circle using the Classes Point and Shape
 */
public class Circle extends Shape {

    /**
     * the radius for the circle
     */
    protected double radius;
    protected Color colorFill, colorStroke;
    protected int typeStroke = 0;

    /**
     * Constructor
     */
    public Circle(Point center, double radius, Color colorFill, Color colorStroke, int typeStroke) {
        super(center);
        this.colorFill = colorFill;
        this.colorStroke = colorStroke;
        this.typeStroke = typeStroke;
        int xUpperLeftCorner = (int) (anchor.x - radius);
        int yUpperLeftCorner = (int) (anchor.y - radius);
        int width = (int) (2 * radius);
        this.setBounds(xUpperLeftCorner, yUpperLeftCorner, width, width);
        this.radius = radius;
        this.setOpaque(false);
    }

    /**
     * Area
     */
    public double area() {
        return (2 * radius * radius * Math.PI);
    }

    /**
     * Perimeter
     */
    public double perimeter() {
        return (2 * radius * Math.PI);
    }

    /**
     * toString
     */
    public String toString() {
        return ("Circle at " + position() + " with radius=" + radius);
    }

    /**
     * clone
     */
    //public Object clone() {
    //    return new Circle((Point) anchor.clone(), radius, new Color(color.getRed(), color.getGreen(), color.getBlue()));
    //}
    /**
     * equals
     */
    public boolean equals(Object pp) {
        if (pp instanceof Circle) {
            Circle p = (Circle) pp;
            return (anchor.equals(p.anchor) && p.radius == radius);
        } else {
            return false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int width = (int) (2 * radius);
        

        if (typeStroke == 1 && typeStroke == 0) {
            g2.setStroke(new BasicStroke(5.0f));
        } else if (typeStroke == 2) {
            g2.setStroke(new BasicStroke(15.0f));
        } else if (typeStroke == 3) {
            float dash[] = {10.0f};
            g2.setStroke(new BasicStroke(10.0f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
        }

        g.setColor(colorFill);
        g.fillOval(0, 0, width, width);
        g2.setPaint(colorStroke);
        g.drawOval(0, 0, width, width);
    }
}
