public class PaymentTest {
    public static void main(String[] args) {
        // Using PayPal
        PaymentProcessor paypalProcessor = new PaypalAdapter(new PaypalGateway());
        paypalProcessor.processPayment(2500.00);

        // Using Stripe
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(4500.50);
    }
}
