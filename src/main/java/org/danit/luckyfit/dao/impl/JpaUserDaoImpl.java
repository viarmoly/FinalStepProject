package org.danit.luckyfit.dao.impl;

import org.danit.luckyfit.dao.UserRepository;
import org.danit.luckyfit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JpaUserDaoImpl {

  @Autowired
  private UserRepository jpaUserDao;

  public List<User> findAll() {
    List<User> users = jpaUserDao.findAll();
    return users;
  }
}
