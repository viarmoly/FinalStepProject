package org.danit.luckyfit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.danit.luckyfit.entity.UserRole;
import org.danit.luckyfit.service.impl.UserRoleService;
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


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRoleControllerTest {
  private MockMvc mockMvc;
  private List<UserRole> userRoles = new ArrayList<>();
  private JacksonTester<List<UserRole>> jsonUserRoles;

  @Mock
  private UserRoleService mockUserRoleService;

  @Autowired
  UserRoleController mockUserRoleController;

  @Autowired
  UserController mockUserController;

  @Before
  public void setup() {
    JacksonTester.initFields(this, new ObjectMapper());
    mockMvc = MockMvcBuilders.standaloneSetup(mockUserRoleController).build();
  }

  @Before
  public void mockTestData() {
    UserRole user = new UserRole();
    UserRole admin = new UserRole();
    UserRole god = new UserRole();

    user.setRole("USER");
    user.setId(1);

    admin.setRole("ADMIN");
    admin.setId(2);

    god.setRole("GOD");
    god.setId(3);

    userRoles.add(user);
    userRoles.add(admin);
    userRoles.add(god);
  }

  @Test
  public void findAll() throws Exception {
    given(mockUserRoleService.findAll())
            .willReturn(userRoles);

    MockHttpServletResponse response = mockMvc.perform(get("/api/v1/userRoles")
            .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse();

    assertEquals(200, response.getStatus());
    assertEquals(response.getContentAsString(), jsonUserRoles.write(userRoles).getJson());
  }

  @Test
  public void deleteByUserId() throws Exception {
    mockMvc.perform(delete("/api/v1/userRoles/{id}", 2));
  }
}