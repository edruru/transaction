package com.inndra.transaction.service.impl;

import com.inndra.transaction.dao.TransactionRepository;
import com.inndra.transaction.mapper.TransactionDto;
import com.inndra.transaction.mapper.TransactionSumDto;
import com.inndra.transaction.model.Transaction;
import com.inndra.transaction.service.TransactionService;
import com.inndra.transaction.util.RandomGenerator;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    Mapper mapper;

    @Override
    public TransactionDto add(TransactionDto transactionDto) {

        Transaction transaction = mapper.map(transactionDto, Transaction.class);
        transaction.setTransactionId(RandomGenerator.generateRandomNumberByUUID());
        Transaction updatedTransaction = transactionRepository.save(transaction);
        return mapper.map(updatedTransaction, TransactionDto.class);
    }

    @Override
    public Response findByUserIdAndTransactionId(String transactionId, Long userId) {

        Optional<Transaction> transaction = transactionRepository.findByTransactionId(transactionId);

        if (transaction.isPresent()){
            if (transaction.get().getUserId().equals(userId)){
                return Response.ok(mapper.map(transaction.get(), TransactionDto.class)).build();
            }
        }
        return Response.noContent().entity("Transaction not found").build();
    }

    @Override
    public List<TransactionDto> findAllByUserId(Long userId) {

        List<Transaction> transactionList = transactionRepository.findAllByUserId(userId);
        return transactionList.stream().map(transaction -> mapper.map(transaction,TransactionDto.class)).collect(Collectors.toList());
    }

    @Override
    public TransactionSumDto sum(Long userId) {

        List<Transaction> transactionList = transactionRepository.findAllByUserId(userId);
        Double totalAmount = sumAmounts(transactionList);
        return new TransactionSumDto(userId,new BigDecimal(totalAmount).setScale(2, RoundingMode.HALF_UP));
    }

    @Override
    public TransactionDto random() {

        Long num = generateRandomNumber();
        return mapper.map(transactionRepository.findById(num).get(),TransactionDto.class);
    }

    //1-TranNum
    private Long generateRandomNumber(){

        Long tranNum = countTransactions();
        System.out.println(RandomGenerator.generateRandomNumberByUUID());
        return RandomGenerator.generateRandomNumber(1,(tranNum+1));
    }

    private Long countTransactions(){
        return transactionRepository.count();
    }

    private Double sumAmounts(List<Transaction> transactionList){
        return transactionList.stream()
                .mapToDouble(transaction -> transaction.getAmount()).sum();
    }
}
