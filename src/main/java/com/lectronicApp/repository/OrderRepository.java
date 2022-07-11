package com.lectronicApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lectronicApp.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
  Optional<Order> findByProductIdAndUserIdAndStatus(Integer productId, Integer userId, Boolean status);

  List<Order> findByStatus(Boolean status);
}
