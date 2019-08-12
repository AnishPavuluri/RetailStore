package com.retail.dao;

import com.retail.dto.User;

/**
 * Data access class for User
 */
public interface UserDao {

    void create(User user);

    User findItemByEmail(String emailId);

}
