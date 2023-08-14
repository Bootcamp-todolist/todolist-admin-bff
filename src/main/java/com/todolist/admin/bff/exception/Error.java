package com.todolist.admin.bff.exception;

public enum Error {
  INVALID_REQUEST_PARAMETERS("Invalid Request Parameters");

  private final String value;

  public String getValue() {
    return value;
  }

  Error(String value) {
    this.value = value;
  }
}
