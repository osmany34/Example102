package TechnologyStore;

public class Notebook extends Product {
    private int ram;
    private int storage;
    private double screenSize;

    public Notebook(int id, String name, double price, double discount, int stock, Brand brand, int ram, int storage, double screenSize) {
        super(id, name, price, discount, stock, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }
    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }


    @Override
    public String toString() {
        return String.format("| %2d | %-30s | %-9.2f | %-14s | %-7dGB | %-7dGB SSD | %-6.1f inç |", getId(), getName(), getPrice(), getBrand().getName(), ram, storage, screenSize);
    }

}
