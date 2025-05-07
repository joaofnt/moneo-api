package com.joaoneto.moneo_api.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.joaoneto.moneo_api.model.Transactions;
import com.joaoneto.moneo_api.model.User;

public interface TransactionRepository extends JpaRepository<Transactions, Long>{

    Page<Transactions> findByUser(User user, Pageable pageable);
}
