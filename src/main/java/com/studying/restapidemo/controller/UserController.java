package com.studying.restapidemo.controller;

import com.studying.restapidemo.model.common.Account;
import com.studying.restapidemo.model.response.Response;
import com.studying.restapidemo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "user")
@Slf4j
public class UserController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public Response<Account> add(
            @RequestParam("name") String name,
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("phone") String phone,
            @RequestParam("image") String image,
            @RequestParam("type") String type
    ){
        log.info("===========> add account");
        Account account = convertToAccount(name, username, email, password, phone, image, type);

        Account accountInserted = accountService.add(account);

        Response<Account> response = new Response<>();

        if(accountInserted != null){
            response.setCode(0);
            response.setMessage("save account success");
            response.setData(accountInserted);
        } else {
            response.setCode(1);
            response.setMessage("save account fail");
        }

        return response;
    }

    private Account convertToAccount(
            String name, String username, String email, String password, String phone, String image, String type
    ){
        Account account = new Account();
        account.setName(name);
        account.setUsername(username);
        account.setEmail(email);
        account.setPassword(password);
        account.setPhone(phone);
        account.setImage(image);
        account.setType(type);

        return account;
    }
}
