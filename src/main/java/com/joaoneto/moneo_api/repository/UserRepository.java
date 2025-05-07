package com.joaoneto.moneo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoneto.moneo_api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    
} 
