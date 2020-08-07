import java.util.Scanner;

public class Homework3_37291 {
    /*
     * Homework #3
     * Date: 07-10-20
     * Purpose: Use input from console to calculate the volume and surface area of a cuboid.
     * Author: Krupa Dhruva
     */

    public static void main(String[] args) {
        System.out.println("My name is Krupa Dhruva");
        System.out.println("This program calculates the volume and surface area of a cuboid.");

        Scanner input = new Scanner(System.in);

        double length;
        System.out.println("Enter the cuboid length: ");
        length = input.nextDouble();

        double height;
        System.out.println("Enter the cuboid height: ");
        height = input.nextDouble();

        double width;
        System.out.println("Enter the cuboid width: ");
        width = input.nextDouble();

        double cuboidVolume;
        cuboidVolume = length * height * width;

        double surfaceArea;
        surfaceArea = 2 * ((length * width) + (length * height) + (width * height));

        System.out.printf("Volume of the cuboid (length %f / height %f / width %f) is %.2f\n",
                length, height, width, cuboidVolume);

        System.out.printf("Surface area of the cuboid (length %f / height %f / width %f) is %.2f\n",
                length, height, width, surfaceArea);
    }
}
