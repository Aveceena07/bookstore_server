package com.javainuse.model;

import java.io.Serializable;

public class TransactionsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long bookId;

    private int totalBooks;

    public TransactionsDTO() {

    }

    public TransactionsDTO(long bookId, int totalBooks) {
        this.bookId = bookId;
        this.totalBooks = totalBooks;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }
}
