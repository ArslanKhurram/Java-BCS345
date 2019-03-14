/*
Arslan Khurram
HW1
BCS345
01/24/19
*/

import java.util.Scanner;

public class SumNums {
    public static void main(String[] args) {

        System.out.print("Enter a Number: ");

        //reads input from user into NUM
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        //SUM will hold the total of all numbers
        //tmp will hold the input as it runs through the condition
        int sum = 0, tmp = 0;

        //the condition will check if input is positive
        //loop will read numbers entered by user and add them into variable SUM
        for (int i = 0; i < num; i++) {
            System.out.print("Enter Number (" + (1 + i) + "): ");
            tmp = input.nextInt();
            sum += (tmp > 0) ? tmp : 0;
        }
        System.out.println("This is your sum: " + sum);

        input.close();
    }
}
