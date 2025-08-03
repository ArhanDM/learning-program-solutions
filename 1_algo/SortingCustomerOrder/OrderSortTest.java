public class OrderSortTest {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 450.0),
            new Order(2, "Bob", 1200.0),
            new Order(3, "Charlie", 300.0),
            new Order(4, "Daisy", 800.0)
        };

        // Test Bubble Sort
        System.out.println("Using Bubble Sort:");
        BubbleSorter.bubbleSort(orders);
        for (Order o : orders) {
            System.out.println(o);
        }

        // Reset array
        orders = new Order[] {
            new Order(1, "Alice", 450.0),
            new Order(2, "Bob", 1200.0),
            new Order(3, "Charlie", 300.0),
            new Order(4, "Daisy", 800.0)
        };

        // Test Quick Sort
        System.out.println("\nUsing Quick Sort:");
        QuickSorter.quickSort(orders, 0, orders.length - 1);
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
