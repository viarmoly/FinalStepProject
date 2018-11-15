package org.danit.luckyfit.controller;

import org.danit.luckyfit.entity.dto.UserDto;
import org.danit.luckyfit.entity.User;
import org.danit.luckyfit.service.impl.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

  private UserService userService;
  private ModelMapper modelMapper = new ModelMapper();

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok(userService.findAll());
  }

  @GetMapping(value = "/{id}")
  public User getByUserId(@PathVariable int id) {
    return userService.getByUserId(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteByUserId(@PathVariable int id) {
    userService.deleteByUserId(id);
  }

  @PostMapping
  public void add(@RequestBody UserDto userDto) {
    User user = modelMapper.map(userDto, User.class);
    userService.add(user);
  }

  @PutMapping(value = "/{id}")
  public User modify(@RequestBody User user) {
    return userService.modify(user);
  }
}