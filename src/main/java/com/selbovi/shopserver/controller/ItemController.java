package com.selbovi.shopserver.controller;

import com.selbovi.shopserver.model.Category;
import com.selbovi.shopserver.model.Item;
import com.selbovi.shopserver.service.CategoryService;
import com.selbovi.shopserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/items"})
public class ItemController {

    @Autowired
    ItemService itemService;

    @PutMapping
    public Item create(@RequestBody Item item) {
        return itemService.save(item);
    }

    @GetMapping
    public List<Item> findAll() {
        return itemService.findAll();
    }
}
