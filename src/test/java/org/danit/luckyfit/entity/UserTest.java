package org.danit.luckyfit.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

  @Test
  public void testUser() {
    User user = new User();

    user.setUserId(1);
    user.setUserName("Name");
    user.setPassword("Password");
    user.setUserRoleId(1);
    user.setUserSalt("Salt");

    assertEquals(1, user.getUserId());
    assertEquals("Name", user.getUserName());
    assertEquals("Password", user.getPassword());
    assertEquals(1, user.getUserRoleId());
    assertEquals("Salt", user.getUserSalt());
    assertEquals("User(userId=1, userName=Name, password=Password, userRoleId=1, userSalt=Salt)", user.toString());
  }

}