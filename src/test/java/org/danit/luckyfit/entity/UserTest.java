package org.danit.luckyfit.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

  @Test
  public void testUser() {
    User user = new User();
    UserRole userRoleExpected = new UserRole();
    userRoleExpected.setId(1);
    userRoleExpected.setRole("USER");

    user.setUserId(1);
    user.setUserName("Name");
    user.setPassword("Password");
    user.setUserRole(userRoleExpected);
    user.setUserSalt("Salt");

    assertEquals(1, user.getUserId());
    assertEquals("Name", user.getUserName());
    assertEquals("Password", user.getPassword());
    assertEquals(userRoleExpected, user.getUserRole());
    assertEquals("Salt", user.getUserSalt());
    assertEquals("User(userId=1, userName=Name, password=Password, userRole=UserRole(id=1, role=USER), userSalt=Salt)", user.toString());
  }

}