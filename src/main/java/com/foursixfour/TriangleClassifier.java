package com.foursixfour;

import com.foursixfour.model.message.Output;
import com.foursixfour.model.message.OutputMessage;
import com.foursixfour.model.message.OutputType;
import com.foursixfour.model.triangle.Triangle;

import static java.lang.Integer.parseInt;


public class TriangleClassifier {

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
