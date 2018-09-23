// This program will test the ColorCircle class

public class ColorCircleTesterHG {
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

            //check null endpoint
            try {
                Point thisPoint = null;
                int thisRadius = 6;
                String thisColor = "Green";

                if (printDescription)
                    System.out.println("==>Testing parameterized constructor/toString(): passing in " + thisPoint + "  and  " + thisRadius + " and " + thisColor);

                ColorCircle c0 = new ColorCircle(thisPoint, thisRadius, thisColor);
                System.out.println(c0);
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName());
                //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
            }

            //check various values
            int numPoints = 2;
            int[] radiusArray = {3, 0, -1};
            String[] colorArray = {"Pink", "Cyan"};

            for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++)
                    for (int colorIndex = 0; colorIndex < colorArray.length; colorIndex++) {
                        try {
                            Point thisPoint = makeNewPoint(new int[]{5, 4}, new int[]{-1, 7}, ptIndex);
                            int thisRadius = radiusArray[radIndex];
                            String thisColor = colorArray[colorIndex];

                            if (printDescription)
                                System.out.println("==>Testing parameterized constructor/toString(): passing in " + thisPoint + "  and  " + thisRadius + " and " + thisColor);

                            ColorCircle c0 = new ColorCircle(thisPoint, thisRadius, thisColor);
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
                ColorCircle c0 = new ColorCircle();
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
                ColorCircle c0 = null;
                String origToString = "<empty>";
                ColorCircle argColorCircle = null;
                String origArgToString = "<empty>";

                try {
                    c0 = new ColorCircle(new Point(-1, 8), 3, "Purple");
                    origToString = c0.toString();

                    argColorCircle = null;

                    if (printDescription)
                        System.out.println("==>Testing copy constructor/toString(): passing in " + argColorCircle);

                    c0 = new ColorCircle(argColorCircle);
                    origToString = c0.toString();
                    System.out.println(c0);
                } catch (Throwable ex) {
                    System.out.println(ex.getClass().getName());
                    //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                } finally {
                    if (argColorCircle != null) {
                        //check to be sure that argument Circle did not accidentally change
                        if (!argColorCircle.toString().equals(origArgToString))
                            System.out.println("...but the argument ColorCircle CHANGED during the operation");

                        //now change argColorCircle on purpose to see if it was a shallow copy
                        if (argColorCircle != null) {
                            argColorCircle.translate(5, 5);
                            if (!origToString.equals(c0.toString()))
                                System.out.println("...but the ColorCircle that was created had a SHALLOW copy of its center");
                        }
                    }
                }

            }

            //now test the copy constructor passing in various ColorCircles as arguments
            System.out.println();
            int numPoints = 2;
            int[] radiusArray = {6, 7};
            String[] colorArray = {"Pink", "Cyan"};

            for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++)
                    for (int colorIndex = 0; colorIndex < colorArray.length; colorIndex++) {
                        ColorCircle c0 = null;
                        String origToString = "<empty>";
                        ColorCircle argColorCircle = null;
                        String origArgToString = "<empty>";

                        try {
                            Point thisPoint = makeNewPoint(new int[]{-4, 2}, new int[]{1, -3}, ptIndex);
                            int thisRadius = radiusArray[radIndex];
                            String thisColor = colorArray[colorIndex];

                            argColorCircle = new ColorCircle(thisPoint, thisRadius, thisColor);
                            if (argColorCircle != null)
                                origArgToString = argColorCircle.toString();

                            if (printDescription)
                                System.out.println("==>Testing copy constructor/toString(): passing in " + argColorCircle);

                            c0 = new ColorCircle(argColorCircle);
                            origToString = c0.toString();
                            System.out.println(c0);
                        } catch (Throwable ex) {
                            System.out.println(ex.getClass().getName());
                            //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                        } finally {
                            if (argColorCircle != null) {
                                //check to be sure that argument ColorCircle did not accidentally change
                                if (!argColorCircle.toString().equals(origArgToString))
                                    System.out.println("...but the argument ColorCircle CHANGED during the operation");

                                //now change argColorCircle on purpose to see if it was a shallow copy
                                argColorCircle.translate(5, 5);
                                if (!origToString.equals(c0.toString()))
                                    System.out.println("...but the ColorCircle that was created had a SHALLOW copy of its center");
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

                                ColorCircle c0 = new ColorCircle(thisPoint, thisRadius, "Gray");

                                if (printDescription)
                                    System.out.println("==>telling " + c0 + " to translate(" + deltaX + ", " + deltaY + ")");

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
            ColorCircle c0 = null;
            String origToString = "uninitialized";

            for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++) {
                    try {
                        Point thisPoint = makeNewPoint(new int[]{3, -1}, new int[]{4, -5}, ptIndex);
                        int thisRadius = radiusArray[radIndex];

                        c0 = new ColorCircle(thisPoint, thisRadius, "Orange");
                        origToString = c0.toString();

                        if (printDescription)
                            System.out.println("==>telling " + c0 + " to getArea()      (it will be displayed as 3 decimal places)");

                        double theArea = c0.getArea();
                        System.out.printf("%.3f" + "\n", theArea);
                    } catch (Throwable ex) {
                        System.out.println(ex.getClass().getName());
                        //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                    } finally {
                        if (!origToString.equals(c0.toString()))
                            System.out.println("...but the ColorCircle CHANGED during the operation");
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
            ColorCircle c0 = null;
            String origToString = "uninitialized";

            for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++) {
                    try {
                        Point thisPoint = makeNewPoint(new int[]{2, -1}, new int[]{-4, 7}, ptIndex);
                        int thisRadius = radiusArray[radIndex];

                        c0 = new ColorCircle(thisPoint, thisRadius, "Gray");
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
                            System.out.println("...but the ColorCircle CHANGED during the operation");
                    }
                }
        }

        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing isRed") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            String[] colorArray = {"Blue", "Red", "rED", "REd", "green"};
            ColorCircle c0 = null;
            String origToString = "uninitialized";

            for (int colorIndex = 0; colorIndex < colorArray.length; colorIndex++) {
                try {
                    String thisColor = colorArray[colorIndex];

                    c0 = new ColorCircle(new Point(5, -2), 3, thisColor);
                    origToString = c0.toString();

                    if (printDescription)
                        System.out.println("==>asking " + c0 + " if isRed()");

                    boolean result = c0.isRed();
                    System.out.println(result);
                } catch (Throwable ex) {
                    System.out.println(ex.getClass().getName());
                    //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                } finally {
                    if (!origToString.equals(c0.toString()))
                        System.out.println("...but the ColorCircle CHANGED during the operation");
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

            //declare ColorCircles and Strings to hold their toStrings.  Always declare an argument ColorCircle even if not used
            ColorCircle c0 = null;
            ColorCircle argColorCircle = null;
            String origToString = "uninitialized";
            String origArgToString = "uninitialized";

            //first, check that it handles a null argument
            try {
                c0 = new ColorCircle(new Point(4, -7), 2, "Magenta");
                origToString = c0.toString();
                argColorCircle = null;

                if (printDescription)
                    System.out.println("==>asking " + c0 + " if it intersects( " + argColorCircle + " )");

                System.out.println(c0.intersects(argColorCircle));
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName());
                //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
            } finally {
                if (!origToString.equals(c0.toString()))
                    System.out.println("...but the original ColorCircle CHANGED during the operation");
            }

            //now check lots of cases (using arrays of Points and radii)
            System.out.println();
            int numPoints = 2;
            int[] radiusArray = {3, 4, 5};
            for (int ptIndex = 0; ptIndex < numPoints; ptIndex++)
                for (int radIndex = 0; radIndex < radiusArray.length; radIndex++)
                    for (int argPtIndex = 0; argPtIndex < numPoints; argPtIndex++)
                        for (int argRadIndex = 0; argRadIndex < radiusArray.length; argRadIndex++) {
                            if ((ptIndex != argPtIndex) && (radIndex != argRadIndex))   //only test of Point, radius are different for the ColorCircles
                            {
                                try {
                                    Point thisPoint = makeNewPoint(new int[]{3, 4}, new int[]{-4, 4}, ptIndex);
                                    Point argPoint = makeNewPoint(new int[]{3, 4}, new int[]{-4, 4}, argPtIndex);

                                    int thisRadius = radiusArray[radIndex];
                                    int argRadius = radiusArray[argRadIndex];

                                    c0 = new ColorCircle(thisPoint, thisRadius, "Blue");
                                    origToString = c0.toString();
                                    argColorCircle = new ColorCircle(argPoint, argRadius, "Green");
                                    origArgToString = argColorCircle.toString();

                                    if (printDescription)
                                        System.out.println("==>asking " + c0 + " if it intersects( " + argColorCircle + " )");

                                    System.out.println(c0.intersects(argColorCircle));
                                } catch (Throwable ex) {
                                    System.out.println(ex.getClass().getName());
                                    //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                                } finally {
                                    if (!origToString.equals(c0.toString()))
                                        System.out.println("...but the original ColorCircle CHANGED during the operation");
                                    if (argColorCircle != null && !origArgToString.equals(argColorCircle.toString()))
                                        System.out.println("...but the argument ColorCircle CHANGED during the operation");
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

            //declare ColorCircles and Strings to hold their toStrings.  Always declare an argument ColorCircle even if not used
            ColorCircle c0 = null;
            ColorCircle argColorCircle = null;
            String origToString = "uninitialized";
            String origArgToString = "uninitialized";

            //first, check that it handles a null argument
            try {
                c0 = new ColorCircle(new Point(4, -7), 2, "Gray");
                origToString = c0.toString();
                argColorCircle = null;

                if (printDescription)
                    System.out.println("==>asking " + c0 + " if isInside( " + argColorCircle + " )");

                System.out.println(c0.intersects(argColorCircle));
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName());
                //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
            } finally {
                if (!origToString.equals(c0.toString()))
                    System.out.println("...but the original ColorCircle CHANGED during the operation");
                if (argColorCircle != null && !origArgToString.equals(argColorCircle.toString()))    //if it exists in this test...
                    System.out.println("...but the original ColorCircle CHANGED during the operation");
            }

            //now check lots of cases (using arrays of Points and radii)

            System.out.println();
            int numPoints = 3;
            int[] radiusArray = {7, 2, 3};
            for (int c0Index = 0; c0Index < numPoints; c0Index++)    //Point #0 will go with radiusArray[0], etc.
                for (int argIndex = 0; argIndex < numPoints; argIndex++)    //Point #1 will go with radiusArray[1], etc.
                {
                    //			if ((ptIndex != argPtIndex) && (radIndex != argRadIndex))   //only test of Point, radius are different for the ColorCircles
                    //			{
                    try {
                        Point thisPoint = makeNewPoint(new int[]{8, 7, 4}, new int[]{8, 11, 8}, c0Index);
                        int thisRadius = radiusArray[c0Index];
                        Point argPoint = makeNewPoint(new int[]{8, 7, 4}, new int[]{8, 11, 8}, argIndex);
                        int argRadius = radiusArray[argIndex];

                        c0 = new ColorCircle(thisPoint, thisRadius, "Blue");
                        origToString = c0.toString();
                        argColorCircle = new ColorCircle(argPoint, argRadius, "Green");
                        origArgToString = argColorCircle.toString();

                        if (printDescription)
                            System.out.println("==>asking " + c0 + " if it isInside( " + argColorCircle + " )");

                        System.out.println(c0.isInside(argColorCircle));
                    } catch (Throwable ex) {
                        System.out.println(ex.getClass().getName());
                        //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                    } finally {
                        if (!origToString.equals(c0.toString()))
                            System.out.println("...but the original ColorCircle CHANGED during the operation");
                        if (argColorCircle != null && !origArgToString.equals(argColorCircle.toString()))
                            System.out.println("...but the argument ColorCircle CHANGED during the operation");
                    }
                }
        }

        //***************************************************
        //***************************************************

        if (test.equalsIgnoreCase("testing equals") ||
                test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            //declare variables c0 and argColorCircle along with Strings to hold their toStrings
            ColorCircle c0 = null;
            String origToString = "<empty>";
            ColorCircle argColorCircle = null;
            String origArgToString = "<empty>";

            //first, check to see if a ColorCircle .equals null
            {
                try {
                    c0 = new ColorCircle(new Point(3, 5), 4, "Red");
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
                        System.out.println("...but the original ColorCircle CHANGED during the operation.");
                    if (argColorCircle != null && !origArgToString.equals(argColorCircle.toString()))      //if it was used (not null)
                        System.out.println("...but the argument ColorCircle CHANGED during the operation");
                }
            }

            //next, check to see if a ColorCircle .equals a String (different class)
            {
                System.out.println();
                try {
                    c0 = new ColorCircle(new Point(4, 5), 3, "Red");
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
                        System.out.println("...but the original ColorCircle CHANGED during the operation.");
                    if (argColorCircle != null && !origArgToString.equals(argColorCircle.toString()))      //if it was used (not null)
                        System.out.println("...but the argument ColorCircle CHANGED during the operation");
                }
            }

            //next, check to see if a ColorCircle .equals another ColorCircle if various values change
            {
                System.out.println();

                int[] valueArray = {3, 5};

                for (int xIndex = 0; xIndex < valueArray.length; xIndex++)
                    for (int yIndex = 0; yIndex < valueArray.length; yIndex++)
                        for (int radIndex = 0; radIndex < valueArray.length; radIndex++) {
                            try {
                                //create the original ColorCircle
                                Point p0 = new Point(3, 5);   //same as values in the array
                                int radius0 = 3;   //same as a value in the array
                                c0 = new ColorCircle(p0, radius0, "Red");
                                origToString = c0.toString();

                                //create argument ColorCircle with values from the valueArray
                                Point argPoint = new Point(valueArray[xIndex], valueArray[yIndex]);
                                int argRadius = valueArray[radIndex];
                                argColorCircle = new ColorCircle(argPoint, argRadius, "Blue");
                                origArgToString = argColorCircle.toString();

                                if (printDescription)
                                    System.out.println("==>asking " + c0 + " if it equals( " + argColorCircle + " )");

                                boolean result = c0.equals(argColorCircle);
                                System.out.println(result);
                            } catch (Throwable ex) {
                                System.out.println(ex.getClass().getName());
                                //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                            } finally {
                                if (checkChanges && !c0.toString().equals(origToString))
                                    System.out.println("...but the original ColorCircle CHANGED during the operation.");
                                if (argColorCircle != null && !origArgToString.equals(argColorCircle.toString()))      //if it was used (not null)
                                    System.out.println("...but the argument ColorCircle CHANGED during the operation");
                            }
                        }
            }
            //finally, check to see if a Circle equals a ColorCircle and vice versa (make sure .instanceOf is not used!)
            {
                System.out.println();

                Circle circ = null;
                ColorCircle colorCirc = null;
                String circToString = "<empty>";
                String colorCircToString = "<empty>";

                //does a Circle equal a ColorCircle if all values are the same?
                try {
                    circ = new Circle(new Point(4, 5), 6);
                    circToString = circ.toString();
                    colorCirc = new ColorCircle(new Point(4, 5), 6, "Blue");
                    colorCircToString = colorCirc.toString();

                    if (printDescription)
                        System.out.println("==>asking " + circ + " if it equals( " + colorCirc + " )");

                    boolean result = circ.equals(colorCirc);
                    System.out.println(result);
                } catch (Throwable ex) {
                    System.out.println(ex.getClass().getName());
                    //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                } finally {
                    if (checkChanges && !circ.toString().equals(circToString))
                        System.out.println("...but the original Circle CHANGED during the operation.");
                    if (colorCirc != null && !colorCircToString.equals(colorCirc.toString()))      //if it was used (not null)
                        System.out.println("...but the argument ColorCircle CHANGED during the operation");
                }

                //does a ColorCircle equal a Circle if the values are the same?
                try {
                    circ = new Circle(new Point(4, 5), 6);
                    circToString = circ.toString();
                    colorCirc = new ColorCircle(new Point(4, 5), 6, "Blue");
                    colorCircToString = colorCirc.toString();

                    if (printDescription)
                        System.out.println("==>asking " + colorCirc + " if it equals( " + circ + " )");

                    boolean result = colorCirc.equals(circ);
                    System.out.println(result);
                } catch (Throwable ex) {
                    System.out.println(ex.getClass().getName());
                    //ex.printStackTrace();      //UNCOMMENT THIS ONE TO SEE MORE DETAILS
                } finally {
                    if (checkChanges && !circ.toString().equals(circToString))
                        System.out.println("...but the original ColorCircle CHANGED during the operation.");
                    if (colorCirc != null && !colorCircToString.equals(colorCirc.toString()))      //if it was used (not null)
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