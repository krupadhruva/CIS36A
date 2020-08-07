import java.util.Scanner;

/*
 * Midterm Part C
 * Date: July 16, 2020
 * Purpose: For Midterms Exam
 * Author: Krupa Dhruva
 */
public class Store_37491 {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);

        System.out.printf("Enter the memory size of the console (32 or 16 gigabytes): ");
        final int memory = scan.nextInt();
        if (memory != 16 && memory != 32) {
            System.out.println("Invalid memory size!");
            return;
        }

        System.out.printf("Enter the quality of the console (N for New, R for Refurbished, or D for Dented): ");
        final String quality = scan.next();
        if (!quality.equals("N") && !quality.equals("R") && !quality.equals("D")) {
            System.out.println("Invalid quality!");
            return;
        }

        System.out.printf("Enter the console quantity to buy: ");
        final int quantity = scan.nextInt();
        if (quantity < 0) {
            System.out.println("Invalid quantity!");
            return;
        }

        double itemPrice = 0.0;

        // No default case since error handling is already done above.
        switch (quality) {
            case "N":
                if (memory == 16) {
                    itemPrice = 499.99;
                } else {
                    itemPrice = 549.99;
                }
                break;
            case "R":
                if (memory == 16) {
                    itemPrice = 419.99;
                } else {
                    itemPrice = 429.99;
                }
                break;
            case "D":
                if (memory == 16) {
                    itemPrice = 339.99;
                } else {
                    itemPrice = 359.99;
                }
                break;
        }

        // Sales Tax of 9.25% is 0.0925
        final double salesTax = itemPrice * 0.0925;

        System.out.printf("\nThe item price is $%.2f\n", itemPrice * quantity);
        System.out.printf("The sale tax is   $%.2f\n", salesTax * quantity);
        System.out.printf("The total bill is $%.2f\n", (itemPrice + salesTax) * quantity);
    }
}