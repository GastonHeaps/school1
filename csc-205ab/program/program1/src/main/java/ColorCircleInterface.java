/*
This is the interface for the ColorCircle class.
All of the methods here should be available from the Circle class.
BUT...all but the last 3 can be inherited so they do not have to be
        implemented and the ColorCircleInterface will still be satisfied.
*/
public interface ColorCircleInterface {
    //translate - moves this Circle by whatever x,y is received
    public void translate(int deltax, int deltay);

    //getArea - returns the area
    public double getArea();

    //getDiameter -  returns the diameter
    public int getDiameter();

    //intersects - 	returns true if this instance intersects the one that is received (even if just the edges touch)
    //						throws a new IllegalArgumentException(your explanation) if what is received is null
    public boolean intersects(Circle another);

    //isInside -	returns true if this instance is COMPLETELY inside the one that is received (edges do not touch at all)
    //					throws a new IllegalArgumentException(your explanation) if what is received is null
    public boolean isInside(Circle another);

    //equals - returns true if this instance equals the Object that is received.
    //				One ColorCircle is equal to another if they have the same center and radius (COLOR WILL NOT MATTER)
    public boolean equals(Object obj);

    //toString - returns its representation as a String with the color in front.     Example: "red Circle: (3,4) r=5"
    public String toString();

    //isRed - returns true if the color (which is stored as a String) is "red" (or "Red" or "rEd" etc, ignoring case)
    public boolean isRed();
}
