/**
 * represents a geometric point in a Cartesian plane with methods to manipulate
 * the point
 */
public class Point implements PointInterface {
    //member variables
    private int x;
    private int y;

    //default constructor
    public Point() {
        this.x = 3;
        this.y = -5;
    }

    //parameterized constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //copy constructor
    public Point(Point point) {
        if (point == null) {
            throw new IllegalArgumentException();
        }
        this.x = point.x;
        this.y = point.y;
    }

    //returns the distance from this Point to the Point that was received
    @Override
    public double distanceTo(Point otherPoint) {
        if (otherPoint == null) {
            throw new IllegalArgumentException();
        }
        return Math.sqrt(Math.pow(otherPoint.x - this.x, 2) + Math.pow(otherPoint.y - this.y, 2));
    }

    //returns true if this Point is in the quadrant specified
    @Override
    public boolean inQuadrant(int quadrant) {
        //check if x and y are negative or positive depending on the quadrant
        switch (quadrant) {
            case 1:
                if (this.x > 0 && this.y > 0) {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (this.x < 0 && this.y > 0) {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (this.x < 0 && this.y < 0) {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (this.x > 0 && this.y < 0) {
                    return true;
                } else {
                    return false;
                }
                //throw exception if quadrant doesn't exist
            default:
                throw new IllegalArgumentException();
        }
    }

    //returns nothing & shifts (or translates) this Point by the x,y distances received
    @Override
    public void translate(int xMove, int yMove) {
        this.x += xMove;
        this.y += yMove;
    }

    //returns a String representing this instance in the form (x, y)
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    //returns true if it is equal to what is received (as an Object)
    @Override
    public boolean equals(Object obj) {
        //checks that a Point object was passed in
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Point)) {
            return false;
        }

        //cast object as Point
        Point otherPoint = (Point) obj;
        if (this.x == otherPoint.x && this.y == otherPoint.y) {
            return true;
        } else {
            return false;
        }
    }


}
