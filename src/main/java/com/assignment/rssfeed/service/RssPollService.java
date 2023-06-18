package com.assignment.rssfeed.service;

import com.assignment.rssfeed.dto.FeedItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RssPollService {

  Page<FeedItemDto> findAll(int page, int size,
      String sortField, String direction);

}
