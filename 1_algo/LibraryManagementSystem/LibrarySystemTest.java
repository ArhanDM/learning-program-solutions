public class LibrarySystemTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Alchemist", "Paulo Coelho"),
            new Book(2, "Sapiens", "Yuval Noah Harari"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Atomic Habits", "James Clear")
        };

        // Linear Search
        System.out.println("Linear Search for 'Sapiens':");
        Book b1 = LibrarySearch.linearSearch(books, "Sapiens");
        System.out.println(b1 != null ? b1 : "Book not found");

        // Sort before Binary Search
        LibrarySearch.sortBooksByTitle(books);

        // Binary Search
        System.out.println("\nBinary Search for 'Atomic Habits':");
        Book b2 = LibrarySearch.binarySearch(books, "Atomic Habits");
        System.out.println(b2 != null ? b2 : "Book not found");
    }
}
