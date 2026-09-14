package level3.project1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    // Borrow a book: create a transaction and mark the book unavailable
    public void borrowBook(int bookId, int userId) {
        String insertSql = "INSERT INTO Transactions (book_id, user_id, borrow_date) VALUES (?, ?, ?)";
        String updateSql = "UPDATE Books SET available = false WHERE book_id = ?";

        try (Connection conn = DBConnection.getConnection()) {

            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setInt(1, bookId);
                insertStmt.setInt(2, userId);
                insertStmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
                insertStmt.executeUpdate();
            }

            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();
            }

            System.out.println("Book " + bookId + " borrowed by user " + userId);

        } catch (SQLException e) {
            System.out.println("Failed to borrow book.");
            e.printStackTrace();
        }
    }

    // Return a book: set return_date on the open transaction, mark book available again
    public void returnBook(int bookId, int userId) {
        String updateTransactionSql =
                "UPDATE Transactions SET return_date = ? " +
                        "WHERE book_id = ? AND user_id = ? AND return_date IS NULL";
        String updateBookSql = "UPDATE Books SET available = true WHERE book_id = ?";

        try (Connection conn = DBConnection.getConnection()) {

            try (PreparedStatement stmt = conn.prepareStatement(updateTransactionSql)) {
                stmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
                stmt.setInt(2, bookId);
                stmt.setInt(3, userId);
                stmt.executeUpdate();
            }

            try (PreparedStatement stmt = conn.prepareStatement(updateBookSql)) {
                stmt.setInt(1, bookId);
                stmt.executeUpdate();
            }

            System.out.println("Book " + bookId + " returned by user " + userId);

        } catch (SQLException e) {
            System.out.println("Failed to return book.");
            e.printStackTrace();
        }
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM Transactions";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getInt("book_id"),
                        rs.getInt("user_id"),
                        rs.getDate("borrow_date"),
                        rs.getDate("return_date")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Failed to fetch transactions.");
            e.printStackTrace();
        }

        return transactions;
    }
}