package com.retail.dao;

import com.retail.dto.User;

public interface UserDao {

    void create(User user);

    User findItemByEmail(String emailId);

}
