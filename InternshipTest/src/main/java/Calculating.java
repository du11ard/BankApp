public class Calculating {

    public int yearInMonth(int year){
        return year * 12;
    }

    public double calculateMonthlyInterest(double yearInterest){
        return yearInterest / 12;
    }

    public void calculateMonthlyPayment(Customer customer){
        int months = yearInMonth(customer.getYears());
        double monthlyInterest = calculateMonthlyInterest(customer.getYearInterest());
        double totalLoan = customer.getTotalLoan();
        double interimNum = pow((1 + monthlyInterest), months);
        double monthlyPayment = totalLoan * (monthlyInterest * interimNum) / (interimNum - 1);
        customer.setMonthPay(monthlyPayment);
    }

    public double pow(double base, int exp){
        double result = 1;
        for(int i = 0; i < exp; i++){
            result = result * base;
        }
        return result;
    }
}