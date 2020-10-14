package com.rationalagent.triangleclassifier;

import com.rationalagent.triangleclassifier.util.message.Output;
import com.rationalagent.triangleclassifier.util.message.OutputMessage;
import com.rationalagent.triangleclassifier.util.message.OutputType;
import com.rationalagent.triangleclassifier.model.Triangle;
import com.rationalagent.triangleclassifier.util.InputValidatorUtil;

import static java.lang.Integer.parseInt;


public class App {

  public static void main(String[] args) {

    final Output om = InputValidatorUtil.getMessage(args);

    if(om.getOutputType().equals(OutputType.ERROR)) {
      System.err.println(om.getOutputMessage().getMessage());
      System.err.println(OutputMessage.INFO.getMessage());
    } else {
      System.out.println(om.getOutputMessage().getMessage() + getTriangleTypeName(args));
    }

  }

  private static String getTriangleTypeName(String[] args) {
    return new Triangle(parseInt(args[0]), parseInt(args[1]), parseInt(args[2]))
        .getType()
        .toString()
        .toLowerCase();
  }
}
