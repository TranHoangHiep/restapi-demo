package com.studying.restapidemo.controller;

import com.studying.restapidemo.model.common.Product;
import com.studying.restapidemo.model.response.Response;
import com.studying.restapidemo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Response<Product> add(
            @RequestParam("name") String name,
            @RequestParam("catalog_id") long catalogId
    ) {
        log.info("=======> Add product");
        Response<Product> response = new Response<>();
        Product productInserted = productService.add(name, catalogId);
        if (productInserted != null) {
            response.setCode(0);
            response.setMessage("Add product success");
            response.setData(productInserted);
        } else {
            response.setCode(1);
            response.setMessage("Add product fail");
        }
        return response;
    }
}
