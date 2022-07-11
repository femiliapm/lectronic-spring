package com.lectronicApp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lectronicApp.exception.custom.NotFoundException;
import com.lectronicApp.model.dto.request.OrderRequest;
import com.lectronicApp.model.dto.response.ResponseData;
import com.lectronicApp.model.entity.Order;
import com.lectronicApp.model.entity.Product;
import com.lectronicApp.model.entity.User;
import com.lectronicApp.repository.OrderRepository;
import com.lectronicApp.repository.ProductRepository;
import com.lectronicApp.repository.UserRepository;
import com.lectronicApp.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private UserRepository userRepository;

  private ResponseData<Object> responseData;

  @Override
  public ResponseData<Object> addToCartService(OrderRequest request) {
    // TODO Auto-generated method stub
    Optional<Order> orderFind = orderRepository.findByProductIdAndUserIdAndStatus(request.getProductId(),
        request.getUserId(), false);

    Product product = productRepository.findById(request.getProductId())
        .orElseThrow(() -> new NotFoundException("Product is not found!"));

    User user = userRepository.findById(request.getUserId())
        .orElseThrow(() -> new NotFoundException("User is not found!"));

    Order order;
    if (orderFind.isEmpty()) {
      order = new Order();
      order.setCreatedOn(LocalDate.now());
      order.setDiscount(request.getDiscount());
      order.setPrice(request.getPrice());
      order.setProduct(product);
      order.setQuantity(request.getQuantity());
      order.setUser(user);
    } else {
      order = orderFind.get();
      order.setQuantity(request.getQuantity());
    }

    order = orderRepository.save(order);

    responseData = new ResponseData<Object>(201, "Success ordered!", order);
    return responseData;
  }

  @Override
  public ResponseData<Object> getOrdersService(Boolean status) {
    // TODO Auto-generated method stub
    List<Order> orders;
    if (status != null) {
      orders = orderRepository.findByStatus(status);
    } else {
      orders = orderRepository.findAll();
    }

    responseData = new ResponseData<Object>(200, "Success", orders);
    return responseData;
  }

  @Override
  public ResponseData<Object> deleteOrderService(Integer orderId) {
    // TODO Auto-generated method stub
    Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("Order not found"));
    orderRepository.delete(order);
    responseData = new ResponseData<Object>(200, "Success", order);
    return responseData;
  }

}
