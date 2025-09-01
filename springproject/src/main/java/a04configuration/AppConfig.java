package a04configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public LoanService loanService() {
        return new LoanServiceImpl();
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl();
    }

    @Bean
    public LoanReport loanReport() {
        return new LoanReportImpl(customerService());
    }
}

