package com.lectronicApp.model.dto.request;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class TransactionRequest {
  private Integer orderId;

  @NotEmpty(message = "Address is required!")
  private String address;
  private Double totalDiscount;
  private Double totalPrice;
}
