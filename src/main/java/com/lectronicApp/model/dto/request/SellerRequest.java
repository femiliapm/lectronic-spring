package com.lectronicApp.model.dto.request;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class SellerRequest {
  @NotEmpty(message = "Seller name is required!")
  private String sellerName;
}
