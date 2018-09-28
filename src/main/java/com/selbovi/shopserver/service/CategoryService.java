package com.selbovi.shopserver.service;

import com.selbovi.shopserver.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category save(Category item);
}
