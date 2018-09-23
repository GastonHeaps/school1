// This program will test the Circle class's extra credit (inQuadrant)
public class CircleTesterHGExtraCredit {
    public static void main(String[] args) {
        //get the arguments for the test
        java.util.Scanner kb = new java.util.Scanner(System.in);
        String test = kb.nextLine();

        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing parameterized constructor") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            //check null center
            try {
                Point thisPoint = null;
                int thisRadius = 6;

                if (printDescription)
                    System.out.println("==>Testing parameterized constructor/toString(): passing in " + thisPoint + "  and  " + thisRadius);

                Circle c0 = new Circle(thisPoint, thisRadius);
                System.out.println(c0);
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName());
                //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
            }

            //check various values
            int numPoints = 2;
            int[] radiusArray = {3, 0, -1};

            for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++) {
                    try {
                        Point thisPoint = makeNewPoint(new int[]{5, 4}, new int[]{-1, 7}, ptIndex);
                        int thisRadius = radiusArray[radIndex];
                        if (printDescription)
                            System.out.println("==>Testing parameterized constructor/toString(): passing in " + thisPoint + "  and  " + thisRadius);

                        Circle c0 = new Circle(thisPoint, thisRadius);
                        System.out.println(c0);
                    } catch (Throwable ex) {
                        System.out.println(ex.getClass().getName());
                        //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                    }
                }
        }

        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing inQuadrant") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            Circle c0 = null;    //code creates one
            Circle argCircle = null;
            String origToString = "uninitialized";
            String origArgToString = "uninitialized";

            //first, check that it handles an illegal quadrant
            int[] badQuadrantArray = {0, 5, 7};

            for (int quadIndex = 0; quadIndex < badQuadrantArray.length; quadIndex++) {
                try {
                    int badQuadrant = badQuadrantArray[quadIndex];
                    c0 = new Circle(new Point(4, -7), 3);
                    origToString = c0.toString();

                    if (printDescription)
                        System.out.println("==>asking" + c0 + " if it is inQuadrant(" + badQuadrant + ")");

                    System.out.println(c0.inQuadrant(badQuadrant));
                } catch (Throwable ex) {
                    System.out.println(ex.getClass().getName());
                    //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                } finally {
                    if (!origToString.equals(c0.toString()))
                        System.out.println("...but the original Circle CHANGED during the operation");
                    if (argCircle != null && !origArgToString.equals(argCircle.toString()))
                        System.out.println("...but the argument Circle CHANGED during the operation");
                }
            }

            //now check using one Circle in each quadrant
            System.out.println();
            int numPoints = 5;
            int[] radiusArray = {1, 2, 3};

            for (int quadrant = 1; quadrant <= 4; quadrant++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++) {
                    try {
                        Point center = makeNewPoint(new int[]{0, 3, -2, -3, 2}, new int[]{0, 2, 3, -6, -2}, quadrant);
                        int radius = radiusArray[radIndex];

                        c0 = new Circle(center, radius);
                        origToString = c0.toString();

                        if (printDescription)
                            System.out.println("==>asking" + c0 + " if it is inQuadrant(" + quadrant + ")");

                        System.out.println(c0.inQuadrant(quadrant));
                    } catch (Throwable ex) {
                        System.out.println(ex.getClass().getName());
                        //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                    } finally {
                        if (!origToString.equals(c0.toString()))
                            System.out.println("...but the original Circle CHANGED during the operation");
                        if (argCircle != null && !origArgToString.equals(argCircle.toString()))      //if it was used (not null)
                            System.out.println("...but the argument Circle CHANGED during the operation");
                    }
                }
        }

    }   //end of main

    //------------------------------------------------

    //makeNewPoint - returns a new Point from the array with x,y's
    public static Point makeNewPoint(int[] xArray, int[] yArray, int theIndex) {
        if (xArray.length != yArray.length)
            throw new IllegalArgumentException("must have same number of x's, y's to make Points");

        return new Point(xArray[theIndex], yArray[theIndex]);
    }

}  //end of class
