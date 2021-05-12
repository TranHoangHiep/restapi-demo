package com.studying.restapidemo.controller;

import com.studying.restapidemo.model.common.User;
import com.studying.restapidemo.model.response.Response;
import com.studying.restapidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Response<User> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        Response<User> response = new Response();

        User user = userService.login(username, password);
        if(user != null){
            response.setCode(0);
            response.setMessage("Thanh cong");
            response.setData(user);
        } else {
            response.setCode(1);
            response.setMessage("Khong thanh cong");
        }

        return response;
    }
}
