package a04configuration;

public class LoanReportImpl implements LoanReport {

    private final CustomerService customerService;

    // Constructor-based Dependency Injection
    public LoanReportImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void generateReport(int customerId, double principal, double interest) {
        String customerName = customerService.getCustomerName(customerId);
        System.out.println("Loan Report for " + customerName + ":");
        System.out.println("Principal: " + principal);
        System.out.println("Interest: " + interest);
        System.out.println("Total Amount: " + (principal + interest));
    }
}

