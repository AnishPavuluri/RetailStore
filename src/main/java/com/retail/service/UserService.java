package com.retail.service;

import com.retail.dto.User;

public interface UserService {

    void createUser(User user);

    User findItemByEmail(String emailId);

}
