package com.lectronicApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lectronicApp.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
  @Query(value = "select * from products where stock > 0 limit ?1", nativeQuery = true)
  List<Product> findProductsLimit(Integer limit);

  @Query(value = "select * from products where stock > 0", nativeQuery = true)
  List<Product> findProductsAvailable();
}
