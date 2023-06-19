package com.assignment.rssfeed.controller;

import com.assignment.rssfeed.constant.ApiConstant;
import com.assignment.rssfeed.dto.FeedItemDto;
import com.assignment.rssfeed.service.RssPollService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * RssPoll controller -exposing all rss feed endpoints.
 */
@RestController
@RequestMapping(value = ApiConstant.BASE_PATH + "/feed",
    produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Rss feed", description = "RssFeed APIs")
public class RssPollController {

  private final RssPollService rssPollService;

  public RssPollController(RssPollService rssPollService) {
    this.rssPollService = rssPollService;
  }

  @Operation(summary = "Retrieving the 10 newest items"
      + "Paginated, with direction based on a given field")
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  @ApiResponse(responseCode = ApiConstant.RESPONSE_CODE_200, description = ApiConstant.OK)
  @ApiResponses(value = {
      @ApiResponse(responseCode = ApiConstant.RESPONSE_CODE_400,
          description = ApiConstant.BAD_REQUEST,
          content = {@Content(schema = @Schema(hidden = true))}),
      @ApiResponse(responseCode = ApiConstant.RESPONSE_CODE_404,
          description = ApiConstant.NOT_FOUND,
          content = {@Content(schema = @Schema(hidden = true))}),
      @ApiResponse(responseCode = ApiConstant.RESPONSE_CODE_500,
          description = ApiConstant.INTERNAL_SERVER_ERROR,
          content = {@Content(schema = @Schema(hidden = true))})})
  public Page<FeedItemDto> getFeedItems(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(defaultValue = "publicationDate") String sortField,
      @RequestParam(defaultValue = "desc") String direction) {
    return rssPollService.findAll(page, size, sortField, direction);
  }
}
