package com.lectronicApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lectronicApp.model.dto.request.ProductRequest;
import com.lectronicApp.model.dto.response.ResponseData;
import com.lectronicApp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  private ResponseData<Object> responseData;

  @PostMapping
  public ResponseEntity<?> addProductAPI(@RequestBody ProductRequest request) {
    responseData = productService.addProductService(request);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

  @GetMapping
  public ResponseEntity<?> getProductsAPI(@RequestParam(value = "limit", defaultValue = "") Integer limit) {
    responseData = productService.getProductsService(limit);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<?> getProductByIdAPI(@PathVariable(name = "productId") Integer id) {
    responseData = productService.getProductByIdService(id);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }
}
