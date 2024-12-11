import java.util.Scanner;
import java.io.*;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num3;
        int basee;
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                // add your code here
                System.out.println(Ex1.isNumber(num1));
                System.out.println(Ex1.number2Int(num1));
                System.out.println("enter num3, base");
                num3 = sc.nextInt();
                basee = sc.nextInt();
                System.out.println(Ex1.int2Number(num3,basee));
                ///////////////////////
            }
        }
        System.out.println("quiting now...");
    }
}
