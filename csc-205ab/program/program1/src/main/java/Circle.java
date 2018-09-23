/**
 * represents a circle with a center point and radius with methods to manipulate
 * the circle
 */
public class Circle implements CircleInterface {
    //member variables
    protected Point center;
    protected int radius;

    //default constructor
    public Circle() {
        this.center = new Point();
        this.radius = 8;
    }

    //parameterized constructor
    public Circle(Point center, int radius) {
        if (center == null) {
            throw new IllegalArgumentException("Circle can't be null.");
        } else if (radius < 1) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.center = center;
        this.radius = radius;
    }

    //copy constructor
    public Circle(Circle circle) {
        if (circle == null) {
            throw new IllegalArgumentException("Circle can't be null.");
        }
        this.center = new Point(circle.center);
        this.radius = circle.radius;
    }

    //moves this Circle by whatever x,y is received
    @Override
    public void translate(int deltax, int deltay) {
        this.center.translate(deltax, deltay);
    }

    //returns the area
    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    //returns the diameter
    @Override
    public int getDiameter() {
        return this.radius * 2;
    }

    //		returns true if this instance intersects the one that is received (even if just the edges touch)
    //		throws a new IllegalArgumentException if what is received is null
    @Override
    public boolean intersects(Circle another) {
        if (another == null) {
            throw new IllegalArgumentException("Circle can't be null.");
        }
        //If the distance between the centers of this instance and the received circle
        //is less than or equal to their combined radii, the circles intersect
        if (this.center.distanceTo(another.center) <= this.radius + another.radius) {
            return true;
        } else {
            return false;
        }
    }

    //		returns true if this instance is COMPLETELY inside the one that is received (edges do not touch at all)
    //		throws a new IllegalArgumentException() if what is received is null
    @Override
    public boolean isInside(Circle another) {
        if (another == null) {
            throw new IllegalArgumentException("Circle can't be null.");
        }
        //If the combined length of the radius of this instance and the distance between the centers of the circles
        //is less than the raidus of the received circle, the instance circle is inside the received circle
        if (this.center.distanceTo(another.center) + this.radius < another.radius) {
            return true;
        } else {
            return false;
        }
    }

    //		returns true if the entire circle is COMPLETELY in the quadrant that is received.
    //		throws a new IllegalArgumentException if the quadrant is out of range (not 1-4)
    //		When in a quadrant, the Circle cannot touch either the x-axis or the y-axis.
    public boolean inQuadrant(int theQuadrant) {
        //Checks if quadrant received is between 1 and 4
        if (theQuadrant < 1 || theQuadrant > 4) {
            throw new IllegalArgumentException("The quadrant is out of range (not 1-4).");
        }
        //If the center of this instance is in a quadrant and the distance between the origin and center of this instance 
        //is greater than the radius of this instance, then create points at the right, left, top, and bottom of the circle's edge
        if (this.center.inQuadrant(theQuadrant) && this.center.distanceTo(new Point(0, 0)) > this.radius) {
            Point rightPoint = new Point(this.center);
            rightPoint.translate(this.radius, 0);
            Point leftPoint = new Point(this.center);
            leftPoint.translate(-this.radius, 0);
            Point topPoint = new Point(this.center);
            topPoint.translate(0, this.radius);
            Point bottomPoint = new Point(this.center);
            bottomPoint.translate(0, -this.radius);
            //If all of the points lie in the same quadrant as the center, the entire circle is in the quadrant
            switch (theQuadrant) {
                case 1:
                    if (rightPoint.inQuadrant(theQuadrant) && leftPoint.inQuadrant(theQuadrant) && topPoint.inQuadrant(theQuadrant) && bottomPoint.inQuadrant(theQuadrant)) {
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (rightPoint.inQuadrant(theQuadrant) && leftPoint.inQuadrant(theQuadrant) && topPoint.inQuadrant(theQuadrant) && bottomPoint.inQuadrant(theQuadrant)) {
                        return true;
                    } else {
                        return false;
                    }
                case 3:
                    if (rightPoint.inQuadrant(theQuadrant) && leftPoint.inQuadrant(theQuadrant) && topPoint.inQuadrant(theQuadrant) && bottomPoint.inQuadrant(theQuadrant)) {
                        return true;
                    } else {
                        return false;
                    }
                case 4:
                    if (rightPoint.inQuadrant(theQuadrant) && leftPoint.inQuadrant(theQuadrant) && topPoint.inQuadrant(theQuadrant) && bottomPoint.inQuadrant(theQuadrant)) {
                        return true;
                    } else {
                        return false;
                    }
            }
        }
        return false;
    }

    //returns true if this instance equals the Object that is received
    @Override
    public boolean equals(Object obj) {
        //checks that a Circle object was passed in
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }

        //cast object as Circle
        Circle anotherCircle = (Circle) obj;
        if (this.center.equals(anotherCircle.center) && this.radius == anotherCircle.radius) {
            return true;
        } else {
            return false;
        }
    }

    //returns its representation as a String   Example: "Circle: (3,4) r=5"
    @Override
    public String toString() {
        return "Circle:" + this.center.toString() + " r=" + this.radius;
    }
}
