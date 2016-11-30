package uebung_4;



/** This Class is a coordinate with x and y. */
public class Point implements Cloneable {
  // see java.lang.Cloneable
  protected double x,y;
  
  /** Default constructor with x=0 and y=0 */
  public Point () { 
    x=0;
    y=0;
  }
  
  /** Constructor sets x and y */
  public Point (double x, double y) { 
    this.x=x;
    this.y=y;
  }

  /** Calculates the distance to another Point */
  public double distance(Point p2) {
    return (Math.sqrt( (x-p2.x)*(x-p2.x) + (y-p2.y)*(y-p2.y) ));
  }

  /** Returns the position as a Point (in this case it returns itself) */
  public Point position() {
    return this;
  }
  

  // Methods inherited from Object; see java.lang.Object
  /** Converts the coordiante to a String for printing */
  public String toString() {
    return("Point ("+x+","+y+")");
  }
  
  /** Clone the Point */
  public Object clone() {
    return(new Point(this.x,this.y));
  }

  /** compare Points */
  public boolean equals(Object pp) {
    if(pp instanceof Point) { 
      Point p = (Point) pp;
      return(x==p.x && y==p.y);
    }else{
      return false;
    }
  }
}
