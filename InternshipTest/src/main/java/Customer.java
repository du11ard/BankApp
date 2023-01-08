import java.util.Date;

public class Customer {
    private static int counter;
    private int id;
    private String customerName;
    private double totalLoan;
    private double yearInterest;
    private int years;
    private double monthPay;

    public Customer(String customerName, double totalLoan, double yearInterest, int years){
        this.id = counter++;
        this.customerName = customerName;
        this.totalLoan = totalLoan;
        this.yearInterest = yearInterest / 100;
        this.years = years;
    }

    public int getId(){
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getYearInterest() {
        return yearInterest;
    }

    public int getYears() {
        return years;
    }

    public double getMonthPay(){
        return monthPay;
    }

    public void setMonthPay(double monthPay) {
        this.monthPay = monthPay;
    }
}
