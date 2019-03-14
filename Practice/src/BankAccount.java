import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BankAccount{

    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter outputFile = new PrintWriter("test.txt");
        outputFile.println("Hello");
        outputFile.close();
    }
}
