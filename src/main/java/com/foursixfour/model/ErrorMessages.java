package com.foursixfour.model;

public enum ErrorMessages {
  WRONG_AMOUNT_OF_INPUTS("Amount of inputs is incorrect"),
  NON_NUMERIC_PARAMS("Not all input parameters are numeric"),
  SIDES_TOO_SMALL("All sides must be bigger than zero");

  private String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message
        + "\n"
        + "The correct way of executing the app is:"
        + "\n"
        + "java -jar TriangleClassifier.jar <length of side a> <length of side b> <length of side c>\"";
  }
}
