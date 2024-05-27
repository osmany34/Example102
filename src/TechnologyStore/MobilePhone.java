package TechnologyStore;

public class MobilePhone extends Product {
    private int memory;
    private double screenSize;
    private double batteryPower;
    private int ram;
    private String color;
    private int camera;

    public MobilePhone(int id, String name, double price, double discount, int stock, Brand brand, int memory, double screenSize, double batteryPower, int ram, String color) {
        super(id, name, price, discount, stock, brand);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
        this.camera = camera;
    }

    public int getMemory() {
        return memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public double getBatteryPower() {
        return batteryPower;
    }

    public int getRam() {
        return ram;
    }

    public String getColor() {
        return color;
    }

    public int getCamera() {
        return camera;
    }

    @Override
    public String toString() {
        return String.format("| %2d | %-30s | %-9.2f | %-14s | %-7dGB | %-6.1f inç | %-8.1f mAh | %-5dGB | %-7s | %-7d |", getId(), getName(), getPrice(), getBrand().getName(), memory, screenSize, batteryPower, ram, color, camera);
    }
}
