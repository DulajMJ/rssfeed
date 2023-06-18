package com.assignment.rssfeed.exception;

/**
 * Examples of error messages that will be returned by the API.
 *
 * <p> Example:
 * <pre>{@code
 *      @ResponseStatus(code = HttpStatus.CREATED)
 *      @ApiResponse(responseCode = "201", description = "Created")
 *      @ApiResponse(responseCode = "400", description = "Validation failed",
 *              content = @Content(schema = @schema(implementation = ErrorMessageDto.class),
 *              examples = @ExampleObject(ErrorExample.VALIDATION_FAILED)))
 *      public ObjectWeb createObject(ObjectWeb obj) { ... }
 * }</pre>
 */
public class ErrorExample {

  private ErrorExample() {
  }

  public static final String VALIDATION_FAILED = """
      {
          "message": "Validation failed",
          "logref": "ERROR1DEYR5DTE4R",
          "type": "PropertyValidationException",
          "errors": [
              {
                  "path": "name",
                  "message": "is required"
              }
          ]
      }
      """;

  public static final String NOT_FOUND = """ 
      {
          "message": "Resource not found",
          "logref": "ERROR1DEYR5DTE4R",
          "type": "NotFoundException"
      }
      """;
}
