package com.javainuse.controller;


import com.javainuse.dao.BookDao;
import com.javainuse.dao.TransactionDao;
import com.javainuse.dao.UserDao;
import com.javainuse.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionsController {
    public static final Logger logger = LoggerFactory.getLogger(TransactionsController.class);

    @Autowired
    private BookDao bookDao;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/{userId}/transactions", method = RequestMethod.POST)
    public ResponseEntity<?> addTransaction(@PathVariable("userId") long userId, @RequestBody List<TransactionsDTO> transactionsDTO) {

        DAOUser user = userDao.findById(userId);

        List<DAOBook> stock = new ArrayList<>();

        for (TransactionsDTO loopBook : transactionsDTO) {
            DAOBook dataBook = bookDao.findById(loopBook.getBookId());
            dataBook.setStocks(dataBook.getStocks() - loopBook.getTotalBooks());
            stock.add(dataBook);
            bookDao.saveAll(stock);
            Transactions saveData = new Transactions();
            saveData.setBookId(dataBook);
            saveData.setUserId(user);
            saveData.setTotalBooks(loopBook.getTotalBooks());

            transactionDao.save(saveData);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/transactions/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Transactions>> ListAllTransactions() throws SQLException, ClassCastException {
        List<Transactions>transactions = transactionDao.findAll();

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

}
