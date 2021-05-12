package com.studying.restapidemo.service;

import com.studying.restapidemo.model.common.User;

public interface UserService {
    User login(String username, String password);
}
