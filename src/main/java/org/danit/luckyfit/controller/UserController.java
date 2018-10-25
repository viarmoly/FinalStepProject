package org.danit.luckyfit.controller;

import org.danit.luckyfit.entity.User;
import org.danit.luckyfit.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/api/v1/users", method = RequestMethod.GET)
  public List<User> findAll() {
    return userService.findAll();
  }
}
