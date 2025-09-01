package a11springjpa;

import a11springjpa.config.AppConfig;
import a11springjpa.dao.LoanDaoWithTransactions;
import a11springjpa.model.Customer;
import a11springjpa.model.Loan;
import a11springjpa.model.Transaction;
import a11springjpa.service.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class FinancialApp {

    public static void main1(String[] args) {
        // Load Spring context from AppConfig (JPA configuration)
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

            // Retrieve LoanDao bean from the context
            LoanDaoWithTransactions loanDao = context.getBean(LoanDaoWithTransactions.class);

            // 1. Create a new loan
            Loan newLoan = new Loan(0, "Home Loan", 500000, 6.5, 20);
            loanDao.createLoan(newLoan);
            System.out.println("Loan created: " + newLoan);

            // 2. Retrieve all loans
            System.out.println("All Loans:");
            loanDao.getAllLoans().forEach(System.out::println);



            // 3. Retrieve loan by ID (assuming the created loan has ID 1)
            Loan loanById = loanDao.getLoanById(2);
            System.out.println("Loan by ID (1): " + loanById);

            // 4. Update loan details
            if (loanById != null) {
                loanById.setLoanType("Updated Home Loan");
                loanDao.updateLoan(loanById);
                System.out.println("Loan updated: " + loanById);
            }

            // 5. Delete a loan (assuming we delete the loan with ID 1)
            loanDao.deleteLoan(4);
            System.out.println("Loan with ID 1 deleted.");

            // 6. Check the remaining loans after deletion
            System.out.println("All Loans After Deletion:");
            loanDao.getAllLoans().forEach(System.out::println);



        }
    }

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class))
        {
            CustomerService customerService = context.getBean(CustomerService.class);

            String customerName="Harish";
            Customer customer = new Customer(customerName);
            String transactionType="Saving";
            double transactionAmount=23.3;
            Transaction transaction = new Transaction(transactionType, transactionAmount);
            customerService.createCustomerWithTransactions(customer, transaction);



            //cascade should work
            long id =23;
            customerService.deleteCustomer(id);

            id =25;
            customerService.deleteTransaction(id);

        }

    }


}
