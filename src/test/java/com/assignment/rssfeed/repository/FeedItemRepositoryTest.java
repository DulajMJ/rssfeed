package com.assignment.rssfeed.repository;

import com.assignment.rssfeed.RestControllerTest;
import com.assignment.rssfeed.entity.FeedItem;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test FeedItem database function.
 */
public class FeedItemRepositoryTest extends RestControllerTest {

  @Autowired
  FeedItemRepository feedItemRepository;

  @AfterEach
  void tearDown() {
    feedItemRepository.deleteAll();
  }

  @Test
  void feedItem_validRequest_success() {
    FeedItem feedItem = feedItemRepository
        .saveAndFlush(FeedItem.builder()
            .author("author").description("description")
            .publicationDate(new Date())
            .build());
    assertThat(feedItem.getAuthor()).isEqualTo("author");
  }

}
