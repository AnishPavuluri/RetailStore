package com.retail.service;

import com.retail.dto.Item;
import com.retail.dto.ShoppingCart;
import com.retail.dto.User;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {

    boolean addItemToUser(User user, Map<Item, Integer> itemsMap);
}
