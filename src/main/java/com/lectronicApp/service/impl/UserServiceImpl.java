package com.lectronicApp.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lectronicApp.model.dto.request.LoginRequest;
import com.lectronicApp.model.dto.request.RegisterRequest;
import com.lectronicApp.model.dto.response.ResponseData;
import com.lectronicApp.model.entity.User;
import com.lectronicApp.repository.UserRepository;
import com.lectronicApp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  private ResponseData<Object> responseData;
  private Map<String, Object> data;

  @Autowired
  private UserRepository userRepository;

  @Override
  public ResponseData<Object> loginService(LoginRequest request) {
    // TODO Auto-generated method stub
    User user = userRepository.findByEmail(request.getEmail());

    if (user == null) {
      responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "User not found!", null);
      return responseData;
    } else {
      if (request.getPassword().equals(user.getPassword())) {
        responseData = new ResponseData<Object>(200, "Success!", user);
        return responseData;
      } else {
        responseData = new ResponseData<Object>(HttpStatus.UNAUTHORIZED.value(), "Password doesn't match!", null);
        return responseData;
      }
    }
  }

  @Override
  public ResponseData<Object> registerService(RegisterRequest request) {
    // TODO Auto-generated method stub
    User user = userRepository.findByEmail(request.getEmail());
    if (user != null) {
      responseData = new ResponseData<Object>(400, "Email is already registered!", null);
      return responseData;
    } else {
      user = new User();
      user.setEmail(request.getEmail());
      user.setFullName(request.getFullName());
      user.setPassword(request.getPassword());
      user = userRepository.save(user);

      data = new HashMap<>();
      data.put("email", user.getEmail());
      data.put("fullName", user.getFullName());

      responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "User is created!", data);
      return responseData;
    }
  }

  @Override
  public ResponseData<Object> logoutService() {
    // TODO Auto-generated method stub
    responseData = new ResponseData<Object>(200, "Successfully logout!", null);
    return responseData;
  }

}
