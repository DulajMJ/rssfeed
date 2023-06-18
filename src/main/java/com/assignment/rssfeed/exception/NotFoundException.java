package com.assignment.rssfeed.exception;

/**
 * An exception that indicates a requested resource was not found.
 */
public class NotFoundException extends RuntimeException{

  public NotFoundException(final String message) {
    super(message);
  }

  public NotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * Creates {@link com.assignment.rssfeed.exception.NotFoundException}
   *
   * @param type - The type of resource.
   * @param id   - ID of the resource.
   * @return Exception with message.
   */
  public static NotFoundException fromResources(String type, Object id) {
    return new NotFoundException("No %s found with id: '%s'".formatted(type, id));
  }

  /**
   * Creates {@link com.assignment.rssfeed.exception.NotFoundException}
   *
   * @param type   - The type of resource.
   * @param idType - Type of ID used.
   * @param id     - ID of the resource.
   * @return Exception with message.
   */
  public static NotFoundException fromResources(String type, String idType, Object id) {
    return new NotFoundException("No %s found with %s: '%s'".formatted(type, idType, id));
  }

  /**
   * Creates {@link com.assignment.rssfeed.exception.NotFoundException}
   *
   * @param object - Generic object.
   * @return Exception with message.
   */
  public static NotFoundException fromResources(String object) {
    return new NotFoundException("%s not found".formatted(object));
  }
}
