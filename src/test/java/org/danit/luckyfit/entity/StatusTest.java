package org.danit.luckyfit.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatusTest {
  @Test
  public void testGetIdSetIdGetNameSetNameToString() {
    Status status = new Status();

    status.setId(1);
    status.setName("Test Name");

    assertEquals(1, status.getId());
    assertEquals("Test Name", status.getName());
    assertEquals("Status(id=1, name=Test Name)", status.toString());
  }

}