package com.retail.service.impl;

import com.retail.dao.ItemDao;
import com.retail.dao.UserDao;
import com.retail.dto.Item;
import com.retail.dto.User;
import com.retail.service.ItemService;
import com.retail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Transactional
    public void createItem(Item item) {
        itemDao.createItem(item);
    }

    public Item findItemByName(String itemName) {
        return itemDao.findItemByName(itemName);
    }


}
