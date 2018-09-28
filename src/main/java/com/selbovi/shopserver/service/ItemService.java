package com.selbovi.shopserver.service;

import com.selbovi.shopserver.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();
    Item save(Item item);
}
