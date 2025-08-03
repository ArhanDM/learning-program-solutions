import java.util.HashMap;

public class InventoryManager {
    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Add a product
    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    // Update a product
    public void updateProduct(int productId, String newName, int newQty, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.productName = newName;
            product.quantity = newQty;
            product.price = newPrice;
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        if (inventory.remove(productId) == null) {
            System.out.println("Product not found.");
        }
    }

    // Display inventory
    public void displayInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}
