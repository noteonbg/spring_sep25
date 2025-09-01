package a05lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FinancialApp {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FinancialAppConfig.class)) {

            // Fetch Singleton loan bean
            Loan loan1 = context.getBean("loanSingleton", Loan.class);
            Loan loan2 = context.getBean("loanSingleton", Loan.class);

            System.out.println("Singleton loan1: " + loan1);
            System.out.println("Singleton loan2: " + loan2);
            System.out.println("Are both Singleton loans the same? " + (loan1 == loan2));

            // Fetch Prototype loan bean
            Loan loan3 = context.getBean("loanPrototype", Loan.class);
            Loan loan4 = context.getBean("loanPrototype", Loan.class);

            System.out.println("Prototype loan3: " + loan3);
            System.out.println("Prototype loan4: " + loan4);
            System.out.println("Are both Prototype loans the same? " + (loan3 == loan4));
        }
    }
}
