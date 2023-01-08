public class Formatting {

    public String formatMoney(double money){
        return new String(String.format("%.2f", money) + " ¤");
    }

    public void showOutput(Customer customer){
        int id = customer.getId();
        String name = customer.getCustomerName();
        String totalLoan = formatMoney(customer.getTotalLoan());
        String years = Integer.toString(customer.getYears());
        String monthPay = formatMoney(customer.getMonthPay());

        System.out.printf("Prospect %d : %s wants to borrow %s for a period of %s years and pay %s each month\n", id, name, totalLoan, years, monthPay);
    }
}
