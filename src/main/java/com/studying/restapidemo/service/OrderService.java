package com.studying.restapidemo.service;

import com.studying.restapidemo.model.common.Order;
import com.studying.restapidemo.model.request.OrderRequest;

public interface OrderService {
    Order create(OrderRequest request);
}
