package com.inndra.transaction.service;

import com.inndra.transaction.mapper.TransactionDto;
import com.inndra.transaction.mapper.TransactionSumDto;

import javax.ws.rs.core.Response;
import java.util.List;

public interface TransactionService {

    TransactionDto add(TransactionDto transactionDto);

    Response findByUserIdAndTransactionId(String transactionId, Long userId) ;

    List<TransactionDto> findAllByUserId(Long userId);

    TransactionSumDto sum(Long userId);

    TransactionDto random();

}
