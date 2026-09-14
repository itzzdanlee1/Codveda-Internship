package level3.project1;

import java.sql.Date;

public class Transaction {

    private int transactionId;
    private int bookId;
    private int userId;
    private Date borrowDate;
    private Date returnDate;

    public Transaction() {}

    public Transaction(int transactionId, int bookId, int userId, Date borrowDate, Date returnDate) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Date getBorrowDate() { return borrowDate; }
    public void setBorrowDate(Date borrowDate) { this.borrowDate = borrowDate; }

    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }

    @Override
    public String toString() {
        return "Transaction{id=" + transactionId + ", bookId=" + bookId + ", userId=" + userId +
                ", borrowDate=" + borrowDate + ", returnDate=" + returnDate + "}";
    }
}