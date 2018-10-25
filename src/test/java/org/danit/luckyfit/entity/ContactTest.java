package org.danit.luckyfit.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ContactTest {


  @Test
  public void testContact() {
    Contact contact = new Contact();
    contact.setId(1);
    contact.setPhone("+380507436335");
    contact.setEmail("turnover34@gmail.com");
    contact.setName("Ivan");


    assertEquals(1, contact.getId());
    assertEquals("+380507436335", contact.getPhone());
    assertEquals("turnover34@gmail.com", contact.getEmail());
    assertEquals("Ivan", contact.getName());

    assertEquals("Contact(id=1, phone=+380507436335, name=Ivan, email=turnover34@gmail.com)", contact.toString());

  }

}