import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//DataGetter class has 4 methods for validating and getting data from file and input
public class DataGetter {

    //Reads data from file from root folder of project
    public ArrayList<Customer> readFromFile() {
        ArrayList<Customer> customersList = new ArrayList<Customer>();
        try {
            List<String> customerLines = Files.readAllLines(java.nio.file.Paths.get("prospects.txt"));
            removeNonValidRows(customerLines);
            for (int i = 0; i < customerLines.size(); i++) {
                String[] tokens = customerLines.get(i).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                String name = tokens[0];
                double totalLoan = Double.parseDouble(tokens[1]);
                if(totalLoan < 1){
                    throw new IllegalArgumentException("Loan can not be less than 1");
                }
                double interest = Double.parseDouble(tokens [2]);
                if(interest < 1){
                    throw new IllegalArgumentException("Interest can not be less than 1");
                }
                int years = Integer.parseInt(tokens[3]);
                if(years < 1){
                    throw new IllegalArgumentException("Interest can not be less than 1");
                }
                Customer customer = new Customer(name, totalLoan, interest, years);
                customersList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customersList;
    }

    //Getting data from user's input
    public Customer getFromKeyboard() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer's name: ");
        String name = sc.nextLine();
        System.out.print("Enter total loan: ");
        if(sc.nextDouble() < 1){
            throw new IllegalArgumentException("Loan can not be less than 1");
        }
        double totalLoan = sc.nextDouble();
        System.out.print("Enter interest: ");
        if(sc.nextDouble() < 1){
            throw new IllegalArgumentException("Interest can not be less than 1");
        }
        double interest = sc.nextDouble();
        System.out.print("Enter amount of years: ");
        if(sc.nextInt() < 1){
            throw new IllegalArgumentException("Interest can not be less than 1");
        }
        int years = sc.nextInt();

        Customer customer = new Customer(name, totalLoan, interest, years);
        return customer;
    }

    //Remove all rows from file that don't contain any digits
    public void removeNonValidRows(List list){
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext())
        {
            String s = iterator.next();
            if (!checkIfHasDigits(s))
            {
                iterator.remove();
            }
        }
    }

    //Check if there is any digit in the row
    public boolean checkIfHasDigits(String string){
        if(string.equals(null) || string.isBlank() || string.isEmpty()){
            return false;
        }
        char[] chars = string.toCharArray();
        for(char ch : chars){
            if(Character.isDigit(ch)){
                return true;
            }
        }
        return false;
    }
}
