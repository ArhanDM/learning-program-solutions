public class ProxyTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("--- First call (loads image1) ---");
        image1.display();  // Loads and displays

        System.out.println("--- Second call (cached image1) ---");
        image1.display();  // Only displays

        System.out.println("--- First call (loads image2) ---");
        image2.display();  // Loads and displays
    }
}
