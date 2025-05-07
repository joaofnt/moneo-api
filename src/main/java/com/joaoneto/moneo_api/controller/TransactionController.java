package com.joaoneto.moneo_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoneto.moneo_api.model.Transactions;
import com.joaoneto.moneo_api.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transactions> save(@RequestBody Transactions transaction){
       Transactions saved = transactionService.create(transaction);
        return  ResponseEntity.status(HttpStatus.CREATED)
        .body(saved);
    } 
}
