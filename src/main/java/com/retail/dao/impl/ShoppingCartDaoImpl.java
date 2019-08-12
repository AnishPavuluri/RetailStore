package com.retail.dao.impl;

import com.retail.dao.ShoppingCartDao;
import com.retail.dto.ShoppingCart;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementation of ShoppingCartDao
 */
@Component
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    private EntityManager entityManager;

    @Override
    public void createCart(ShoppingCart shoppingCart) {
        entityManager.persist(shoppingCart);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
