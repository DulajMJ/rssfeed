package com.assignment.rssfeed.repository;

import com.assignment.rssfeed.entity.FeedItem;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Feed Item database repository.
 */
@Repository
public interface FeedItemRepository extends
    JpaRepository<FeedItem, Long> {


  Optional<FeedItem> findByTitleAndAuthor(String title, String author);

}
