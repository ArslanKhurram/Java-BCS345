import java.io.*;
import java.util.Scanner;

public class StatsDemo {

    public static void main(String[] args) throws IOException {

        double sum = 0; // The sum of the numbers
        int count = 0; // The number of numbers added
        double mean = 0; // The average of the numbers
        double stdDev = 0; // The standard deviation
        String line = ""; // To hold a line from the file
        double difference = 0; // The value and mean difference
        double differencePow = 0;// The difference raised to the 2nd power
        double summation = 0; //Summation of difference and mean
        double stdDevBeforeSqrt = 0; //Value before taking square root
        double[] data = new double[2500];

        //Create an object of type Scanner
        Scanner keyboard = new Scanner(System.in);
        String filename; // The user input file name
        //Prompt the user and read in the file name
        System.out.println("This program calculates " +
                "statistics on a file " +
                "containing a series of numbers");
        System.out.print("Enter the output file name: ");
        filename = keyboard.nextLine();

        // Read data from input file
        FileReader fr = new FileReader("Numbers.txt");
        BufferedReader br = new BufferedReader(fr);

        //Calculate sum
        while (line != null) {

            line = br.readLine();

            //When null value is read it will not be added into sum
            if (line != null) {

                data[count] = Double.parseDouble(line); //line will be set into Data[array]
                sum += data[count]; //adds values into sum
                count++;
            }
        }
        //Calculate mean
        mean = sum / count;

        //Population Standard Deviation
        for (int i = 0; i <= count; i++) {

            difference = (data[i] - mean); //calculates the difference between value and mean
            differencePow = Math.pow(difference, 2); //squares the difference
            summation += differencePow; //adds differencePow into summation
        }

        stdDevBeforeSqrt = summation / (count); //divide summation by count
        stdDev = Math.sqrt(stdDevBeforeSqrt); //take the square root

        //Print the results to the output file
        FileWriter fw = new FileWriter(filename, true);
        PrintWriter pw = new PrintWriter(fw);

        //Print output into file
        pw.print("Sum: ");
        pw.printf("%.3f", sum);
        pw.println();
        pw.println("Count: " + count);
        pw.print("Mean: ");
        pw.printf("%.3f", mean);
        pw.println();
        pw.print("Standard Deviation: ");
        pw.printf("%.3f", stdDev);

        //Close file
        pw.close();
        fw.close();
        br.close();
        fr.close();
    }

}
