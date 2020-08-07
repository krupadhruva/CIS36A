import com.sun.tools.jconsole.JConsoleContext;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import java.io.ObjectInput;
import java.util.Scanner;
import java.util.jar.JarInputStream;

/*
 * Purpose: Simple Calculator Tool (Not yet interactive with Main/Input)
 * Created: July 2, 2020 at 9:59 PM
 * Author: Krupa Dhruva
 */

/* Updates (I don't know how to use Git yet)
 * Initially wrote only if statements without using else statements
 * If will go through all statements & then evaluate
 * Else statement will check until match is found
 * (07-03-20, 11:58 AM)
 *Learnt to use case insensitive feature!
 *Made calculator receive inputs from standard input (07-04-20, 12:44 PM)
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float value1;
        System.out.println("Enter your first value: ");
        value1 = sc.nextFloat();
        float value2;
        System.out.println("Enter your second value: ");
        value2 = sc.nextFloat();
        String operation;
        System.out.println("Choose the operation: ");
        operation = sc.next();

        if (operation.equalsIgnoreCase("add")) {
            System.out.println(value1 + value2);
        } else if (operation.equalsIgnoreCase("subtract")) {
            System.out.println(value1 - value2);
        } else if (operation.equalsIgnoreCase("multiply")) {
            System.out.println(value1 * value2);
        } else if (operation.equalsIgnoreCase("divide")) {
            System.out.println((float) value1 / value2);
        } else {
            System.out.println("Operator: " + '"' + operation + '"' + " not supported.");
        }

    }
}
