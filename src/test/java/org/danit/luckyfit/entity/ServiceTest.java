package org.danit.luckyfit.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServiceTest {

  @Test
  public void testService() {
    Product product = new Product();

    product.setId(1);
    product.setName("Product name");

    assertEquals(1, product.getId());
    assertEquals("Product name", product.getName());
    assertEquals("Product(id=1, name=Product name)", product.toString());
  }
}