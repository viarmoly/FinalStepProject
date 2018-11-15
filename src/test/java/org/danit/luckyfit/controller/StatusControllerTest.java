package org.danit.luckyfit.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.danit.luckyfit.entity.Status;
import org.danit.luckyfit.service.impl.StatusService;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatusControllerTest {
  private MockMvc mockMvc;
  private List<Status> statuses = new ArrayList<>();
  private JacksonTester<List<Status>> jsonStatuses;

  @Mock
  private StatusService mockStatusService;

  @Autowired
  StatusController mockStatusController;

  @Before
  public void setup(){
    JacksonTester.initFields(this, new ObjectMapper());
    mockMvc = MockMvcBuilders.standaloneSetup(mockStatusController).build();
  }

  @Before
  public void mockTestData() {
    Status status1 = new Status();
    Status status2 = new Status();

    status1.setId(1);
    status1.setName("active_status1");

    status2.setId(2);
    status2.setName("active_status2");

    statuses.add(status1);
    statuses.add(status2);
  }

  @Test
  public void findAll() throws Exception {
    given(mockStatusService.findAll())
        .willReturn(statuses);

    MockHttpServletResponse response = mockMvc.perform(get("/api/v1/statuses")
    .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse();

    assertEquals(200, response.getStatus());
    assertEquals(response.getContentAsString(), jsonStatuses.write(statuses).getJson());
  }

  @Test
  public void testDeleteById() throws Exception {
    mockMvc.perform(delete("/api/v1/statuses/{id}", 1)).andExpect(status().isMethodNotAllowed());
  }
}

