public class InventoryTest {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Laptop", 10, 75000));
        manager.addProduct(new Product(102, "Mouse", 50, 500));
        manager.updateProduct(101, "Gaming Laptop", 5, 95000);
        manager.deleteProduct(103); // Product not found
        manager.displayInventory();
    }
}
