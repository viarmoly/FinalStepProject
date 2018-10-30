package org.danit.luckyfit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.danit.luckyfit.entity.User;
import org.danit.luckyfit.entity.UserRole;
import org.danit.luckyfit.service.impl.UserService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
  private MockMvc mockMvc;
  private List<User> users = new ArrayList<>();
  private UserRole user = new UserRole();
  private UserRole admin = new UserRole();
  private JacksonTester<List<User>> jsonUsersList;
  private JacksonTester<User> jsonUser;

  @Mock
  private UserService mockUserService;

  @Autowired
  UserController mockUserController;

  @Before
  public void setup() {
    JacksonTester.initFields(this, new ObjectMapper());
    mockMvc = MockMvcBuilders.standaloneSetup(mockUserController).build();
  }

  @Before
  public void mockTestData() {
    user.setRole("USER");
    user.setId(1);

    admin.setRole("ADMIN");
    admin.setId(2);

    User firstUser = new User();
    firstUser.setUserRole(user);
    firstUser.setUserSalt("userSalt");
    firstUser.setPassword("userPassword");
    firstUser.setUserName("firstUser");
    firstUser.setUserId(1);

    User secondUser = new User();
    secondUser.setUserRole(admin);
    secondUser.setUserSalt("adminSalt");
    secondUser.setPassword("adminPassword");
    secondUser.setUserName("secondUser");
    secondUser.setUserId(2);

    users.add(firstUser);
    users.add(secondUser);
  }

  @Test
  public void testFindAll() throws Exception {
    given(mockUserService.findAll())
            .willReturn(users);

    MockHttpServletResponse response = mockMvc.perform(get("/api/v1/users")
            .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse();

    assertEquals(500, response.getStatus());
  }

  @Test
  public void testGetById() throws Exception {
    given(mockUserService.getByUserId(1))
            .willReturn(users.get(1));

    mockMvc.perform(get("/api/v1/users/{id}", 1)).andDo(print());
  }

  @Test
  public void testDeleteById() throws Exception {
    mockMvc.perform(delete("/api/v1/users/{id}", 1)).andExpect(status().isOk());

  }
}