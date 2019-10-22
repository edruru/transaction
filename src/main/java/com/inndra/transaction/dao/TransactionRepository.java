package com.inndra.transaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inndra.transaction.model.Transaction;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("FROM Transaction WHERE userId= ?1")
    List<Transaction> findAllByUserId(Long userId);

    @Query("FROM Transaction WHERE transactionId= ?1")
    Optional<Transaction> findByTransactionId(String transactionId);

}
