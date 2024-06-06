package Week6.Enum;
public class Deneme {
    public static void main(String[] args) {

        Day gunler = Day.PAZAR;
        System.out.println(gunler.ordinal()); // Dizideki indeksini verir.
        System.out.println(gunler.name()); // Sabit'in adını döndürür.

        Day[] values = Day.values(); // Tüm sabitlerini döndürür.

        Day gun = Day.valueOf("PAZARTESI"); // String'i enum'a dönüştürür.
    }
}

