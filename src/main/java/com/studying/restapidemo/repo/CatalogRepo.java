package com.studying.restapidemo.repo;

import com.studying.restapidemo.model.common.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepo extends JpaRepository<Catalog, Long> {
}