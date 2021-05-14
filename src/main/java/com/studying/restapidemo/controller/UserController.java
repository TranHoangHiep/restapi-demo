package com.studying.restapidemo.controller;

import com.studying.restapidemo.model.common.User;
import com.studying.restapidemo.model.response.Response;
import com.studying.restapidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("add")
    public Response<User> add(@RequestBody User user){
        System.out.println("username: " + user.getUsername());

        // add user to database

        //if add user success return response
        Response<User> response = new Response<>();
        response.setCode(0);
        response.setMessage("adding user success");
        response.setData(user);

        return response;
    }

    @GetMapping("delete/{id}")
    public Response delete(@PathVariable("id") int id){
        System.out.println("id: " + id);

        //delete user by id in service

        // if delete success return response
        Response response = new Response();
        response.setCode(0);
        response.setMessage("success");

        return response;
    }
}
