package com.studying.restapidemo.service;

import com.studying.restapidemo.model.common.Product;

public interface ProductService {

    Product add(String name, long catalogId);
}
