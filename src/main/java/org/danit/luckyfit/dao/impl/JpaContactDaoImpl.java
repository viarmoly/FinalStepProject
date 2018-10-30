package org.danit.luckyfit.dao.impl;

import org.danit.luckyfit.dao.ContactRepository;
import org.danit.luckyfit.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JpaContactDaoImpl {

  @Autowired
  private ContactRepository jpaContactDao;

  public List<Contact> findAll() {
    List<Contact> contacts = jpaContactDao.findAll();
    return contacts;
  }
}
