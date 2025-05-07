package com.joaoneto.moneo_api.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.joaoneto.moneo_api.model.Transaction;
import com.joaoneto.moneo_api.model.User;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    Page<Transaction> findByUser(User user, Pageable pageable);
}
