package ru.shikhovtsev.exception;

public class NoSuchDepartmentException extends RuntimeException {
  public NoSuchDepartmentException(String message) {
    super(message);
  }
}
