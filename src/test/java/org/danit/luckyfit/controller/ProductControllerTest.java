package org.danit.luckyfit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.danit.luckyfit.entity.Product;
import org.danit.luckyfit.service.impl.ProductService;
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
public class ProductControllerTest {
  private MockMvc mockMvc;
  private List<Product> products = new ArrayList<>();
  private JacksonTester<List<Product>> jsonProducts;

  @Mock
  private ProductService mockProductService;

  @Autowired
  ProductController productController;

  @Before
  public void setup() {
    JacksonTester.initFields(this, new ObjectMapper());
    mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
  }

  @Before
  public void mockTestData() {
    Product firstProduct = new Product();
    Product secondProduct = new Product();

    firstProduct.setId(1);
    firstProduct.setName("firstProduct");

    secondProduct.setId(2);
    secondProduct.setName("secondProduct");

    products.add(firstProduct);
    products.add(secondProduct);
  }


  @Test
  public void findAll() throws Exception {
    given(mockProductService.findAll())
        .willReturn(products);

    MockHttpServletResponse response = mockMvc.perform(get("/api/v1/products")
        .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse();

    assertEquals(200, response.getStatus());
    assertEquals(response.getContentAsString(), jsonProducts.write(products).getJson());
  }

  @Test
  public void deleteByUserId() throws Exception {
    mockMvc.perform(delete("/api/v1/products/{id}", 1)
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
  }
}