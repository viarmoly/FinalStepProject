package org.danit.luckyfit.controller;

import org.danit.luckyfit.entity.User;
import org.danit.luckyfit.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> findAll() {
    return userService.findAll();
  }

  @GetMapping(value = "/{id}")
  public User getByUserId(@PathVariable int id) {
    return userService.getByUserId(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteByUserId(@PathVariable int id) {
    userService.deleteByUserId(id);
  }

  @PostMapping()
  public void add(@RequestBody User user) {
    User currentUser = new User();
    currentUser.setUserId(user.getUserId());
    currentUser.setUserRole(user.getUserRole());
    currentUser.setUserSalt(user.getUserSalt());
    currentUser.setPassword(user.getPassword());
    currentUser.setUserName(user.getUserName());

    userService.add(currentUser);
  }

  @PutMapping(value = "/{id}")
  public User modify(@RequestBody User user) {
    return userService.modify(user);
  }
}
