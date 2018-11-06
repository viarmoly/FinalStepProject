package org.danit.luckyfit.service.impl;

import org.danit.luckyfit.dao.ContactRepository;
import org.danit.luckyfit.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

  @Autowired
  private ContactRepository contactRepository;

  public List<Contact> findAll() {
    return contactRepository.findAll();
  }

  public Contact getContactById(int id) {
    return contactRepository.getOne((long) id);
  }

  public void deleteContactById(int id) {
    contactRepository.deleteById((long) id);
  }

  public void add(Contact contact) {
    contactRepository.save(contact);
  }

  public Contact modify(Contact contact) {
    return contactRepository.save(contact);
  }
}
