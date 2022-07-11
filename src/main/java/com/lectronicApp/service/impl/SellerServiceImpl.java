package com.lectronicApp.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lectronicApp.exception.custom.NotFoundException;
import com.lectronicApp.model.dto.request.SellerRequest;
import com.lectronicApp.model.dto.response.ResponseData;
import com.lectronicApp.model.entity.Seller;
import com.lectronicApp.repository.SellerRepository;
import com.lectronicApp.service.SellerService;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {
  @Autowired
  private SellerRepository sellerRepository;

  private ResponseData<Object> responseData;

  @Override
  public ResponseData<Object> addSellerService(SellerRequest request) {
    // TODO Auto-generated method stub
    Seller seller = new Seller();
    seller.setName(request.getSellerName());
    seller.setCreatedOn(LocalDate.now());
    seller = sellerRepository.save(seller);

    String message = "Seller " + seller.getName() + " added.";
    responseData = new ResponseData<Object>(201, message, seller.getName());
    return responseData;
  }

  @Override
  public ResponseData<Object> getSellerService(Integer id) {
    // TODO Auto-generated method stub
    Seller seller = sellerRepository.findById(id).orElseThrow(() -> new NotFoundException("Seller is not found!"));

    responseData = new ResponseData<Object>(200, "Success", seller);
    return responseData;
  }
}
