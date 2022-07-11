package com.lectronicApp.service;

import com.lectronicApp.model.dto.request.ProductRequest;
import com.lectronicApp.model.dto.response.ResponseData;

public interface ProductService {
  ResponseData<Object> addProductService(ProductRequest request);

  ResponseData<Object> getProductsService(Integer limit);

  ResponseData<Object> getProductByIdService(Integer id);
}
