package com.inndra.transaction.controller.impl;

import com.inndra.transaction.controller.TransactionController;
import com.inndra.transaction.mapper.TransactionDto;
import com.inndra.transaction.mapper.TransactionSumDto;
import com.inndra.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
public class TransactionControllerImpl implements TransactionController {

    @Autowired
    TransactionService transactionService;

    @Override
    public TransactionDto add(TransactionDto transactionDto) {
        return transactionService.add(transactionDto);
    }

    @Override
    public Response findByUserIdAndTransactionId(String transactionId, Long userId) {
        return transactionService.findByUserIdAndTransactionId(transactionId, userId);
    }

    @Override
    public List<TransactionDto> findAllByUserId(Long userId) {
        return transactionService.findAllByUserId(userId);
    }

    @Override
    public TransactionSumDto sum(Long userId) {
        return transactionService.sum(userId);
    }

    @Override
    public TransactionDto random() {
        return transactionService.random();
    }
}
