package org.danit.luckyfit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.danit.luckyfit.entity.Lead;
import org.danit.luckyfit.service.LeadService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LeadControllerTest {
  private MockMvc mockMvc;

  @Mock
  private LeadService mockLeadService;

  @Autowired
  LeadController mockLeadController;

  @Before
  public void setup() {
    JacksonTester.initFields(this, new ObjectMapper());
    mockMvc = MockMvcBuilders.standaloneSetup(mockLeadController).build();
  }

  @Test
  public void getAllByContactId() throws Exception {
    Lead lead = mock(Lead.class);
    Lead lead2 = mock(Lead.class);

    List<Lead> leads = new ArrayList<>();
    leads.add(lead);
    leads.add(lead2);

    when(mockLeadService.getAll(any())).thenReturn(leads);

    mockMvc.perform(get("/api/v1/leads/1")).andExpect(status().isOk());
  }

  @Test
  public void addLead() {
  }

  @Test
  public void updateLead() {
  }
}