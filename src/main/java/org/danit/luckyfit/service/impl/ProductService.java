package org.danit.luckyfit.service.impl;

import org.danit.luckyfit.dao.ProductRepository;
import org.danit.luckyfit.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public void deleteByUserId(int id) {
    productRepository.deleteById(id);
  }

  public void add(Product product) {
    productRepository.save(product);
  }

  public Product modify(Product product) {
    return productRepository.save(product);
  }
}
