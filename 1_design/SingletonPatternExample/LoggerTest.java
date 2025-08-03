package singleton;

public class LoggerTest {
    public static void main(String[] args) {
        // Get Logger instance
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message.");

        // Try getting another instance
        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message.");

        // Check if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (Singleton confirmed).");
        } else {
            System.out.println("Logger instances are different (Singleton failed).");
        }
    }
}
