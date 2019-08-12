package com.retail.service;

import com.retail.dto.Item;

public interface ItemService {

    void createItem(Item item);

    Item findItemByName(String itemName);

}
