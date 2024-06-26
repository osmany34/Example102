package Week6.Pratik_1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileNumbers {
    public static void main(String[] args) {
        String fileName = "C:\\javademos\\numbers.txt"; // Dosya adını burada belirtin
        int sum = 0;

        // Dosyadan sayıları okuma işlemi
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line);
                sum += number;
            }
        } catch (IOException e) {
            // Dosya okuma hatası durumunda hata mesajını yazdır
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }

        // Toplamı ekrana yazdır
        System.out.println("Toplam: " + sum);
    }
}
