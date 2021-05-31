package com.studying.restapidemo.service.impl;

import com.studying.restapidemo.model.common.Order;
import com.studying.restapidemo.model.common.Product;
import com.studying.restapidemo.model.request.OrderRequest;
import com.studying.restapidemo.repo.OrderRepo;
import com.studying.restapidemo.repo.ProductRepo;
import com.studying.restapidemo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Order create(OrderRequest request) {
        Order orderCreated = null;
        try {
            List<Product> productList = productRepo.findByIdIsIn(request.getProducts());

            Order order = new Order();
            order.setMessage(request.getMessage());
            order.setProducts(productList);
            orderCreated = orderRepo.save(order);
        } catch (Exception ex) {
            log.error("create order fail");
        }

        return orderCreated;
    }
}
