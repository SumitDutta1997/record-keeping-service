package com.jar.kiranatransaction.controller;

import com.jar.kiranatransaction.dto.TransactionDto;
import com.jar.kiranatransaction.service.TransactionService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
@Log4j2
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/v1/record")
    ResponseEntity<String> recordTransaction(@RequestBody @Valid TransactionDto TransactionRequestDto) {
        log.info("Request received to record a transaction with TransactionRequestDto: {}", TransactionRequestDto);
        return ResponseEntity.ok(transactionService.recordTransaction(TransactionRequestDto));
    }


}
