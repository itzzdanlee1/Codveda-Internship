package level3.project1;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAO();
        UserDAO userDAO = new UserDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        System.out.println("=== Adding a book ===");
        bookDAO.addBook(new Book("Effective Java", "Joshua Bloch"));

        System.out.println("\n=== Adding a user ===");
        userDAO.addUser(new User("Daniel Amankwah", "daniel@example.com"));

        System.out.println("\n=== All books ===");
        for (Book book : bookDAO.getAllBooks()) {
            System.out.println(book);
        }

        System.out.println("\n=== All users ===");
        for (User user : userDAO.getAllUsers()) {
            System.out.println(user);
        }

        // Update these with real IDs from the lists printed above
        int bookId = 1;
        int userId = 1;

        System.out.println("\n=== Borrowing a book ===");
        transactionDAO.borrowBook(bookId, userId);

        System.out.println("\n=== Book availability after borrowing ===");
        Book borrowedBook = bookDAO.findBookById(bookId);
        System.out.println(borrowedBook);

        System.out.println("\n=== All transactions ===");
        for (Transaction t : transactionDAO.getAllTransactions()) {
            System.out.println(t);
        }

        System.out.println("\n=== Returning the book ===");
        transactionDAO.returnBook(bookId, userId);

        System.out.println("\n=== Book availability after return ===");
        Book returnedBook = bookDAO.findBookById(bookId);
        System.out.println(returnedBook);

        System.out.println("\n=== All transactions after return ===");
        for (Transaction t : transactionDAO.getAllTransactions()) {
            System.out.println(t);
        }
    }
}