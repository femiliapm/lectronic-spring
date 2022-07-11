package com.lectronicApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lectronicApp.model.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
