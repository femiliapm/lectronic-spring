package com.lectronicApp.service;

import com.lectronicApp.model.dto.request.SellerRequest;
import com.lectronicApp.model.dto.response.ResponseData;

public interface SellerService {
  ResponseData<Object> addSellerService(SellerRequest request);

  ResponseData<Object> getSellerService(Integer id);
}
