package org.danit.luckyfit.controller;

import org.danit.luckyfit.entity.UserRole;
import org.danit.luckyfit.service.impl.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/userRoles")
public class UserRoleController {
  @Autowired
  private UserRoleService userRoleService;

  @GetMapping
  public List<UserRole> findAll() {
    return userRoleService.findAll();
  }

  @DeleteMapping(value = "/{id}")
  public void deleteByUserId(@PathVariable int id) {
    userRoleService.deleteByUserRoleId(id);
  }

  @PostMapping()
  public void add(@RequestBody UserRole userRole) {
    UserRole currentUserRole = new UserRole();
    currentUserRole.setId(userRole.getId());
    currentUserRole.setRole(userRole.getRole());

    userRoleService.add(currentUserRole);
  }

  @PutMapping(value = "/{id}")
  public UserRole modify(@RequestBody UserRole userRole) {
    return userRoleService.modify(userRole);
  }
}
