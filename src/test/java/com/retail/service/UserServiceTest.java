package com.retail.service;

import com.retail.dto.User;
import com.retail.enums.UserType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("Rama");
        user.setEmailId("rama@gmail.com");
        user.setPassword("test123");
        user.setUserType(UserType.CUSTOMER);
        user.setCreatedDate(Calendar.getInstance().getTime());
        userService.createUser(user);
    }

    @Test
    public void testCreateEmployeeUser() {
        User user = new User();
        user.setName("Anish");
        user.setEmailId("anish@gmail.com");
        user.setPassword("test123");
        user.setUserType(UserType.EMPLOYEE);
        user.setCreatedDate(Calendar.getInstance().getTime());
        userService.createUser(user);
    }

    @Test
    public void testCreateAffiliatedUser() {
        User user = new User();
        user.setName("Jhon");
        user.setEmailId("Jhon@gmail.com");
        user.setPassword("test123");
        user.setUserType(UserType.AFFILIATED);
        user.setCreatedDate(Calendar.getInstance().getTime());
        userService.createUser(user);
    }

}
