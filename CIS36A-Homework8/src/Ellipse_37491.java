import java.util.Scanner;

/*
 * Homework #8
 * Date: August 7, 2020
 * Purpose: To calculate the focus, the area, and the circumference of an ellipse.
 * Author: Krupa Dhruva
 */
final public class Ellipse_37491 {

    private final double majorRadius;
    private final double minorRadius;

    // Constructor with no arguments
    public Ellipse_37491() {
        // Avoid duplication by reusing overloaded constructor
        this(1.0, 1.0);
    }

    // Constructor with 2 arguments
    public Ellipse_37491(double majRadius, double minRadius) {
        this.majorRadius = majRadius;
        this.minorRadius = minRadius;
    }

    public static void main(String args[]) {
        // For testing: Create a file with different inputs and redirect to System.in
        // Example: java Ellipse_37491 < testdata.txt

        Scanner scanner = new Scanner(System.in);
        System.out.println("This program calculates the focus, area, and circumference of an ellipse.");

        // Sentinel state to break out of loop
        final int SENTINEL = -1;

        // Since sentinel is compared against user input inside loop, we perform check against SENTINEL
        // inside the loop
        double majorRadius;

        // Duplicate: Show message for the first time before entering the loop
        System.out.printf("%nEnter the major radius value or enter -1 to exit: ");

        while (SENTINEL != (majorRadius = scanner.nextDouble())) {
            System.out.print("Enter the minor radius value: ");
            double minorRadius = scanner.nextDouble();

            switch (validateInput(majorRadius, minorRadius)) {
                case -1:
                    System.out.println("Error: the input cannot be negative");
                    break;
                case -2:
                    System.out.println("Error: the major radius must not be smaller than the minor radius");
                    break;
                case 0:
                    Ellipse_37491 ellipse = new Ellipse_37491(majorRadius, minorRadius);
                    System.out.format("The focus of the ellipse is %.2f%n" +
                            "The ellipse area is %.2f%n" +
                            "The ellipse circumference is %.2f%n", ellipse.getEllipseFocus(), ellipse.getEllipseArea(), ellipse.getEllipseCircumference());
            }

            // Duplicate: Display the prompt since we read the input in 'while' condition
            System.out.printf("%nEnter the major radius value or enter -1 to exit: ");
        }

        scanner.close();

        System.out.println("Goodbye");
    }

    // Check that majorRadius and minorRadius are both not negative and check that
    // majorRadius >= minorRadius
    // Return -1 if either major or minor radius is negative
    // Return -2 if majorRadius < minorRadius
    // Return 0 if all arguments are valid
    // Do not print anything
    public static int validateInput(double majorRadius, double minorRadius) {
        if (majorRadius < 0.0 || minorRadius < 0.0) {
            return -1;
        } else if (majorRadius < minorRadius) {
            return -2;
        } else {
            return 0;
        }
    }

    // Calculate and return the area of ellipse
    // Do not print anything
    public double getEllipseArea() {
        // PI(ab)
        return Math.PI * majorRadius * minorRadius;
    }

    // Calculate and return the circumference of ellipse
    // Do not print anything
    public double getEllipseCircumference() {
        // PI(3(a + b) - (10(ab) + 3(a^2 + b^2))^1/2)
        return Math.PI * ((3 * (majorRadius + minorRadius)) - Math.sqrt(
                (10 * majorRadius * minorRadius) + (3 * (Math.pow(majorRadius, 2.0) + Math.pow(minorRadius, 2.0)))));
    }

    // Calculate and return the focus of ellipse
    // Do not print anything
    public double getEllipseFocus() {
        // (a^2 - b^2)^1/2
        return Math.sqrt(Math.pow(majorRadius, 2.0) - Math.pow(minorRadius, 2.0));
    }

    // Return the major radius of ellipse
    // Do not print anything
    public double getMajorRadius() {
        return majorRadius;
    }

    // Return the minor radius of ellipse
    // Do not print anything
    public double getMinorRadius() {
        return minorRadius;
    }
}
