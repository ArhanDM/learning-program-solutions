public class EmployeeSystemTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(101, "Alice", "Manager", 85000));
        manager.addEmployee(new Employee(102, "Bob", "Developer", 60000));
        manager.addEmployee(new Employee(103, "Charlie", "Analyst", 50000));

        System.out.println("All Employees:");
        manager.displayEmployees();

        System.out.println("\nSearch for Employee ID 102:");
        Employee e = manager.searchEmployee(102);
        System.out.println(e != null ? e : "Not found");

        System.out.println("\nDelete Employee ID 102:");
        manager.deleteEmployee(102);
        manager.displayEmployees();
    }
}
