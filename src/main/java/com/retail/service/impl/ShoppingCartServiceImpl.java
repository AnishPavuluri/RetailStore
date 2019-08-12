package com.retail.service.impl;

import com.retail.dao.ShoppingCartDao;
import com.retail.dto.Item;
import com.retail.dto.Order;
import com.retail.dto.ShoppingCart;
import com.retail.dto.User;
import com.retail.enums.UserType;
import com.retail.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Transactional
    public void addItem(ShoppingCart shoppingCart) {
        shoppingCartDao.createCart(shoppingCart);
    }

    @Transactional
    public void addItemToUser(User user, List<Item> items) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        List<Order> orderList = new ArrayList<>();
        for(Item item : items) {
            Order order = new Order();
            order.setItem(item);
            order.setQuantity(1l);
            order.setShoppingCart(shoppingCart);
            orderList.add(order);
        }
        shoppingCart.setOrderList(orderList);
        calculateTotalPrice(shoppingCart);
        shoppingCartDao.createCart(shoppingCart);
    }

    private void calculateTotalPrice(ShoppingCart shoppingCart) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        User user = shoppingCart.getUser();
        List<Order> orderList = shoppingCart.getOrderList();
        for(Order order : orderList) {
            if (!order.getItem().isGroceryItem()) {
                if (UserType.EMPLOYEE.equals(user.getUserType())) {
                    totalPrice = totalPrice.add(order.getItem().getPrice().multiply(BigDecimal.valueOf(order.getQuantity())).
                            multiply(BigDecimal.valueOf(0.7)));
                } else if (UserType.AFFILIATED.equals(user.getUserType())) {
                    totalPrice = totalPrice.add(order.getItem().getPrice().multiply(BigDecimal.valueOf(order.getQuantity()))
                            .multiply(BigDecimal.valueOf(0.9)));
                } else if (UserType.CUSTOMER.equals(user.getUserType()) && findYearsDiff(user.getCreatedDate()) > 2) {
                    totalPrice = totalPrice.add(order.getItem().getPrice().multiply(BigDecimal.valueOf(order.getQuantity()))
                            .multiply(BigDecimal.valueOf(0.95)));
                } else {
                    totalPrice = totalPrice.add(order.getItem().getPrice().multiply(BigDecimal.valueOf(order.getQuantity())));
                }
            } else {
                totalPrice = totalPrice.add(order.getItem().getPrice().multiply(BigDecimal.valueOf(order.getQuantity())));
            }
        }
        if(totalPrice.compareTo(BigDecimal.valueOf(100))> 0 ) {
            int quotient = totalPrice.divide(BigDecimal.valueOf(100)).intValue();
            totalPrice = totalPrice.subtract(BigDecimal.valueOf(quotient*5));
        }
        shoppingCart.setTotalPrice(totalPrice);
    }

    private int findYearsDiff(Date createdDate) {
        LocalDate createdDay = createdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        LocalDate today = LocalDate.now();
        Period period = Period.between(createdDay, today);
        int yearsInBetween = period.getYears();
        return yearsInBetween;
    }



}