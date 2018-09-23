/**
 * represents a subclass of circle with a color
 */
public class ColorCircle extends Circle implements ColorCircleInterface {
    //member variable
    protected String color;

    //default constructor
    public ColorCircle() {
        super();
        this.color = "red";
    }

    //parameterized constructor
    public ColorCircle(Point center, int radius, String color) {
        super(center, radius);
        if (color == null) {
            throw new IllegalArgumentException("Color can't be null.");
        }
        this.color = color;
    }

    //copy constructor
    public ColorCircle(ColorCircle circle) {
        super(circle);
        this.color = circle.color;
    }

    //returns true if the color (which is stored as a String) is "red" (or "Red" or "rEd" etc, ignoring case)
    @Override
    public boolean isRed() {
        return color.equalsIgnoreCase("red");
    }

    //returns its representation as a String with the color in front.     Example: "red Circle: (3,4) r=5"
    @Override
    public String toString() {
        return this.color + " " + super.toString();
    }

    //returns true if this instance equals the Object that is received.
    //				One ColorCircle is equal to another if they have the same center and radius (COLOR WILL NOT MATTER)
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
