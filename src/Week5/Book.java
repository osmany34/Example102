package Week5;

import java.util.*;

class Book implements Comparable<Book> {
    private String name; // Kitap ismi
    private int pageCount; // Sayfa sayısı
    private String authorName; // Yazar ismi
    private String publicationDate; // Yayın tarihi

    public Book(String name, int pageCount, String authorName, String publicationDate) {
        this.name = name;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public int compareTo(Book other) {
        return this.name.compareTo(other.name); // Kitap ismine göre karşılaştırma
    }

    @Override
    public String toString() {
        return "Book {" +
                "name='" + name + '\'' +
                ", pageCount=" + pageCount +
                ", authorName='" + authorName + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Set<Book> bookSetByName = new TreeSet<>();

        bookSetByName.add(new Book("The Catcher in the Rye", 277, "J.D. Salinger", "1951-07-16"));
        bookSetByName.add(new Book("To Kill a Mockingbird", 324, "Harper Lee", "1960-07-11"));
        bookSetByName.add(new Book("1984", 328, "George Orwell", "1949-06-08"));
        bookSetByName.add(new Book("Fahrenheıt 451", 279, "Ray Bradbury", "1813-01-28"));
        bookSetByName.add(new Book("The Great Gatsby", 180, "F. Scott Fitzgerald", "1925-04-10"));

        System.out.println("Kitaplar isme göre sıralandı:");
        System.out.println();
        for (Book book : bookSetByName) {
            System.out.println(book);
        }

        Set<Book> bookSetByPageCount = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return Integer.compare(b1.getPageCount(), b2.getPageCount()); // Sayfa sayısına göre karşılaştırma
            }
        });

        bookSetByPageCount.addAll(bookSetByName);

        System.out.println("\nKitaplar sayfa sayısına göre sıralandı:");
        System.out.println();
        for (Book book : bookSetByPageCount) {
            System.out.println(book);
        }
    }
}
