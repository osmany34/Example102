package TechnologyStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PatikaStoreManagement {
    private List<Product> products;
    private List<Brand> brands;
    private Scanner scanner;

    public PatikaStoreManagement() {
        this.products = new ArrayList<>();
        this.brands = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeBrands();
    }

    // Markaları başlatma metodu
    private void initializeBrands() {
        String[] brandNames = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        for (int i = 0; i < brandNames.length; i++) {
            brands.add(new Brand(i + 1, brandNames[i]));
        }
        Collections.sort(brands, Comparator.comparing(Brand::getName));
    }

    // Markaları listeleme metodu
    private void listBrands() {
        System.out.println("Markalarımız");
        System.out.println("--------------");
        for (Brand brand : brands) {
            System.out.println("- " + brand);
        }
    }

    // Cep telefonu listeleme metodu
    private void listMobilePhones() {
        // Cep telefonu listesi
        System.out.println("\nCep Telefonu Listesi\n");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-9s | %-9s | %-10s | %-9s | %-7s | %-9s | %-7s | %-9s |\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Product product : products) {
            if (product instanceof MobilePhone) {
                MobilePhone mobilePhone = (MobilePhone) product;
                System.out.format("| %-2d | %-30s | %-9.2f | %-9s | %-10d | %-9.1f | %-7d | %-9.1f | %-7d | %-9s |\n",
                        mobilePhone.getId(), mobilePhone.getName(), mobilePhone.getPrice(), mobilePhone.getBrand().getName(),
                        mobilePhone.getMemory(), mobilePhone.getScreenSize(), mobilePhone.getCamera(), mobilePhone.getBatteryPower(),
                        mobilePhone.getRam(), mobilePhone.getColor());
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Notebook listeleme metodu
    private void listNotebooks() {
        System.out.println("Notebook Listesi\n");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-9s | %-9s | %-10s | %-9s | %-7s |\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Product product : products) {
            if (product instanceof Notebook) {
                Notebook notebook = (Notebook) product;
                System.out.format("| %-2d | %-30s | %-9.2f | %-9s | %-10d | %-9.1f | %-7d |\n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand().getName(),
                        notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }


    // Ürün ekleme metodu
    private void addProduct() {
        System.out.println("Ürün eklemek için kategori seçin:");
        System.out.println("1 - Cep Telefonu");
        System.out.println("2 - Notebook");
        System.out.print("Seçiminiz: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // dummy nextLine() to consume newline character

        switch (choice) {
            case 1:
                addMobilePhone();
                break;
            case 2:
                addNotebook();
                break;
            default:
                System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
        }
    }

    // Cep telefonu ekleme metodu
    private void addMobilePhone() {
        System.out.println("Cep telefonu eklemek için aşağıdaki bilgileri girin:");
        System.out.print("Ürün Adı: ");
        String name = scanner.nextLine();
        System.out.print("Birim Fiyatı (TL): ");
        double price = scanner.nextDouble();
        System.out.print("İndirim Oranı (%): ");
        double discount = scanner.nextDouble();
        System.out.print("Stok Miktarı: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // dummy nextLine() to consume newline character

        System.out.println("Markalar:");
        int index = 1;
        for (Brand brand : brands) {
            System.out.println(brand.getId() + " - " + brand.getName());
            index++;
        }
        System.out.print("Marka ID'sini girin: ");
        int brandId = scanner.nextInt();
        scanner.nextLine(); // dummy nextLine() to consume newline character

        System.out.print("Telefonun hafıza bilgisi (GB): ");
        int memory = scanner.nextInt();
        System.out.print("Ekran Boyutu (inç): ");
        double screenSize = scanner.nextDouble();
        System.out.print("Pil Gücü: ");
        double batteryPower = scanner.nextDouble();
        System.out.print("RAM (GB): ");
        int ram = scanner.nextInt();
        scanner.nextLine(); // dummy nextLine() to consume newline character

        System.out.print("Renk: ");
        String color = scanner.nextLine();

        // Yeni cep telefonu oluştur
        MobilePhone mobilePhone = new MobilePhone(products.size() + 1, name, price, discount, stock, brands.get(brandId - 1),
                memory, screenSize, batteryPower, ram, color);
        products.add(mobilePhone);
        System.out.println("Cep telefonu başarıyla eklendi.");
    }

    // Notebook ekleme metodu
    private void addNotebook() {
        System.out.println("Notebook eklemek için aşağıdaki bilgileri girin:");
        System.out.print("Ürün Adı: ");
        String name = scanner.nextLine();
        System.out.print("Birim Fiyatı (TL): ");
        double price = scanner.nextDouble();
        System.out.print("İndirim Oranı (%): ");
        double discount = scanner.nextDouble();
        System.out.print("Stok Miktarı: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // dummy nextLine() to consume newline character

        System.out.println("Markalar:");
        for (Brand brand : brands) {
            System.out.println(brand.getId() + " - " + brand.getName());
        }
        System.out.print("Marka ID'sini girin: ");
        int brandId = scanner.nextInt();
        scanner.nextLine(); // dummy nextLine() to consume newline character

        System.out.print("RAM (GB): ");
        int ram = scanner.nextInt();
        System.out.print("Depolama (SSD GB): ");
        int storage = scanner.nextInt();
        System.out.print("Ekran Boyutu (inç): ");
        double screenSize = scanner.nextDouble();
        scanner.nextLine(); // dummy nextLine() to consume newline character

        // Yeni notebook oluştur
        Notebook notebook = new Notebook(products.size() + 1, name, price, discount, stock, brands.get(brandId - 1),
                ram, storage, screenSize);
        products.add(notebook);
        System.out.println("Notebook başarıyla eklendi.");
    }


    // Ürün silme metodu
    private void removeProduct() {
        System.out.print("Silmek istediğiniz ürünün ID'sini girin: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // dummy nextLine() to consume newline character

        boolean removed = false;
        for (Product product : products) {
            if (product.getId() == productId) {
                products.remove(product);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Ürün başarıyla silindi.");
        } else {
            System.out.println("Ürün bulunamadı!");
        }
    }

    // Ana menüyü gösterme metodu
    public void showMainMenu() {
        while (true) {
            System.out.println("\nPatika Store Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("4 - Ürün Ekle");
            System.out.println("5 - Ürün Sil");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // dummy nextLine() to consume newline character

            switch (choice) {
                case 1:
                    listNotebooks();
                    break;
                case 2:
                    listMobilePhones();
                    break;
                case 3:
                    listBrands();
                    break;
                case 4:
                    addProduct();
                    break;
                case 5:
                    removeProduct();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
            }
        }
    }

    // Ana metot
    public static void main(String[] args) {
        PatikaStoreManagement management = new PatikaStoreManagement();
        // Ana menüyü gösterelim
        management.showMainMenu();
    }
}

