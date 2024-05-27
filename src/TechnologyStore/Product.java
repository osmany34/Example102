package TechnologyStore;

public class Product {
    private int id;
    private String name;
    private double price;
    private double discount;
    private int stock;
    private Brand brand;

    public Product(int id, String name, double price, double discount, int stock, Brand brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public int getStock() {
        return stock;
    }

    public Brand getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return String.format("| %2d | %-30s | %-9.2f | %-14s |", id, name, price, brand.getName());
    }
}
