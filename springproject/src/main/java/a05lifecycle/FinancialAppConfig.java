package a05lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FinancialAppConfig {

    @Bean
    @Scope("singleton")  // Singleton scope
    public Loan loanSingleton() {
        return new Loan(50000, 5, 10);  // Loan with 50,000 principal, 5% interest, 10-year term
    }

    @Bean
    @Scope("prototype")  // Prototype scope
    public Loan loanPrototype() {
        return new Loan(100000, 6, 15);  // Loan with 100,000 principal, 6% interest, 15-year term
    }
}

