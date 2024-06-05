package Week6.Pratik_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NotepadApp {
    public static void main(String[] args) {
        // Kullanıcıdan metin girişi al
        Scanner scanner = new Scanner(System.in);
        System.out.print("Metin girin: ");
        String text = scanner.nextLine();
        scanner.close();

        final String FILE_NAME = "notes.txt";
        // Metni dosyaya kaydet
        writeFile(FILE_NAME, text);

        // En son kaydedilen metni ekrana yazdır
        String lastSaved = getSavedText(FILE_NAME);
        System.out.println("En son kaydedilen metin:");
        System.out.println(lastSaved);
    }

    // Metni dosyaya yazan metod
    private static void writeFile(String fileName, String text) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            writer.println(text);
        } catch (IOException e) {
            System.err.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }

    // En son kaydedilen metni dosyadan okuyan metod
    private static String getSavedText(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
        return stringBuilder.toString();
    }
}
