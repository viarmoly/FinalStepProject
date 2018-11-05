package org.danit.luckyfit.service.impl;

import org.danit.luckyfit.dao.UserRepository;
import org.danit.luckyfit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User getByUserId(int id) {
    return userRepository.getOne((long) id);
  }

  public void deleteByUserId(int id) {
    userRepository.deleteById((long) id);
  }

  public void add(User user) {
    userRepository.save(user);
  }

  public User modify(User user) {
    return userRepository.save(user);
  }
}