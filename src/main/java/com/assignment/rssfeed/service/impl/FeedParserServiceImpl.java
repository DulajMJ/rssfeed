package com.assignment.rssfeed.service.impl;

import com.assignment.rssfeed.entity.FeedItem;
import com.assignment.rssfeed.service.FeedParserService;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * FeedParserService implement class. Mange remote data search.
 */
@Service
public class FeedParserServiceImpl implements FeedParserService {

  /**
   * Access remote url.
   *
   * @param url - RssFeed Url.
   * @return - List<FeedItem>.
   * @throws FeedException
   * @throws IOException
   */
  public List<FeedItem> getFeedItems(String url)
      throws FeedException, IOException {

    URL feedUrl = new URL("");
    SyndFeedInput input = new SyndFeedInput();
    SyndFeed feed = input.build(new XmlReader(feedUrl));
    List<SyndEntry> entries = feed.getEntries();

    return entries
        .stream()
        .map(this::mapToFeedItem)
        .toList();
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
