package com.assignment.rssfeed.controller;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.assignment.rssfeed.RestControllerTest;
import com.assignment.rssfeed.dto.FeedItemDto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.type.TypeReference;

class RssPollControllerTest extends RestControllerTest {

  public static final String FEED_URL = "/api/v1/feed";

  @SqlGroup({
      @Sql(value = "classpath:integration-test/data.sql",
          executionPhase = BEFORE_TEST_METHOD),
      @Sql(value = "classpath:integration-test/reset.sql",
          executionPhase = AFTER_TEST_METHOD)
  })
  @Test
  void feedItem_default_value_validRequest_success() throws Exception {
    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
            .get(FEED_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();
    Page<FeedItemDto> paged =
        parseJson(mvcResult, new TypeReference<RestResponsePage<FeedItemDto>>() {
        });
    assertThat(paged.getContent()).hasSize(10);
    FeedItemDto result = paged.getContent().get(9);
    AssertionsForClassTypes.assertThat(result).isNotNull();
    AssertionsForClassTypes.assertThat(result.getTitle()).isEqualTo("title 9");
    AssertionsForClassTypes.assertThat(result.getAuthor()).isEqualTo("author 9");
  }

}
