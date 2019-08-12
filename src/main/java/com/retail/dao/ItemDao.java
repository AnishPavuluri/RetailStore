package com.retail.dao;

import com.retail.dto.Item;

public interface ItemDao {

    void createItem(Item item);

    Item findItemByName(String itemName);
}
