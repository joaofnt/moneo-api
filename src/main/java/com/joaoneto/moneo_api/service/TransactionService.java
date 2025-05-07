package com.joaoneto.moneo_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.joaoneto.moneo_api.model.Transactions;
import com.joaoneto.moneo_api.model.User;
import com.joaoneto.moneo_api.repository.TransactionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;


    public Transactions  create( Transactions tx){
         return transactionRepository.save(tx);
    }

    public Page<Transactions> listByTransactionByUser(User user, Pageable pageable){
        return transactionRepository.findByUser(user, pageable);
    }

    public  Optional<Transactions> findById(Long id){
        return transactionRepository.findById(id);
    }

    public Transactions Update(Transactions tx, Long id){
        Transactions exist = findById(id).orElseThrow();
        exist.setAmount(tx.getAmount());
        exist.setCategory(tx.getCategory());
        exist.setActualDate(tx.getActualDate());
        exist.setDescription(tx.getDescription());
        exist.setTransactionType(tx.getTransactionType());
        exist.setUser(tx.getUser());
        return transactionRepository.save(exist);
    }

    public void deleteById(Long id) {
        Transactions tx = transactionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Transaction not found: " + id));
        transactionRepository.delete(tx);
    }

}
