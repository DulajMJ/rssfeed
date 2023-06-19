package com.assignment.rssfeed.service;

import com.assignment.rssfeed.dto.FeedItemDto;
import org.springframework.data.domain.Page;

/**
 * RssPollService interface.
 */
public interface RssPollService {

  Page<FeedItemDto> findAll(int page, int size,
      String sortField, String direction);

}
