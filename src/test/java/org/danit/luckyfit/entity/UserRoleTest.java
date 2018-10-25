package org.danit.luckyfit.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRoleTest {

  @Test
  public void testUserRole() {

    UserRole userRole = new UserRole(1, "Admin");
    assertEquals(1, userRole.getId());
    assertEquals("Admin", userRole.getRole());
  }
}
