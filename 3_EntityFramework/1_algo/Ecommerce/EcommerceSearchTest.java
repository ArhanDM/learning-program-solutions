public class EcommerceSearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shampoo", "Health"),
            new Product(103, "Camera", "Electronics"),
            new Product(104, "Shoes", "Fashion"),
            new Product(105, "Watch", "Accessories")
        };

        // Linear Search
        Product result1 = SearchEngine.linearSearch(products, "Shoes");
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Product not found"));

        // Sort for Binary Search
        SearchEngine.sortProductsByName(products);

        // Binary Search
        Product result2 = SearchEngine.binarySearch(products, "Shoes");
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Product not found"));
    }
}
