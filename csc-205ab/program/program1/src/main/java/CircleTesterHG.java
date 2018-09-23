// This program will test the Circle class

public class CircleTesterHG {
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

        if (test.equalsIgnoreCase("testing default constructor") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            try {
                if (printDescription)
                    System.out.println("==>Testing default constructor/toString()");
                Circle c0 = new Circle();
                System.out.println(c0);
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName());
                //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
            }
        }

        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing copy constructor") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            //test the copy  constructor with null argument
            {
                Circle c0 = null;
                String origToString = "<empty>";
                Circle argCircle = null;
                String origArgToString = "<empty>";

                try {
                    c0 = new Circle(new Point(-1, 8), 3);
                    origToString = c0.toString();

                    argCircle = null;

                    if (printDescription)
                        System.out.println("==>Testing copy constructor/toString(): passing in " + argCircle);

                    c0 = new Circle(argCircle);
                    origToString = c0.toString();
                    System.out.println(c0);
                } catch (Throwable ex) {
                    System.out.println(ex.getClass().getName());
                    //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                } finally {
                    if (argCircle != null) {
                        //check to be sure that argument Circle did not accidentally change
                        if (!argCircle.toString().equals(origArgToString))
                            System.out.println("...but the argument Circle CHANGED during the operation");

                        //now change argCircle on purpose to see if it was a shallow copy
                        if (argCircle != null) {
                            argCircle.translate(5, 5);
                            if (!origToString.equals(c0.toString()))
                                System.out.println("...but the Circle that was created had a SHALLOW copy of its center");
                        }
                    }
                }

            }

            //build different Circles to pass into the copy constructor
            System.out.println();
            int numPoints = 2;
            int[] radiusArray = {6, 7};

            for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++) {
                    Circle c0 = null;
                    String origToString = "<empty>";
                    Circle argCircle = null;
                    String origArgToString = "<empty>";

                    try {
                        Point thisPoint = makeNewPoint(new int[]{-4, 2}, new int[]{1, -3}, ptIndex);
                        int thisRadius = radiusArray[radIndex];

                        argCircle = new Circle(thisPoint, thisRadius);
                        if (argCircle != null)
                            origArgToString = argCircle.toString();

                        if (printDescription)
                            System.out.println("==>Testing copy constructor/toString(): passing in " + argCircle);

                        c0 = new Circle(argCircle);
                        origToString = c0.toString();
                        System.out.println(c0);
                    } catch (Throwable ex) {
                        System.out.println(ex.getClass().getName());
                        //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                    } finally {
                        if (argCircle != null) {
                            //check to be sure that argument Circle did not accidentally change
                            if (!argCircle.toString().equals(origArgToString))
                                System.out.println("...but the argument Circle CHANGED during the operation");

                            //now change argCircle on purpose to see if it was a shallow copy
                            argCircle.translate(5, 5);
                            if (!origToString.equals(c0.toString()))
                                System.out.println("...but the Circle that was created had a SHALLOW copy of its center");
                        }
                    }

                }
        }

        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing translate") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            int numPoints = 2;
            int[] radiusArray = {5};
            int[] deltaXArray = {5, 0};
            int[] deltaYArray = {0, -3};


            for (int deltaXIndex = 0; deltaXIndex < deltaXArray.length; deltaXIndex++)
                for (int deltaYIndex = 0; deltaXIndex < deltaYArray.length; deltaXIndex++)
                    for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                        for (int radIndex = 0; radIndex < radiusArray.length; radIndex++) {
                            try {
                                Point thisPoint = makeNewPoint(new int[]{6, -5}, new int[]{4, -3}, ptIndex);
                                int thisRadius = radiusArray[radIndex];
                                int deltaX = deltaXArray[deltaXIndex];
                                int deltaY = deltaYArray[deltaYIndex];

                                Circle c0 = new Circle(thisPoint, thisRadius);

                                if (printDescription)
                                    System.out.println("==>telling" + c0 + " to translate(" + deltaX + ", " + deltaY + ")");

                                c0.translate(deltaX, deltaY);
                                System.out.println(c0);
                            } catch (Throwable ex) {
                                System.out.println(ex.getClass().getName());
                                //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                            }
                        }
        }

        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing getArea") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            int numPoints = 2;
            int[] radiusArray = {1, 2, 5};
            Circle c0 = null;
            String origToString = "uninitialized";

            for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++) {
                    try {
                        Point thisPoint = makeNewPoint(new int[]{3, -1}, new int[]{4, -5}, ptIndex);
                        int thisRadius = radiusArray[radIndex];

                        c0 = new Circle(thisPoint, thisRadius);
                        origToString = c0.toString();

                        if (printDescription)
                            System.out.println("==>telling" + c0 + " to getArea()      (it will be displayed as 3 decimal places)");

                        double theArea = c0.getArea();
                        System.out.printf("%.3f" + "\n", theArea);
                    } catch (Throwable ex) {
                        System.out.println(ex.getClass().getName());
                        //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                    } finally {
                        if (!origToString.equals(c0.toString()))
                            System.out.println("...but the Circle CHANGED during the operation");
                    }
                }
        }

        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing getDiameter") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            int numPoints = 2;
            int[] radiusArray = {3, 4, 6};
            Circle c0 = null;
            String origToString = "uninitialized";

            for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++) {
                    try {
                        Point thisPoint = makeNewPoint(new int[]{2, -1}, new int[]{-4, 7}, ptIndex);
                        int thisRadius = radiusArray[radIndex];

                        c0 = new Circle(thisPoint, thisRadius);
                        origToString = c0.toString();

                        if (printDescription)
                            System.out.println("==>telling " + c0 + " to getDiameter()");

                        int theDiameter = c0.getDiameter();
                        System.out.println(theDiameter);
                    } catch (Throwable ex) {
                        System.out.println(ex.getClass().getName());
                        //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                    } finally {
                        if (!origToString.equals(c0.toString()))
                            System.out.println("...but the Circle CHANGED during the operation");
                    }
                }
        }

        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing intersects") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            //declare Circles and Strings to hold their toStrings.  Always declare an argument Circle even if not used
            Circle c0 = null;
            Circle argCircle = null;
            String origToString = "uninitialized";
            String origArgToString = "uninitialized";

            //first, check that it handles a null argument
            try {
                c0 = new Circle(new Point(4, -7), 2);
                origToString = c0.toString();
                argCircle = null;

                if (printDescription)
                    System.out.println("==>asking" + c0 + " if it intersects( " + argCircle + " )");

                System.out.println(c0.intersects(argCircle));
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName());
                //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
            } finally {
                if (!origToString.equals(c0.toString()))
                    System.out.println("...but the original Circle CHANGED during the operation");
            }

            //now check lots of cases (using arrays of Points and radii)
            System.out.println();
            int numPoints = 2;
            int[] radiusArray = {3, 4, 5};

            for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++)
                    for (int argPtIndex = 0; argPtIndex < numPoints; argPtIndex++)
                        for (int argRadIndex = 0; argRadIndex < radiusArray.length; argRadIndex++) {
                            if ((ptIndex != argPtIndex) && (radIndex != argRadIndex))   //only test of Point, radius are different for the Circles
                            {
                                try {
                                    Point thisPoint = makeNewPoint(new int[]{3, 4}, new int[]{-4, 4}, ptIndex);
                                    Point argPoint = makeNewPoint(new int[]{3, 4}, new int[]{-4, 4}, argPtIndex);

                                    int thisRadius = radiusArray[radIndex];
                                    int argRadius = radiusArray[argRadIndex];

                                    c0 = new Circle(thisPoint, thisRadius);
                                    origToString = c0.toString();
                                    argCircle = new Circle(argPoint, argRadius);
                                    origArgToString = argCircle.toString();

                                    if (printDescription)
                                        System.out.println("==>asking" + c0 + " if it intersects( " + argCircle + " )");

                                    System.out.println(c0.intersects(argCircle));
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
                        }
        }

        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing isInside") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            //declare Circles and Strings to hold their toStrings.  Always declare an argument Circle even if not used
            Circle c0 = null;
            Circle argCircle = null;
            String origToString = "uninitialized";
            String origArgToString = "uninitialized";

            //first, check that it handles a null argument
            try {
                c0 = new Circle(new Point(4, -7), 2);
                origToString = c0.toString();
                argCircle = null;

                if (printDescription)
                    System.out.println("==>asking" + c0 + " if isInside( " + argCircle + " )");

                System.out.println(c0.intersects(argCircle));
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName());
                //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
            } finally {
                if (!origToString.equals(c0.toString()))
                    System.out.println("...but the original Circle CHANGED during the operation");
                if (argCircle != null && !origArgToString.equals(argCircle.toString()))    //if it exists in this test...
                    System.out.println("...but the original Circle CHANGED during the operation");
            }

            //now check lots of cases (using arrays of Points and radii)

            System.out.println();
            int numPoints = 3;
            int[] radiusArray = {7, 2, 3};

            for (int c0Index = 0; c0Index < numPoints; c0Index++)    //pointArray[0] will go with radiusArray[0], etc.
                for (int argIndex = 0; argIndex < numPoints; argIndex++)    //pointArray[1] will go with radiusArray[1], etc.
                {
                    //			if ((ptIndex != argPtIndex) && (radIndex != argRadIndex))   //only test of Point, radius are different for the Circles
                    //			{
                    try {
                        Point thisPoint = makeNewPoint(new int[]{8, 7, 4}, new int[]{8, 11, 8}, c0Index);
                        int thisRadius = radiusArray[c0Index];
                        Point argPoint = makeNewPoint(new int[]{8, 7, 4}, new int[]{8, 11, 8}, argIndex);
                        int argRadius = radiusArray[argIndex];

                        c0 = new Circle(thisPoint, thisRadius);
                        origToString = c0.toString();
                        argCircle = new Circle(argPoint, argRadius);
                        origArgToString = argCircle.toString();

                        if (printDescription)
                            System.out.println("==>asking" + c0 + " if it isInside( " + argCircle + " )");

                        System.out.println(c0.isInside(argCircle));
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
        }

        //***************************************************
        //***************************************************

/*		if (test.equalsIgnoreCase("testing inQuadrant") ||
                    test.equalsIgnoreCase("testing all"))
            {
                    System.out.println("\n-----------------------------\n");
                    boolean printDescription = true;
                    boolean checkChanges = true;

                    Circle c0 = null;    //code creates one
                    Circle argCircle = null;
                    String origToString = "uninitialized";
                    String origArgToString = "uninitialized";

                    //first, check that it handles an illegal quadrant
                    int[ ] badQuadrantArray = { 0, 5, 7 };

                    for (int quadIndex=0; quadIndex<badQuadrantArray.length; quadIndex++)
                    {
                            try
                            {
                                    int badQuadrant = badQuadrantArray[quadIndex];
                                    c0 = new Circle(new Point(4, -7), 3);
                                    origToString = c0.toString();

                                    if (printDescription)
                                            System.out.println("==>asking" + c0 + " if it is inQuadrant(" + badQuadrant + ")");

                                    System.out.println(c0.inQuadrant(badQuadrant));
                            }
                            catch (Throwable ex)
                            {
                                    System.out.println(ex.getClass().getName());
                                    //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                            }
                            finally
                            {
                                    if (!origToString.equals(c0.toString()))
                                            System.out.println("...but the original Circle CHANGED during the operation");
                                    if (argCircle != null && !origArgToString.equals(argCircle.toString()))
                                            System.out.println("...but the argument Circle CHANGED during the operation");
                            }
                    }

                    //now check using one Circle in each quadrant
                    System.out.println();
                    int numPoints = 5;
                    int[ ] radiusArray = { 1, 2, 3 };

                    for (int quadrant=1; quadrant<=4; quadrant++)
                            for (int radIndex=0; radIndex<radiusArray.length; radIndex++)
                            {
                                    try
                                    {
                                            Point center = makeNewPoint( new int[ ] {0, 3, -2, -3, 2 }, new int[ ] {0, 2, 3, -6, -2 }, quadrant);
                                            int radius = radiusArray[radIndex];

                                            c0 = new Circle(center, radius);
                                            origToString = c0.toString();

                                            if (printDescription)
                                                    System.out.println("==>asking" + c0 + " if it is inQuadrant(" + quadrant + ")");

                                            System.out.println(c0.inQuadrant(quadrant));
                                    }
                                    catch (Throwable ex)
                                    {
                                            System.out.println(ex.getClass().getName());
                                            //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                                    }
                                    finally
                                    {
                                            if (!origToString.equals(c0.toString()))
                                                    System.out.println("...but the original Circle CHANGED during the operation");
                                            if (argCircle != null && !origArgToString.equals(argCircle.toString()))      //if it was used (not null)
                                                    System.out.println("...but the argument Circle CHANGED during the operation");
                                    }
                            }
            }
*/
        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing equals") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            //declare variables c0 and argCircle along with Strings to hold their toStrings
            Circle c0 = null;
            String origToString = "<empty>";
            Circle argCircle = null;
            String origArgToString = "<empty>";

            //first, check to see if a Circle .equals null
            {
                try {
                    c0 = new Circle(new Point(3, 5), 4);
                    origToString = c0.toString();

                    if (printDescription)
                        System.out.println("==>asking " + c0 + " if it equals( " + null + " )");

                    boolean result = c0.equals(null);
                    System.out.println(result);
                } catch (Throwable ex) {
                    System.out.println(ex.getClass().getName());
                    //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                } finally {
                    if (checkChanges && !c0.toString().equals(origToString))
                        System.out.println("...but the original Circle CHANGED during the operation.");
                    if (argCircle != null && !origArgToString.equals(argCircle.toString()))      //if it was used (not null)
                        System.out.println("...but the argument Circle CHANGED during the operation");
                }
            }

            //next, check to see if a Circle .equals a String (different class)
            {
                System.out.println();
                try {
                    c0 = new Circle(new Point(4, 5), 3);
                    origToString = c0.toString();

                    if (printDescription)
                        System.out.println("==>asking " + c0 + " if it equals ( " + origToString + " )     (as a String so different classes)");

                    boolean result = c0.equals(origToString);
                    System.out.println(result);
                } catch (Throwable ex) {
                    System.out.println(ex.getClass().getName());
                    //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                } finally {
                    if (checkChanges && !c0.toString().equals(origToString))
                        System.out.println("...but the original Circle CHANGED during the operation.");
                    if (argCircle != null && !origArgToString.equals(argCircle.toString()))      //if it was used (not null)
                        System.out.println("...but the argument Circle CHANGED during the operation");
                }
            }

            //finally, check to see if a Circle .equals another Circle if various values change
            {
                System.out.println();

                int[] valueArray = {9, 10};

                for (int xIndex = 0; xIndex < valueArray.length; xIndex++)
                    for (int yIndex = 0; yIndex < valueArray.length; yIndex++)
                        for (int radIndex = 0; radIndex < valueArray.length; radIndex++) {
                            try {
                                //create the original Circle
                                Point p0 = new Point(9, 10);   //same as values in the array
                                int radius0 = 9;   //same as a value in the array
                                c0 = new Circle(p0, radius0);
                                origToString = c0.toString();

                                //create argument Circle with values from the valueArray
                                Point argPoint = new Point(valueArray[xIndex], valueArray[yIndex]);
                                int argRadius = valueArray[radIndex];
                                argCircle = new Circle(argPoint, argRadius);
                                origArgToString = argCircle.toString();

                                if (printDescription)
                                    System.out.println("==>asking " + c0 + " if it equals( " + argCircle + " )");

                                boolean result = c0.equals(argCircle);
                                System.out.println(result);
                            } catch (Throwable ex) {
                                System.out.println(ex.getClass().getName());
                                //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                            } finally {
                                if (checkChanges && !c0.toString().equals(origToString))
                                    System.out.println("...but the original Circle CHANGED during the operation.");
                                if (argCircle != null && !origArgToString.equals(argCircle.toString()))      //if it was used (not null)
                                    System.out.println("...but the argument Circle CHANGED during the operation");
                            }
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
