package com.lectronicApp.model.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
  private String productName;
  private String description;
  private Double price;
  private Integer stock;
  private String category;
  private Integer sellerId;
}
