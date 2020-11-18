package com.rationalagent.triangleclassifier;

import com.rationalagent.triangleclassifier.util.message.Output;
import com.rationalagent.triangleclassifier.util.message.OutputMessage;
import com.rationalagent.triangleclassifier.util.message.OutputType;
import com.rationalagent.triangleclassifier.util.TriangleUtil;


public class App {

  public static void main(String[] args) {

    final Output output = TriangleUtil.convertToOutput(args);

    if(output.getOutputType().equals(OutputType.ERROR)) {
      System.err.println(output.getMessage());
      System.err.println(OutputMessage.INFO.getMessage());
    } else {
      System.out.println(output.getMessage());
    }
  }
}
