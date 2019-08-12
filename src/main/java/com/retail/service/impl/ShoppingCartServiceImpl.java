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
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    @Transactional
    public boolean addItemToUser(User user, Map<Item, Integer> itemsMap) {
        try {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setUser(user);
            List<Order> orderList = new ArrayList<>();
            for (Map.Entry<Item, Integer> itemEntry : itemsMap.entrySet()) {
                Order order = new Order();
                order.setItem(itemEntry.getKey());
                order.setQuantity(Long.valueOf(itemEntry.getValue()));
                order.setShoppingCart(shoppingCart);
                orderList.add(order);
            }
            shoppingCart.setOrderList(orderList);
            calculateTotalPrice(shoppingCart);
            shoppingCartDao.createCart(shoppingCart);
        } catch (Exception e) {
            return false;
        }
        return true;
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
                } else if (UserType.CUSTOMER.equals(user.getUserType()) && findYearsDiff(user.getCreatedDate()) > 1) {
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
