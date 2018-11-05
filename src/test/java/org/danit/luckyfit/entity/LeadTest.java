package org.danit.luckyfit.entity;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class LeadTest {
  @Test
  public void testGettersAndSetters() {
    Lead lead = new Lead();

    Contact contact = new Contact();
    User user = new User();
    Product product = new Product();
    Status status = new Status();

    lead.setId(1234567);
    lead.setName("Test Name");
    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
    lead.setCreationTime(timestamp);
    lead.setComments("Test comments");
    lead.setContact(contact);
    lead.setUser(user);
    lead.setProduct(product);
    lead.setStatus(status);

    assertEquals(1234567, lead.getId());
    assertEquals("Test Name", lead.getName());
    assertEquals(timestamp, lead.getCreationTime());
    assertEquals("Test comments", lead.getComments());
    assertEquals(contact, lead.getContact());
    assertEquals(user, lead.getUser());
    assertEquals(product, lead.getProduct());
    assertEquals(status, lead.getStatus());
  }
}