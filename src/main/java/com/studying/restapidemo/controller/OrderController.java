package com.studying.restapidemo.controller;

import com.studying.restapidemo.model.common.Order;
import com.studying.restapidemo.model.request.OrderRequest;
import com.studying.restapidemo.model.response.Response;
import com.studying.restapidemo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    public Response<Order> create(@RequestBody OrderRequest request) {
        Response<Order> response = new Response<>();
        Order order = orderService.create(request);
        if (order != null) {
            response.setCode(0);
            response.setMessage("Create order success");
        } else {
            response.setCode(1);
            response.setMessage("Create order fail");
        }

        return response;
    }
}
