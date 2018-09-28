package com.selbovi.shopserver.repository;

import com.selbovi.shopserver.model.Category;
import com.selbovi.shopserver.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
