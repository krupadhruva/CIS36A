import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Homework #7
 * Date: July 31, 2020
 * Purpose: To access, read, and use information within a file.
 * Author: Krupa Dhruva
 */

public class File_37491 {
    public static void main(String args[]) throws IOException {
        final String fileName = "numbers.txt";

        Scanner scanner = new Scanner(new FileReader(fileName));
        // Skip the first line since it has a string
        if (scanner.hasNext()) {
            scanner.next();
        }

        // If there are no numbers, no further processing
        if (!scanner.hasNext()) {
            scanner.close();
            return;
        }

        int count = 1;
        int smallest = 0;
        int largest = 0;
        double average = 0.0;

        smallest = largest = scanner.nextInt();
        average = (double) smallest;

        while (scanner.hasNext()) {
            ++count;
            int val = scanner.nextInt();

            if (val < smallest) {
                smallest = val;
            }

            if (val > largest) {
                largest = val;
            }

            average += (double) val;
        }

        scanner.close();

        // Compute the average since we have the total and count
        average /= count;

        int countOfLessThanAverage = 0;
        int countOfGreaterThanAverage = 0;
        scanner = new Scanner(new FileReader(fileName));
        // Skip the first line with string
        scanner.next();

        while (scanner.hasNext()) {
            int val = scanner.nextInt();
            if ((double) val < average) {
                ++countOfLessThanAverage;
            } else if ((double) val > average) {
                ++countOfGreaterThanAverage;
            }
        }

        scanner.close();

        // Since example output shows output of average as integer when there are no residual decimals
        // https://intellipaat.com/community/10884/how-to-nicely-format-floating-numbers-to-string-without-unnecessary-decimal-0
        final String avgStr = (average == (int) average) ? String.valueOf((int) average) : String.format("%.4f", average);

        System.out.format("%25s %25d%n", "Smallest", smallest);
        System.out.format("%25s %25d%n", "Largest", largest);
        System.out.format("%25s %25s%n%n", "Average", avgStr);
        System.out.format("%25s %25d%n", "Numbers below the average", countOfLessThanAverage);
        System.out.format("%25s %25d%n", "Numbers above the average", countOfGreaterThanAverage);
    }
}
