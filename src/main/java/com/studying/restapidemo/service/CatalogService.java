package com.studying.restapidemo.service;

import com.studying.restapidemo.model.common.Catalog;
import org.springframework.stereotype.Service;

@Service
public interface CatalogService {
    Catalog add(Catalog catalog);

    Boolean delete(Long id);

    Catalog update(Catalog catalog);
}
