package com.lectronicApp.service;

import com.lectronicApp.model.dto.request.OrderRequest;
import com.lectronicApp.model.dto.response.ResponseData;

public interface OrderService {
  ResponseData<Object> addToCartService(OrderRequest request);

  ResponseData<Object> getOrdersService(Boolean status);

  ResponseData<Object> deleteOrderService(Integer orderId);
}
