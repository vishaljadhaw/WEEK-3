class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagementSystem {
    private Book head;
    private Book tail;
    private int totalBooks;

    public LibraryManagementSystem() {
        this.head = null;
        this.tail = null;
        this.totalBooks = 0;
    }

    public void addBook(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (position <= 0 || head == null) {
            // Add at the beginning
            if (head != null) {
                newBook.next = head;
                head.prev = newBook;
            }
            head = newBook;
            if (tail == null) tail = head; // Update tail if list was empty
        } else if (position >= totalBooks) {
            // Add at the end
            newBook.prev = tail;
            if (tail != null) tail.next = newBook;
            tail = newBook;
            if (head == null) head = tail; // Update head if list was empty
        } else {
            // Add at a specific position
            Book current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newBook.next = current.next;
            newBook.prev = current;
            if (current.next != null) current.next.prev = newBook;
            current.next = newBook;
        }
        totalBooks++;
    }

    public void removeBook(int bookID) {
        Book current = head;
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found.");
            return;
        }
        if (current.prev != null) current.prev.next = current.next;
        if (current.next != null) current.next.prev = current.prev;
        if (current == head) head = current.next;
        if (current == tail) tail = current.prev;
        totalBooks--;
        System.out.println("Book removed successfully.");
    }

    public void searchBook(String query) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.contains(query) || current.author.contains(query)) {
                System.out.println("Book Found: " + current.title + " by " + current.author);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No books found matching the query.");
    }

    public void updateAvailability(int bookID, boolean newStatus) {
        Book current = head;
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }
        if (current != null) {
            current.isAvailable = newStatus;
            System.out.println("Availability status updated.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void displayBooks(boolean reverse) {
        if (reverse) {
            Book current = tail;
            while (current != null) {
                System.out.println(current.title + " by " + current.author + " (" + (current.isAvailable ? "Available" : "Not Available") + ")");
                current = current.prev;
            }
        } else {
            Book current = head;
            while (current != null) {
                System.out.println(current.title + " by " + current.author + " (" + (current.isAvailable ? "Available" : "Not Available") + ")");
                current = current.next;
            }
        }
    }

    public void countBooks() {
        System.out.println("Total number of books: " + totalBooks);
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBook("Book A", "Author A", "Fiction", 1, true, 0);
        library.addBook("Book B", "Author B", "Non-Fiction", 2, true, 1);
        library.addBook("Book C", "Author C", "Science", 3, false, 1);

        library.displayBooks(false);
        library.displayBooks(true);

        library.searchBook("Author B");
        library.updateAvailability(2, false);
        library.displayBooks(false);

        library.removeBook(1);
        library.displayBooks(false);

        library.countBooks();
    }
}