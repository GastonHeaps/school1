/*
This is the interface for the Circle class.
*/
public interface CircleInterface {
    //translate - moves this Circle by whatever x,y is received
    public void translate(int deltax, int deltay);

    //getArea - returns the area
    public double getArea();

    //getDiameter -  returns the diameter
    public int getDiameter();

    //intersects
    //		returns true if this instance intersects the one that is received (even if just the edges touch)
    //		throws a new IllegalArgumentException(your explanation) if what is received is null
    public boolean intersects(Circle another);

    //isInside
    //		returns true if this instance is COMPLETELY inside the one that is received (edges do not touch at all)
    //		throws a new IllegalArgumentException(your explanation) if what is received is null
    public boolean isInside(Circle another);

    //equals - returns true if this instance equals the Object that is received
    public boolean equals(Object obj);

    //toString - returns its representation as a String   Example: "Circle: (3,4) r=5"
    public String toString();

    //inQuadrant
    //		returns true if the entire circle is COMPLETELY in the quadrant that is received.
    //		throws a new IllegalArgumentException if the quadrant is out of range (not 1-4)
    //		When in a quadrant, the Circle cannot touch either the x-axis or the y-axis.
    //		NOTE:	This is for EXTRA CREDIT (8 pts)  so it is commented out and does not HAVE to be implemented.
    //						You do not have to uncomment it if it is an "extra" method that you implement (not in the interface)
    public boolean inQuadrant(int theQuadrant);
}
