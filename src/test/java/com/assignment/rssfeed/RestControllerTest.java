package com.assignment.rssfeed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Base class for REST API tests.
 */
@AutoConfigureMockMvc
public class RestControllerTest {
  @Autowired
  public ObjectMapper objectMapper;

  @Autowired
  public MockMvc mvc;

  @Autowired
  protected WebApplicationContext context;
  /**
   * Setting up mock mvc.
   */
  @BeforeEach
  public void setupMvc() {
    mvc = MockMvcBuilders
        .webAppContextSetup(context)
        .build();
  }

  protected <T> T parseJson(MvcResult mvcResult, TypeReference<T> typeClass)
      throws JsonProcessingException, UnsupportedEncodingException {
    return objectMapper.readValue(mvcResult.getResponse().getContentAsString(), typeClass);
  }
}
