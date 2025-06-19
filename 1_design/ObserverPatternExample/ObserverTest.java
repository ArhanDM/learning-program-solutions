public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileUser = new MobileApp("Alice");
        Observer webUser = new WebApp("Bob");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        System.out.println("--- Stock Update 1 ---");
        stockMarket.setStockData("AAPL", 192.50);

        System.out.println("\n--- Stock Update 2 ---");
        stockMarket.setStockData("GOOGL", 2805.75);

        // Unsubscribe one user
        stockMarket.removeObserver(mobileUser);

        System.out.println("\n--- Stock Update 3 ---");
        stockMarket.setStockData("TSLA", 672.88);
    }
}
