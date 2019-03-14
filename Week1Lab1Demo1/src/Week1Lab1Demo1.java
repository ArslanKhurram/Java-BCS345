/*
Arslan Khurram
HW1
BCS345
01/24/19
 */

import java.util.Scanner;

public class Week1Lab1Demo1 {
    public static void main(String[] args) {

        System.out.print("Enter a Number: ");

        //reads input from user into NUM
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        //SUM will hold the total of all numbers
        int sum=0, tmp=0, i=0;

        //loop will read numbers entered by user and add them into variable SUM
        do
        {
            System.out.println("Enter Number ("+( 1+i)+"): " );
            tmp= input.nextInt();
            sum+= (tmp>0)?tmp:0;
            i++;

        }while(i<num);
        System.out.println("This is your sum: " + sum);

        input.close();
    }
}
