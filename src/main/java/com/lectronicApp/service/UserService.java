package com.lectronicApp.service;

import com.lectronicApp.model.dto.request.LoginRequest;
import com.lectronicApp.model.dto.request.RegisterRequest;
import com.lectronicApp.model.dto.response.ResponseData;

public interface UserService {
  // service login
  ResponseData<Object> loginService(LoginRequest request);

  // service register
  ResponseData<Object> registerService(RegisterRequest request);

  // service logout
  ResponseData<Object> logoutService();
}
