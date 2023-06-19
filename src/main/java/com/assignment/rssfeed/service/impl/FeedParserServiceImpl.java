package com.assignment.rssfeed.service.impl;

import com.assignment.rssfeed.config.UrlConfigurationProperties;
import com.assignment.rssfeed.entity.FeedItem;
import com.assignment.rssfeed.service.FeedParserService;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * FeedParserService implement class. Mange remote data search.
 */
@Service
@EnableConfigurationProperties(UrlConfigurationProperties.class)
public class FeedParserServiceImpl implements FeedParserService {

  private final UrlConfigurationProperties urlConfigurationProperties;

  public FeedParserServiceImpl(UrlConfigurationProperties urlConfigurationProperties) {
    this.urlConfigurationProperties = urlConfigurationProperties;
  }

  /**
   * Access remote url.
   *
   * @return - List<FeedItem>.
   * @throws FeedException
   * @throws IOException
   */
  public List<FeedItem> getFeedItems()
      throws FeedException, IOException {

    URL feedUrl = new URL(urlConfigurationProperties.getFeed());
    SyndFeedInput input = new SyndFeedInput();
    SyndFeed feed = input.build(new XmlReader(feedUrl));
    List<SyndEntry> entries = feed.getEntries();

    return entries
        .stream()
        .map(this::mapToFeedItem)
        .toList().stream()
        .sorted(Comparator.comparing(FeedItem::getPublicationDate).reversed())
        .limit(10)
        .collect(Collectors.toList());

  }

  /**
   * SyndEntry map to FeedItem entity.
   *
   * @param entry - RssFeed details.
   * @return - FeedItem
   */
  private FeedItem mapToFeedItem(SyndEntry entry) {
    return new FeedItem(entry.getTitle(),
        entry.getAuthor(),
        entry.getDescription().getValue(),
        entry.getPublishedDate(),
        entry.getUpdatedDate());
  }

}
