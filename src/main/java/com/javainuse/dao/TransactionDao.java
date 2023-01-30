package com.javainuse.dao;

import com.javainuse.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository<Transactions, Long> {

}
