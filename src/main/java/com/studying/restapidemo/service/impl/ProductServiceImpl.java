package com.studying.restapidemo.service.impl;

import com.studying.restapidemo.model.common.Catalog;
import com.studying.restapidemo.model.common.Product;
import com.studying.restapidemo.repo.CatalogRepo;
import com.studying.restapidemo.repo.ProductRepo;
import com.studying.restapidemo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CatalogRepo catalogRepo;

    @Override
    public Product add(String name, long catalogId) {

        Product productInserted = null;
        try {
            Catalog catalog = catalogRepo.getOne(catalogId);
            log.info("catalog: " + catalog.toString());

            Product product = new Product();
            product.setName(name);
            product.setCatalog(catalog);

            productInserted = productRepo.save(product);
        } catch (Exception ex) {
            log.error("Add product fail");
        }

        return productInserted;
    }
}
