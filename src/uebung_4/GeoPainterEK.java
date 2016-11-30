package uebung_4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;

/**
 *
 * @author Floyd
 */
public class GeoPainterEK {

    Random rand;
    JLayeredPane lp;

    public GeoPainterEK() {
        rand = new Random();
        lp = new JLayeredPane();
        lp.setBorder(BorderFactory.createTitledBorder("Zeichenfläche"));
    }

    public void addCircle(Point center, double radius, Color colorFill, Color colorStroke, int typeStroke, int depth) {
        Shape newCircle = new Circle(center, radius, colorFill, colorStroke, typeStroke);
        lp.add(newCircle, depth);
    }

    public void addRectangle(Point leftUpperCorner, Point rightLowerCorner, Color colorFill, Color colorStroke, int typeStroke, int depth) {
        Rectangle newRect = new Rectangle(leftUpperCorner, rightLowerCorner, colorFill, colorStroke, typeStroke);
        lp.add(newRect, depth);
    }

    public Color randomColor() {
        return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }
}
