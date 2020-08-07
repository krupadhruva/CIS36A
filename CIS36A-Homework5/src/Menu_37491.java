import java.util.Scanner;

public class Menu_37491 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Java restaurant. \n" +
                "Please choose 1 of the following items :\n" +
                "\n" + "a- Grilled salmon, price $26.99\n" +
                "b- New York Steak, price $18.99\n" +
                "c- Roast Chicken, price $12.99\n" +
                "d- Salad, price $5.99\n" +
                "e- Soup, price $7.99\n" +
                "f- Hamburger, price $4.99\n" +
                "g- Soft drink, price $1.29\n" +
                "h- Tea, price $1.50\n" +
                "i- Orange juice, price $2.50\n");
        System.out.println("Select a letter from the above menu:");
        String itemname = input.next();

        System.out.println("Enter the quantity:");
        int itemquantity = input.nextInt();

        String itemfullname;
        double itemunitprice = 0.0;
        switch (itemname) {
            case "a":
                if (itemquantity < 0 || itemquantity > 50) {
                    System.out.println("Invalid quantity.");
                    return;
                }

                itemfullname = "Grilled salmon";
                itemunitprice = 26.99;
                break;
            case "b":
                if (itemquantity < 0 || itemquantity > 50) {
                    System.out.println("Invalid quantity.");
                    return;
                }

                itemfullname = "New York Steak";
                itemunitprice = 18.99;
                break;
            case "c":
                if (itemquantity < 0 || itemquantity > 50) {
                    System.out.println("Invalid quantity.");
                    return;
                }

                itemfullname = "Roast Chicken";
                itemunitprice = 12.99;
                break;
            case "d":
                if (itemquantity < 0 || itemquantity > 200) {
                    System.out.println("Invalid quantity.");
                    return;
                }

                itemfullname = "Salad";
                itemunitprice = 5.99;
                break;
            case "e":
                if (itemquantity < 0 || itemquantity > 200) {
                    System.out.println("Invalid quantity.");
                    return;
                }

                itemfullname = "Soup";
                itemunitprice = 7.99;
                break;
            case "f":
                if (itemquantity < 0 || itemquantity > 200) {
                    System.out.println("Invalid quantity.");
                    return;
                }

                itemfullname = "Hamburger";
                itemunitprice = 4.99;
                break;
            case "g":
                if (itemquantity < 0 || itemquantity > 200) {
                    System.out.println("Invalid quantity.");
                    return;
                }

                itemfullname = "Soft drink";
                itemunitprice = 1.29;
                break;
            case "h":
                if (itemquantity < 0 || itemquantity > 200) {
                    System.out.println("Invalid quantity.");
                    return;
                }

                itemfullname = "Tea";
                itemunitprice = 1.50;
                break;
            case "i":
                if (itemquantity < 0 || itemquantity > 200) {
                    System.out.println("Invalid quantity.");
                    return;
                }

                itemfullname = "Orange juice";
                itemunitprice = 2.50;
                break;
            default:
                System.out.println("Invalid item. Please choose another option.");
                return;
        }

        System.out.printf("The item price for (%d x %s) is: $%.2f\n", itemquantity, itemfullname, itemunitprice);
        System.out.printf("The sale tax is $%.2f\n", itemquantity * itemquantity * 0.09);

        System.out.println("Enter the gratuity amount:");
        System.out.printf("The total price is $%.2f\n", input.nextDouble() + (itemquantity * itemunitprice * 1.09));
        System.out.println("Thank you for your order!");
//Print error message if letter entered is invalid
//
    }
}
