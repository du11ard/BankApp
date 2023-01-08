import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//Launcher class has 1 method that launches menu with several options for user
public class Launcher {

    static void launch() throws IOException{
        DataGetter getter = new DataGetter();
        Calculating calc = new Calculating();
        Formatting formatting = new Formatting();
        while(true){
            System.out.println("1. Customers from file prospects.txt");
            System.out.println("2. Enter prospects by yourself");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int choice = Integer.parseInt(reader.readLine());
            switch (choice){
                case 1:
                    ArrayList<Customer> customerList = getter.readFromFile();
                    for (Customer customer : customerList){
                        calc.calculateMonthlyPayment(customer);
                        formatting.showOutput(customer);
                    }
                    break;
                case 2:
                    Customer customer = getter.getFromKeyboard();
                    calc.calculateMonthlyPayment(customer);
                    formatting.showOutput(customer);
                    break;
                case 0:
                    System.out.print("Are you sure? (Y/n): ");
                    String confidence = reader.readLine().toUpperCase();
                    switch (confidence){
                        case "Y":
                        case "YES":
                            System.exit(0);
                        case "N":
                        case "NO":
                            break;
                    }
                    break;
                default:
                    System.out.println("Try again");
            }
        }
    }
}
