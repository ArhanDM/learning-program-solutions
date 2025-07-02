public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "Arhan Dasmunshi"));
        context.executePayment(2500.00);

        // Switch to PayPal
        context.setPaymentStrategy(new PayPalPayment("arhan@example.com"));
        context.executePayment(1500.50);
    }
}
