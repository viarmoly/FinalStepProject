package org.danit.luckyfit.controller;

import org.danit.luckyfit.entity.Lead;
import org.danit.luckyfit.service.impl.DefaultLeadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/leads")
public class LeadController {
  private DefaultLeadServiceImpl leadService;

  @Autowired
  public void setLeadService(DefaultLeadServiceImpl leadService) {
    this.leadService = leadService;
  }

  @GetMapping(value = "/{contactId}")
  public List<Lead> getAllByContactId(@PathVariable(value = "contactId") Long contactId) {
    return leadService.getAll(contactId);
  }

  @PostMapping
  public Lead addLead(@RequestBody Lead lead) {
    return leadService.addLead(lead);
  }

  @PutMapping(value = "/{leadId}")
  public Lead updateLead(@PathVariable(value = "leadId") Lead lead) {
    return leadService.updateLead(lead);
  }
}
