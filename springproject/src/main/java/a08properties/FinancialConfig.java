package a08properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@PropertySource("classpath:financial-config.properties")  // Load properties file
public class FinancialConfig {

    // Inject individual properties into Spring beans
    @Value("${loan.maxAmount}")
    private double maxLoanAmount;

    @Value("${loan.minAmount}")
    private double minLoanAmount;

    @Value("${loan.interestRate}")
    private double interestRate;

    @Value("${loan.term}")
    private int loanTerm;

    // Bean to use the injected properties in a financial service
    @Bean
    public LoanService loanService() {
        return new LoanService(maxLoanAmount, minLoanAmount, interestRate, loanTerm);
    }
}
