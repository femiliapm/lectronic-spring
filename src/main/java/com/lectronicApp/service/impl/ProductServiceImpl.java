package com.lectronicApp.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lectronicApp.exception.custom.NotFoundException;
import com.lectronicApp.model.dto.request.ProductRequest;
import com.lectronicApp.model.dto.response.ResponseData;
import com.lectronicApp.model.entity.Product;
import com.lectronicApp.model.entity.Seller;
import com.lectronicApp.repository.ProductRepository;
import com.lectronicApp.repository.SellerRepository;
import com.lectronicApp.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private SellerRepository sellerRepository;

  private ResponseData<Object> responseData;

  @Override
  public ResponseData<Object> addProductService(ProductRequest request) {
    // TODO Auto-generated method stub
    Seller seller = sellerRepository.findById(request.getSellerId())
        .orElseThrow(() -> new NotFoundException("Seller is not found!"));

    Product product = new Product();
    product.setCategory(request.getCategory());
    product.setCreatedOn(LocalDate.now());
    product.setDescription(request.getDescription());
    product.setName(request.getProductName());
    product.setPrice(request.getPrice());
    product.setSeller(seller);
    product.setStock(request.getStock());
    product = productRepository.save(product);

    String message = product.getName() + " is added.";
    responseData = new ResponseData<Object>(201, message, null);
    return responseData;
  }

  @Override
  public ResponseData<Object> getProductsService(Integer limit) {
    // TODO Auto-generated method stub
    List<Product> products;
    if (limit != null) {
      products = productRepository.findProductsLimit(limit);
    } else {
      products = productRepository.findProductsAvailable();
    }
    responseData = new ResponseData<Object>(200, "Success", products);
    return responseData;
  }

  @Override
  public ResponseData<Object> getProductByIdService(Integer id) {
    // TODO Auto-generated method stub
    Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product is not found!"));
    responseData = new ResponseData<Object>(200, "Success", product);
    return responseData;
  }
}
