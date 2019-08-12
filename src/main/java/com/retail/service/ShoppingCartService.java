package com.retail.service;

import com.retail.dto.Item;
import com.retail.dto.User;
import java.util.Map;
/**
 * The service class for Shopping cart
 */
public interface ShoppingCartService {

    boolean addItemToUser(User user, Map<Item, Integer> itemsMap);
}
