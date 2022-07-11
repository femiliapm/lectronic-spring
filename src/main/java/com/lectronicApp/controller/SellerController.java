package com.lectronicApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lectronicApp.model.dto.request.SellerRequest;
import com.lectronicApp.model.dto.response.ResponseData;
import com.lectronicApp.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {
  @Autowired
  private SellerService sellerService;

  private ResponseData<Object> responseData;

  @PostMapping
  public ResponseEntity<?> addSellerAPI(@RequestBody @Valid SellerRequest request) {
    responseData = sellerService.addSellerService(request);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

  @GetMapping("/{sellerId}")
  public ResponseEntity<?> getSellerAPI(@PathVariable(name = "sellerId") Integer id) {
    responseData = sellerService.getSellerService(id);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

}
