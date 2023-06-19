package com.assignment.rssfeed.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Application specific configuration properties.
 */
@Getter
@Setter
@ConfigurationProperties("url")
public class UrlConfigurationProperties {

  private String feed;


}
