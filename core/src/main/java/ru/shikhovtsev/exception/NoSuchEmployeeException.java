package ru.shikhovtsev.exception;

public class NoSuchEmployeeException extends RuntimeException {
  public NoSuchEmployeeException(String message) {
    super(message);
  }
}
