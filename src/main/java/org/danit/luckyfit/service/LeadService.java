package org.danit.luckyfit.service;

import org.danit.luckyfit.entity.Lead;

import java.util.List;

public interface LeadService {
  List<Lead> getAll(Long contactId);

  Lead addLead(Lead lead);

  Lead updateLead(Lead lead);
}
