package com.rationalagent.triangleclassifier.util.message;

public enum OutputMessage {
  TRIANGLE_MESSAGE("The type of your triangle is "),
  WRONG_AMOUNT_OF_INPUTS("Amount of inputs is incorrect"),
  NON_NUMERIC_PARAMS("Not all input parameters are numeric"),
  SIDES_TOO_SMALL("All sides must be greater than zero"),
  INFO(
      "The correct way of executing the app is:\n " +
      "java -jar TriangleClassifier.jar <length of side a> <length of side b> <length of side c>");


  private final String message;

  OutputMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
