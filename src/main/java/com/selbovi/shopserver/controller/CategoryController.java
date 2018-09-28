package com.selbovi.shopserver.controller;

import com.selbovi.shopserver.model.Category;
import com.selbovi.shopserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/categories"})
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PutMapping
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }
}
