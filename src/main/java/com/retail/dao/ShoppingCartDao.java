package com.retail.dao;

import com.retail.dto.ShoppingCart;

/**
 * Data access class for ShoppingCart
 */
public interface ShoppingCartDao {
    void createCart(ShoppingCart shoppingCart);
}
