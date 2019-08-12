package com.retail.service;

import com.retail.dto.Item;
import com.retail.dto.ShoppingCart;
import com.retail.dto.User;
import com.retail.enums.UserType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ShoppingCartServiceTest {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @Test
    public void testAddItemToUserCustomer() {
        User user = userService.findItemByEmail("rama@gmail.com");
        Item riceItem = itemService.findItemByName("Rice");
        Item beerItem = itemService.findItemByName("Beer");
        List<Item> list = new ArrayList<>();
        list.add(riceItem);
        list.add(beerItem);

        shoppingCartService.addItemToUser(user, list);
    }

    @Test
    public void testAddItemToUserEmployee() {
        User user = userService.findItemByEmail("anish@gmail.com");
        Item riceItem = itemService.findItemByName("Rice");
        Item beerItem = itemService.findItemByName("Beer");
        Item magazineItem = itemService.findItemByName("Magazine");
        List<Item> list = new ArrayList<>();
        list.add(riceItem);
        list.add(beerItem);
        list.add(magazineItem);

        shoppingCartService.addItemToUser(user, list);
    }

    @Test
    public void testAddItemToUserAffiliated() {
        User user = userService.findItemByEmail("Jhon@gmail.com");
        Item riceItem = itemService.findItemByName("Rice");
        Item beerItem = itemService.findItemByName("Beer");
        Item magazineItem = itemService.findItemByName("Magazine");
        List<Item> list = new ArrayList<>();
        list.add(riceItem);
        list.add(beerItem);
        list.add(magazineItem);

        shoppingCartService.addItemToUser(user, list);
    }

}
