package com.lectronicApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lectronicApp.model.dto.request.LoginRequest;
import com.lectronicApp.model.dto.request.RegisterRequest;
import com.lectronicApp.model.dto.response.ResponseData;
import com.lectronicApp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  private ResponseData<Object> responseData;

  @PostMapping("/register")
  public ResponseEntity<?> registerAPI(@RequestBody @Valid RegisterRequest request) {
    responseData = userService.registerService(request);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

  @PostMapping("/login")
  public ResponseEntity<?> loginAPI(@RequestBody @Valid LoginRequest request) {
    responseData = userService.loginService(request);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

  @GetMapping("/logout")
  public ResponseEntity<?> logoutAPI() {
    responseData = userService.logoutService();
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

}
