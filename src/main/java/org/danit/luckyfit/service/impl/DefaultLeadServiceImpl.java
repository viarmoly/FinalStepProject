package org.danit.luckyfit.service.impl;

import org.danit.luckyfit.dao.LeadRepository;
import org.danit.luckyfit.entity.Lead;
import org.danit.luckyfit.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultLeadServiceImpl implements LeadService {
  private LeadRepository leadRepository;

  @Autowired
  public void setLeadRepository(LeadRepository leadRepository) {
    this.leadRepository = leadRepository;
  }

  @Override
  public List<Lead> getAll(Long contactId) {
    return leadRepository.findLeadsByContact_Id(contactId);
  }

  @Override
  public Lead addLead(Lead lead) {
    return leadRepository.save(lead);
  }

  @Override
  public Lead updateLead(Lead lead) {
    return leadRepository.save(lead);
  }
}
