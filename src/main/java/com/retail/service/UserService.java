package com.retail.service;

import com.retail.dto.User;
/**
 * The service class for User
 */
public interface UserService {

    boolean createUser(User user);

    User findItemByEmail(String emailId);

}
