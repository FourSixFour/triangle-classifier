package com.rationalagent.triangleclassifier.util.message;

public class Output {
  private OutputType outputType;
  private OutputMessage outputMessage;

  public Output(OutputType outputType, OutputMessage outputMessage) {
    this.outputType = outputType;
    this.outputMessage = outputMessage;
  }

  public OutputType getOutputType() {
    return outputType;
  }

  public OutputMessage getOutputMessage() {
    return outputMessage;
  }
}
