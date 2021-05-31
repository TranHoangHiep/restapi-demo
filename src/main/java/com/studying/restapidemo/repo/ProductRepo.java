package com.studying.restapidemo.repo;

import com.studying.restapidemo.model.common.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findByIdIsIn(List<Long> ids);
}
