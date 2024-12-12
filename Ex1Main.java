import java.util.Scanner;
import java.io.*;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                System.out.println("num1= "+num1+" is number: "+Ex1.isNumber(num1)+" , value: "+Ex1.number2Int(num1));
                if(!Ex1.isNumber(num1)) {
                    System.out.println("ERR: num1 is in the wrong format! "+"("+num1+")");
                    continue;
                }
            }
            else{
                break; //if num1 equals quit, quit the program.
            }
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (!num2.equals("quit")) {
                System.out.println("num2= "+num2+" is number: "+Ex1.isNumber(num2)+" , value: "+Ex1.number2Int(num2));
                if(!Ex1.isNumber(num2)) {
                    System.out.println("ERR: num2 is in the wrong format! ("+num2+")");
                    continue;
                }
            }
            else{
                break;//if num2 equals quit, quit the program.
            }
            System.out.println("Enter a base for output: (a number [2,16] ");
            int base= sc.nextInt();
            if(base<2 || base > 16) {
                System.out.println("ERR: wrong base, should be [2,16], got ("+base+")");
                continue;
            }
            else{
                String addition=Ex1.int2Number((Ex1.number2Int(num1))+(Ex1.number2Int(num2)),base); // adds the decimal presentation of num1,num2 together and changes it to the required base
                String multiplication=Ex1.int2Number((Ex1.number2Int(num1))*(Ex1.number2Int(num2)),base);//multiplies the decimal presentation of num1,num2 and changes it to the required base
                String[] arr={ String.valueOf(num1),String.valueOf(num2),addition,multiplication}; //creates the arry and makes sure all the elements are string. (in case num1/num2 are deciaml)
                System.out.println(num1+" + "+num2+" = "+addition);
                System.out.println(num1+" * " +num2+" = "+multiplication);
                System.out.println("Max number over ["+num1+","+num2+","+addition+","+multiplication+"] is: "+Ex1.maxIndex(arr));
            }
        }
        System.out.println("quiting now...");
    }
}
