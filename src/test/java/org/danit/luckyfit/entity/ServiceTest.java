package org.danit.luckyfit.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServiceTest {

  @Test
  public void testService() {
    Product product = new Product();

    product.setProductId(1);
    product.setProductName("Product name");

    assertEquals(1, product.getProductId());
    assertEquals("Product name", product.getProductName());
    assertEquals("Product(productId=1, productName=Product name)", product.toString());
  }
}