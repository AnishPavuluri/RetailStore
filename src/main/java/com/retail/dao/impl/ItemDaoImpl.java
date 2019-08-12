package com.retail.dao.impl;

import com.retail.dao.ItemDao;
import com.retail.dto.Item;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementation of ItemDao
 */
@Component
public class ItemDaoImpl implements ItemDao {

    private EntityManager entityManager;

    @Override
    public void createItem(Item item) {
        entityManager.persist(item);
    }

    @Override
    public Item findItemByName(String itemName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> criteria = builder.createQuery(Item.class);
        Root<Item> root = criteria.from(Item.class);
        criteria.where(builder.equal(root.get("itemName"), itemName));
        List<Item> list = entityManager.createQuery(criteria).getResultList();
        return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
    }


    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
