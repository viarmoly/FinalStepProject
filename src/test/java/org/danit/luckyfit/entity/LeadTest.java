package org.danit.luckyfit.entity;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class LeadTest {
  @Test
  public void testGettersAndSetters() {
    Lead lead = new Lead();
    Product product = new Product();

    lead.setId(1234567);
    lead.setName("Test Name");
    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
    lead.setCreationTime(timestamp);
    lead.setComments("Test comments");
    lead.setProduct(product);

    assertEquals(1234567, lead.getId());
    assertEquals("Test Name", lead.getName());
    assertEquals(timestamp, lead.getCreationTime());
    assertEquals("Test comments", lead.getComments());
    assertEquals(product, lead.getProduct());
  }
}