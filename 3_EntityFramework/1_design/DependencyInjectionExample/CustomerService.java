public class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void showCustomer(String customerId) {
        String customer = customerRepository.findCustomerById(customerId);
        System.out.println("Fetched: " + customer);
    }
}
