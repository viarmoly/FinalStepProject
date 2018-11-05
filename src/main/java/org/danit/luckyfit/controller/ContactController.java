package org.danit.luckyfit.controller;

import org.danit.luckyfit.entity.Contact;
import org.danit.luckyfit.service.impl.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/contacts")
public class ContactController {

  @Autowired
  private ContactService contactService;

  @GetMapping
  public List<Contact> findAll() {
    return contactService.findAll();
  }

  @GetMapping(value = "/{id}")
  public Contact getContactById(@PathVariable int id) {
    return contactService.getContactById(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteContactById(@PathVariable int id) {
    contactService.deleteContactById(id);
  }

  @PostMapping()
  public void add(@RequestBody Contact contact) {
    Contact currentContact = new Contact();
    currentContact.setId(contact.getId());
    currentContact.setName(contact.getName());
    currentContact.setEmail(contact.getEmail());
    currentContact.setPhone(contact.getPhone());

    contactService.add(currentContact);
  }

  @PutMapping(value = "/{id}")
  public Contact modify(@RequestBody Contact contact) {
    return contactService.modify(contact);
  }
}
