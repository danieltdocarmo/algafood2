package com.algafood.algafood.domain.exceptions;

public class EntityInUseException extends RuntimeException {

  public EntityInUseException(String message, Exception e) {
    super(message, e);
  }
}