package com.assignment.rssfeed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Feed Item database entity class.
 */
@Entity
@Table(name = "rss_feed")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;

  private String author;

  @Column(length = 10000)
  private String description;

  @Temporal(TemporalType.DATE)
  private Date publicationDate;

  @Temporal(TemporalType.DATE)
  private Date updatedDate;

  public FeedItem(String title, String author,
      String description, Date publicationDate,
      Date updatedDate) {
    this.title = title;
    this.author = author;
    this.description = description;
    this.publicationDate = publicationDate;
    this.updatedDate = updatedDate;
  }
}
