package org.danit.luckyfit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.danit.luckyfit.entity.Contact;
import org.danit.luckyfit.service.impl.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {
  private MockMvc mockMvc;
  private List<Contact> contacts = new ArrayList<>();
  private JacksonTester<List<Contact>> jsonContactsList;
  private JacksonTester<Contact> jsonContact;

  @Mock
  private ContactService mockContactService;

  @Autowired
  ContactController mockContactController;

  @Before
  public void setup() {
    JacksonTester.initFields(this, new ObjectMapper());
    mockMvc = MockMvcBuilders.standaloneSetup(mockContactController).build();
  }

  @Before
  public void mockTestData() {
    Contact firstContact = new Contact();

    firstContact.setId(1);
    firstContact.setName("First");
    firstContact.setPhone("+380667464646");
    firstContact.setEmail("gazeta@gmail.com");

    Contact secondContact = new Contact();

    secondContact.setId(2);
    secondContact.setName("Second");
    secondContact.setPhone("+380509387132");
    secondContact.setEmail("lenta@gmail.com");

    contacts.add(firstContact);
    contacts.add(secondContact);
  }

  @Test
  public void testFindAll() throws Exception {
    given(mockContactService.findAll()).willReturn(contacts);

    MockHttpServletResponse response = mockMvc.perform(get("/api/v1/contacts")
            .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse();

    assertEquals(200, response.getStatus());
    assertEquals(response.getContentAsString(), jsonContactsList.write(contacts).getJson());
  }

  @Test
  public void testGetById() throws Exception {
    given(mockContactService.getContactById(1))
            .willReturn(contacts.get(1));

    mockMvc.perform(get("/api/v1/contacts/{id}", 1)).andDo(print());
  }

  @Test
  public void deleteByContactId() throws Exception {
    mockMvc.perform(delete("/api/v1/contacts/{id}", 1)).andExpect(status().isOk());
  }



}
