package com.retail.service;

import com.retail.dto.Item;

/**
 * The service class for Item
 */
public interface ItemService {

    boolean createItem(Item item);

    Item findItemByName(String itemName);

}
