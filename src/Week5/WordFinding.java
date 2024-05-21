package Week5;

import java.util.*;

public class WordFinding {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Kullanıcıdan metni al
        System.out.print("Metni girin : ");
        String metin = input.nextLine();

        // Metni kelimelere ayır
        String[] kelimeler = metin.split("\\s+");

        // Kelimeleri saklamak için HashMap oluştur
        Map<String, Integer> kelimeSayilari = new HashMap<>();

        // Her kelimeyi HashMap'e ekle
        for (String kelime : kelimeler) {
            kelimeSayilari.put(kelime, kelimeSayilari.getOrDefault(kelime, 0) + 1);
        }

        // En çok geçen kelimeyi bul
        String enCokGecenKelime = "";
        int enCokGecenKelimeSayisi = 0;
        for (Map.Entry<String, Integer> entry : kelimeSayilari.entrySet()) {
            if (entry.getValue() > enCokGecenKelimeSayisi) {
                enCokGecenKelime = entry.getKey();
                enCokGecenKelimeSayisi = entry.getValue();
            }
        }

        // Sonucu ekrana yazdır
        System.out.println("En çok geçen kelime: " + enCokGecenKelime + ", Sayısı: " + enCokGecenKelimeSayisi);
    }
}

