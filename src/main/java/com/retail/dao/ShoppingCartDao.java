package com.retail.dao;

import com.retail.dto.Item;
import com.retail.dto.ShoppingCart;

public interface ShoppingCartDao {
    void createCart(ShoppingCart shoppingCart);
}
