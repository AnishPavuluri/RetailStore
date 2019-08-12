package com.retail.service;

import com.retail.dto.Item;
import com.retail.dto.ShoppingCart;
import com.retail.dto.User;

import java.util.List;

public interface ShoppingCartService {
    void addItem(ShoppingCart shoppingCart);
    void addItemToUser(User user, List<Item> items);
}
