package com.retail.service.impl;

import com.retail.dao.ItemDao;
import com.retail.dto.Item;
import com.retail.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The implementation class for ItemService
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Transactional
    public boolean createItem(Item item) {
        try {
            itemDao.createItem(item);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Item findItemByName(String itemName) {
        return itemDao.findItemByName(itemName);
    }


}
