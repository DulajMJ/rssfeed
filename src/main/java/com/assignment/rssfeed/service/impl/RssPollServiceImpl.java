package com.assignment.rssfeed.service.impl;

import com.assignment.rssfeed.dto.FeedItemDto;
import com.assignment.rssfeed.entity.FeedItem;
import com.assignment.rssfeed.repository.FeedItemRepository;
import com.assignment.rssfeed.service.RssPollService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Mange Rss feed details.All business logic related rss feed.
 */
@Slf4j
@Service
public class RssPollServiceImpl implements RssPollService {

  private final FeedItemRepository feedItemRepository;

  private final FeedParserServiceImpl feedParserService;

  public RssPollServiceImpl(FeedItemRepository feedItemRepository,
      FeedParserServiceImpl feedParserService) {
    this.feedItemRepository = feedItemRepository;
    this.feedParserService = feedParserService;
  }

  /**
   * Pool rss feed details. Run every 5 minutes.
   */
  @SneakyThrows
  @Scheduled(fixedDelay = 300000)
  public void pollRssFeed() {
    log.info("Run every 5 minutes");
    createRssFeed(feedParserService.getFeedItems(""));
    log.info("Rss feed successful update.");
  }

  /**
   * Create rss feed.
   *
   * @param feedItems - RssFeed List.
   */
  private void createRssFeed(List<FeedItem> feedItems) {
    feedItems.forEach(item -> {
      FeedItem validateItem = validationRssFeed(item);
      rssFeedCreateUpdate(item, validateItem);
    });

  }

  /**
   * Create or update rss feed.
   *
   * @param item         - Rss feed detail.
   * @param validateItem - Validate rss feed detail object.
   */
  private void rssFeedCreateUpdate(FeedItem item,
      FeedItem validateItem) {
    if (ObjectUtils.isNotEmpty(validateItem)) {
      validateItem.setDescription(item.getDescription());
      validateItem.setUpdatedDate(item.getUpdatedDate());
      feedItemRepository.save(validateItem);
    } else {
      feedItemRepository.save(item);
    }
  }

  /**
   * Rss feed detail object validate.
   *
   * @param feedItem - Rss feed detail objectg.
   * @return - FeedItem object or null.
   */
  private FeedItem validationRssFeed(FeedItem feedItem) {

    Optional<FeedItem> optionalFeedItem =
        feedItemRepository.findByTitleAndAuthor(feedItem.getTitle(),
            feedItem.getAuthor());
    return optionalFeedItem.orElse(null);

  }

  @Override
  public Page<FeedItemDto> findAll(int page, int size,
      String sortField, String direction) {

    Sort.Direction sortDirection = Sort.Direction.fromString(direction);
    Sort sort = Sort.by(sortDirection, sortField);
    PageRequest pageRequest = PageRequest.of(page, size, sort);
    Page<FeedItem> feedItems=  feedItemRepository.findAll(pageRequest);

    return null;
  }
}
