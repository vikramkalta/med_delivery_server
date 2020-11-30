package com.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
  private ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    super();
    this.productRepository = productRepository;
  }

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();
    this.productRepository.findAll().forEach(products::add);
    return products;
  }
}
