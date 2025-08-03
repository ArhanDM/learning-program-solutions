import java.util.Arrays;
import java.util.Comparator;

public class SearchEngine {

    // Linear search by product name
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Binary search (array must be sorted by productName)
    public static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    // Sort products by productName (for binary search)
    public static void sortProductsByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
    }
}
