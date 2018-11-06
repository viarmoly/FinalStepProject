package org.danit.luckyfit.controller;

import org.danit.luckyfit.entity.Product;
import org.danit.luckyfit.service.impl.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<Product> findAll() {
    return productService.findAll();
  }

  @DeleteMapping(value = "/{id}")
  public void deleteByUserId(@PathVariable int id) {
    productService.deleteByUserId(id);
  }

  @PostMapping()
  public void add(@RequestBody Product product) {
    Product currentProduct = new Product();
    currentProduct.setProductId(product.getProductId());
    currentProduct.setProductName(product.getProductName());

    productService.add(currentProduct);
  }

  @PutMapping(value = "/{id}")
  public Product modify(@RequestBody Product product) {
    return productService.modify(product);
  }
}