package com.lectronicApp.model.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OrderRequest {
  private Integer productId;
  private Integer userId;
  private Double price;
  private Double discount;

  @NotNull(message = "Quantity minimal 1, can not null!")
  private Integer quantity;
}
