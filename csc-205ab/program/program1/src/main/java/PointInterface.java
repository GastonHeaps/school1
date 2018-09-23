//This is the interface for a Point class (which will represent a 2-dimensional Point)
public interface PointInterface {
    // toString
    //		returns a String representing this instance in the form (x,y)    (WITHOUT a space after the ,)
    public String toString();

    // distanceTo
    //		throws a new IllegalArgumentException(<your descriptive String> if null is received
    //		returns the distance from this Point to the Point that was received
    public double distanceTo(Point otherPoint);

    // halfwayTo    NOT NEEDED!!!
    //		throws a new IllegalArgumentException(<your descriptive String> if null is received
    //		returns a new Point that's halfway between this Point & the Point that was received
    //public Point halfwayTo(Point otherPoint);

    //equals - returns true if it is equal to what is received (as an Object)
    public boolean equals(Object obj);

    // inQuadrant
    //			returns true if this Point is in the quadrant specified
    //			throws a new IllegalArgumentException if the quadrant is out of range (not 1-4)
    public boolean inQuadrant(int quadrant);

    // translate
    //		returns nothing & shifts (or translates) this Point by the x,y distances received
    public void translate(int xMove, int yMove);

    //aboveXAxis      NOT NEEDED!!!
    //		returns true if this Point is above the x-axis
    //public boolean aboveXAxis();

    //rightOfYAxis     NOT NEEDED!!!
    //		returns true if this Point is to the right of the y-axis
    //public boolean rightOfYAxis();
}
