package com.retail.service.impl;

import com.retail.dao.UserDao;
import com.retail.dto.User;
import com.retail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public boolean createUser(User user) {
        try {
            userDao.create(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public User findItemByEmail(String emailId) {
        return userDao.findItemByEmail(emailId);
    }


}
