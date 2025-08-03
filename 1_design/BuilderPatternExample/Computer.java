public class Computer {
    // Required parameters
    private final String CPU;
    private final String RAM;

    // Optional parameters
    private final String storage;
    private final String graphicsCard;
    private final String keyboard;
    private final String monitor;

    // Private constructor to enforce use of Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.keyboard = builder.keyboard;
        this.monitor = builder.monitor;
    }

    // Static nested Builder class
    public static class Builder {
        private final String CPU;
        private final String RAM;

        private String storage;
        private String graphicsCard;
        private String keyboard;
        private String monitor;

        // Constructor with required parameters
        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        // Setter methods for optional parameters
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder setMonitor(String monitor) {
            this.monitor = monitor;
            return this;
        }

        // Build method to construct Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    // For printing Computer configuration
    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM +
               ", Storage=" + storage + ", GraphicsCard=" + graphicsCard +
               ", Keyboard=" + keyboard + ", Monitor=" + monitor + "]";
    }
}
 