import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearch {

    // Linear search by title (case-insensitive)
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Sort books by title for binary search
    public static void sortBooksByTitle(Book[] books) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
    }

    // Binary search by title
    public static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        title = title.toLowerCase();

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.toLowerCase().compareTo(title);

            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return null;
    }
}
