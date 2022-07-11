package com.lectronicApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lectronicApp.model.dto.request.OrderRequest;
import com.lectronicApp.model.dto.response.ResponseData;
import com.lectronicApp.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
  @Autowired
  private OrderService orderService;

  private ResponseData<Object> responseData;

  @PostMapping
  public ResponseEntity<?> addToCartAPI(@RequestBody @Valid OrderRequest request) {
    responseData = orderService.addToCartService(request);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

  @GetMapping
  public ResponseEntity<?> getOrdersAPI(@RequestParam(value = "status", defaultValue = "") Boolean status) {
    responseData = orderService.getOrdersService(status);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

  @DeleteMapping("/{orderId}")
  public ResponseEntity<?> deleteOrderAPI(@PathVariable(name = "orderId") Integer id) {
    responseData = orderService.deleteOrderService(id);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }
}
