package a04configuration;

public class LoanServiceImpl implements LoanService {

    @Override
    public double calculateInterest(double principal, double rate, int years) {
        return (principal * rate * years) / 100;
    }
}

