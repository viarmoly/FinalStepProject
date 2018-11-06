package org.danit.luckyfit.service.impl;

import org.danit.luckyfit.dao.UserRoleRepository;
import org.danit.luckyfit.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

  @Autowired
  private UserRoleRepository userRoleRepository;

  public List<UserRole> findAll() {
    return userRoleRepository.findAll();
  }

  public void deleteByUserRoleId(int id) {
    userRoleRepository.deleteById(id);
  }

  public void add(UserRole userRole) {
    userRoleRepository.save(userRole);
  }

  public UserRole modify(UserRole userRole) {
    return userRoleRepository.save(userRole);
  }
}