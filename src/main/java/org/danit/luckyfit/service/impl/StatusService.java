package org.danit.luckyfit.service.impl;

import org.danit.luckyfit.dao.StatusRepository;
import org.danit.luckyfit.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

  @Autowired
  private StatusRepository statusRepository;

  public List<Status> findAll() {
    return statusRepository.findAll();
  }

  public void deleteByStatusId(int id) {
    statusRepository.deleteById(id);
  }

  public void add(Status status) {
    statusRepository.save(status);
  }

  public Status modify(Status status) {
    return statusRepository.save(status);
  }
}
