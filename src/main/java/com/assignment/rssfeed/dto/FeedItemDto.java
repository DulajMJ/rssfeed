package com.assignment.rssfeed.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class FeedItemDto {

  private String title;

  private String author;


  private String description;


  private Date publicationDate;


  private Date updatedDate;

}
