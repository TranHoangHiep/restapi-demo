package com.studying.restapidemo.service.impl;

import com.studying.restapidemo.model.common.User;
import com.studying.restapidemo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public User login(String username, String password){
        User user = null;
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123456")){
            user = new User("admin", "admin@gmail.com");
        }

        return user;
    }
}
