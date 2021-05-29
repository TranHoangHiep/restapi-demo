package com.studying.restapidemo.service.impl;

import com.studying.restapidemo.model.common.Catalog;
import com.studying.restapidemo.repo.CatalogRepo;
import com.studying.restapidemo.service.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private CatalogRepo catalogRepo;
    @Override
    public Catalog add(Catalog catalog) {
        Catalog catalogadd = null;
        try {
            catalogadd = catalogRepo.save(catalog);
        }catch (Exception ex){
            log.error("can't add catalog");
        }
        return catalogadd;
    }

    @Override
    public Boolean delete(Long id) {
        try {
            catalogRepo.deleteById(id);
            return true;
        }catch (Exception ex){
            log.info("cant delete catalog");
            return false;
        }

    }

    @Override
    public Catalog update(Catalog catalog) {
        Catalog catalogUpdate = null;
        try{
            catalogUpdate = catalogRepo.save(catalog);
        }catch (Exception ex){
            log.info("cant update");
        }
        return catalogUpdate;
    }
}
