public class DIExampleTest {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject repository into service
        CustomerService service = new CustomerService(repository);

        // Use the service
        service.showCustomer("22053146");
    }
}
