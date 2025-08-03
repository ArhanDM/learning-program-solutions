public class BuilderTest {
    public static void main(String[] args) {
        // Basic computer with only required parts
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();

        // Gaming computer with all parts
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setKeyboard("Mechanical RGB")
                .setMonitor("4K 144Hz")
                .build();

        // Office computer with selective parts
        Computer officeComputer = new Computer.Builder("AMD Ryzen 5", "16GB")
                .setStorage("512GB SSD")
                .setMonitor("1080p 60Hz")
                .build();

        // Print configurations
        System.out.println(basicComputer);
        System.out.println(gamingComputer);
        System.out.println(officeComputer);
    }
}
