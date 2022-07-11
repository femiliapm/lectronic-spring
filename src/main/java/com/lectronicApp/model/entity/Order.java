package com.lectronicApp.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "productId")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
  private Double price;
  private Double discount;
  private Integer quantity;
  private Boolean status = false;
  private LocalDate createdOn;
  private LocalDate updatedAt;
}
