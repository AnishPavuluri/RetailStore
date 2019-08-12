package com.retail.dao;

import com.retail.dto.Item;

/**
 * Data access class for Item
 */
public interface ItemDao {

    void createItem(Item item);

    Item findItemByName(String itemName);
}
