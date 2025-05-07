package com.joaoneto.moneo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoneto.moneo_api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
