package com.rationalagent.triangleclassifier.util.message;

public class Output {

  private final OutputType outputType;
  private final String message;

  public Output(OutputType outputType, String outputMessage) {
    this.outputType = outputType;
    this.message = outputMessage;
  }

  public OutputType getOutputType() {
    return outputType;
  }

  public String getMessage() {
    return message;
  }
}
