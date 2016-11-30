package uebung_4;



import javax.swing.JPanel;

/** Super class for geometric figures */
public abstract class Shape extends JPanel implements Cloneable, Geometry{

// common part
/** the anchor of the Shape */  
  protected Point anchor;

/** Constructor */
  Shape() {
    this.anchor = new Point();
  }

/** Constructor */
  Shape(Point anchor) {
    this.anchor = (Point) anchor.clone();
  }

/** get the position */
  public Point position() {
    return anchor;
  }
}