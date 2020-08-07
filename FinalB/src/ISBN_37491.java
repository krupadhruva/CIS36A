import java.util.Scanner;

/*
 * Final Part B
 * Date: August 6, 2020
 * Purpose: Validate ISBN, compute checksum and print formatted ISBN with checksum
 * Author: Krupa Dhruva
 */

public class ISBN_37491 {

    private final String first9Digits;
    private final char checkSum;

    public ISBN_37491(String first9DigCode) {
        this.first9Digits = first9DigCode;
        checkSum = calculateCheckSum();
    }

    public static boolean validateInput(String userInput) {
        if (userInput.length() != 9) {
            return false;
        }

        for (int index = 0; index < userInput.length(); ++index) {
            switch (userInput.charAt(index)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    // Valid entries, break from switch and process
                    break;
                default:
                    // Invalid field in ISBN (not a valid digit)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String isbn;
        Scanner in = new Scanner(System.in);
        System.out.println("This program calculates the checksum of a 9-digit ISBN code " +
                "and displays the 10-digit ISBN.");
        System.out.print("Enter the 9 digits for the ISBN code or X to exit: ");
        isbn = in.next();
        while (!isbn.equals("X")) {
            boolean isValid = validateInput(isbn);
            if (!isValid) {
                System.out.println("The input ISBN code is not valid.");
            } else {
                // Fill in the blank code
                ISBN_37491 isbnObj = new ISBN_37491(isbn);
                System.out.printf("%-40s%10s", "The 10-digit ISBN code is", isbnObj.getTenChar());
                System.out.println();
                System.out.printf("%-40s%10s", "The hyphen-formatted ISBN code is", isbnObj.formatWithHyphen());
                System.out.println();
            }
            System.out.print("Enter the 9 digits for the ISBN code or X to exit: ");
            isbn = in.next();
        }
    }

    public char getCheckSum() {
        return checkSum;
    }

    public String getFirst9Digits() {
        return first9Digits;
    }

    public String getTenChar() {
        return getFirst9Digits() + getCheckSum();
    }

    private char calculateCheckSum() {
        int checkSum = 0;
        for (int index = 0; index < first9Digits.length(); ++index) {
            char digit = first9Digits.charAt(index);
            int val = Character.getNumericValue(digit);
            checkSum += (val * (index + 1));
        }

        checkSum = checkSum % 11;
        char checkSumCode = 'X';
        if (checkSum < 10) {
            checkSumCode = Character.forDigit(checkSum, 10);
        }

        return checkSumCode;
    }

    public String formatWithHyphen() {
        // Source: https://stackoverflow.com/questions/36560379/java-isbn-formatting
        return String.format("%s-%s-%s-%c",
                first9Digits.substring(0, 0 + 1),
                first9Digits.substring(1, 1 + 3),
                first9Digits.substring(4, 4 + 5),
                checkSum);
    }
}
