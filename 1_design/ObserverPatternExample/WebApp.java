public class WebApp implements Observer {
    private String username;

    public WebApp(String username) {
        this.username = username;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("WebApp - " + username + ": " + stockName + " updated to $" + price);
    }
}
