package com.retail.service;

import com.retail.dto.Item;
import com.retail.dto.User;
import com.retail.enums.UserType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;
    @Test
    public void testCreateItem() {
        Item item = new Item();
        item.setItemName("Beer");
        item.setGroceryItem(false);
        item.setPrice(BigDecimal.valueOf(5));
        Assert.assertTrue(itemService.createItem(item));
    }

    @Test
    public void testCreateGroceryItem() {
        Item item = new Item();
        item.setItemName("Rice");
        item.setGroceryItem(true);
        item.setPrice(BigDecimal.TEN);
        Assert.assertTrue(itemService.createItem(item));
    }

    @Test
    public void testCreateNonGroceryItem() {
        Item item = new Item();
        item.setItemName("Magazine");
        item.setGroceryItem(false);
        item.setPrice(BigDecimal.valueOf(3));
        Assert.assertTrue(itemService.createItem(item));
    }
}
