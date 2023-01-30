package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Transactions")

public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "bookId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = CascadeType.DETACH)

    private DAOBook bookId;

    @JoinColumn(name = "userId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = CascadeType.DETACH)

    private DAOUser userId;

    @CreationTimestamp
    @Column(name = "dateOfTransaction", nullable = false)
    private Date dateOfTransaction;

    @Column
    private int totalBooks;
    public Transactions() {
    }

    public Transactions(long id, DAOBook bookId, DAOUser userId, Date dateOfTransaction, int totalBooks) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.dateOfTransaction = dateOfTransaction;
        this.totalBooks = totalBooks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DAOBook getBookId() {
        return bookId;
    }

    public void setBookId(DAOBook bookId) {
        this.bookId = bookId;
    }

    public DAOUser getUserId() {
        return userId;
    }

    public void setUserId(DAOUser userId) {
        this.userId = userId;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }
}

