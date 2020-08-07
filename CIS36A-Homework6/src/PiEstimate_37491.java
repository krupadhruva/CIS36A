import java.util.Scanner;

/*
 * Homework #6
 * Date: July 27, 2020
 * Purpose: Using to loops to estimate PI value
 * Author: Krupa Dhruva
 */

public class PiEstimate_37491 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program estimates the value of PI using the Madhava-Leibniz method \n"
                + "Enter a count that will be used for the series iterations:");
        final int N = input.nextInt();
        if (N <= 0) {
            System.out.println("Count must be greater than 0.");
            return;
        }

        // Pre-compute the square root of 12 and reuse
        final double sqrt12 = Math.sqrt(12);

        double sign = 1.0;
        double sigma = 0.0;
        for (int count = 1; count <= N; ++count) {
            final int odd = (2 * count) - 1;
            sigma += (sign / (odd * Math.pow(3.0, count - 1)));
            sign *= (-1.0);

            // Alternatively: Altering sign using power of negative number
            // Would work faster because the sign flipping is already taken care of in the denominator
            // sigma += (1 / (odd * Math.pow(-3.0, count - 1)));

            System.out.printf("%d- %.14f\n", count, sqrt12 * sigma);
        }

        System.out.printf("\nThe PI constant in Java Math class is: %.14f\n", Math.PI);
    }
}
