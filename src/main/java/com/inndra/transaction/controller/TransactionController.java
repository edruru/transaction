package com.inndra.transaction.controller;

import java.util.List;

import com.inndra.transaction.mapper.TransactionDto;
import com.inndra.transaction.mapper.TransactionSumDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.core.Response;

@RequestMapping("transaction")
public interface TransactionController {

	@PostMapping("/add")
	TransactionDto add(@RequestBody TransactionDto transactionDto);

	@GetMapping("/find/{transactionId}/{userId}")
	Response findByUserIdAndTransactionId(@PathVariable(name = "transactionId") String transactionId,
										  @PathVariable(name = "userId") Long userId);

	@GetMapping("/list/{userId}")
	List<TransactionDto> findAllByUserId(@PathVariable(name = "userId") Long userId);

	@GetMapping("/sum/{userId}")
    TransactionSumDto sum(@PathVariable(name = "userId") Long userId);

	@GetMapping("/random")
    TransactionDto random();

}
