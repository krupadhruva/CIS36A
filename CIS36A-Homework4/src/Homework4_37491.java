import java.util.Scanner;

public class Homework4_37491 {
    /*
     * Homework #4
     * Date: 07-13-20
     * Purpose: Write code to determine if input year is a leap year or not using if-else statements.
     * Author: Krupa Dhruva
     */

    public static void main(String[] args) {
        System.out.println("My name is Krupa Dhruva.");
        System.out.println("This program determines leap year.");

        System.out.println("Enter a year (not earlier than 1582):");
        Scanner year = new Scanner(System.in);
        int input = year.nextInt();

        if (input < 1582) {
            System.out.println("Invalid because the year is earlier than 1582.");
        } else if ((input % 4 == 0) && ((input % 100 != 0) || (input % 400 == 0))) {
            System.out.println("The year " + input + " is a leap year.");
        } else {
            System.out.println("The year " + input + " is not a leap year.");
        }
    }
}