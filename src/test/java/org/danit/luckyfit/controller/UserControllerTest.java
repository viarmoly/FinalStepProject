package org.danit.luckyfit.controller;

import org.danit.luckyfit.entity.User;
import org.danit.luckyfit.service.impl.UserService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {

  @Test
  public void findAll() {
    UserService mockUserService = mock(UserService.class);

    List<User> users = new ArrayList<>();
    User user = new User();
    User admin = new User();
    users.add(user);
    users.add(admin);

    when(mockUserService.findAll()).thenReturn(users);

    assertEquals(users, mockUserService.findAll());
  }
}