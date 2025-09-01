package a04configuration;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public String getCustomerName(int customerId) {
        // In a real-world application, this would fetch data from a database
        return "Customer" + customerId;
    }
}
