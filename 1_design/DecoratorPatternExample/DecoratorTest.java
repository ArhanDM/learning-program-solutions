public class DecoratorTest {
    public static void main(String[] args) {
        // Base notifier: Email only
        Notifier emailNotifier = new EmailNotifier();

        // Email + SMS
        Notifier emailSMSNotifier = new SMSNotifierDecorator(emailNotifier);

        // Email + SMS + Slack
        Notifier multiChannelNotifier = new SlackNotifierDecorator(emailSMSNotifier);

        System.out.println("----- Email Only -----");
        emailNotifier.send("Welcome to the system!");

        System.out.println("\n----- Email + SMS -----");
        emailSMSNotifier.send("Your OTP is 123456");

        System.out.println("\n----- Email + SMS + Slack -----");
        multiChannelNotifier.send("Server down! Immediate attention needed.");
    }
}
