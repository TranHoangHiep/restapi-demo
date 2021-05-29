package com.studying.restapidemo.controller;

import com.studying.restapidemo.model.common.Catalog;
import com.studying.restapidemo.model.response.Response;
import com.studying.restapidemo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("catalog")
public class CatalogController{
    @Autowired
    CatalogService catalogService;
    @PostMapping("add")
    public Response<Catalog> add(
            @RequestParam("name") String name
    ){
        Catalog catalogadd = convertToCatalog(name);
        Response response = new Response();
        Catalog catalog = catalogService.add(catalogadd);
        if(catalog != null){
            response.setCode(0);
            response.setMessage("add catalog success!");
            response.setData(catalog);
        }else{
            response.setCode(1);
            response.setMessage("catalog fail!");
        }
        return response;
    }


    private Catalog convertToCatalog(String name){
        Catalog catalog = new Catalog();

        catalog.setName(name);

        return catalog;
    }

    @DeleteMapping("delete/{id}")
    public Response delete(@PathVariable("id") Long id){
        Response response = new Response();
        Boolean check = catalogService.delete(id);
        if(check){
            response.setCode(0);
            response.setMessage("delete catalog success");
        }else{
            response.setCode(1);
            response.setMessage("delete catalog fail");
        }
        return response;
    }

    @PutMapping("update")
    public Response update(@RequestBody Catalog catalog){
        Response response = new Response();
        Catalog ctlog = catalogService.update(catalog);
        if(ctlog != null){
            response.setCode(0);
            response.setMessage("update catalog success");
            response.setData(ctlog);
        }else{
            response.setCode(1);
            response.setMessage("cant update catalog");
        }
        return response;
    }
}