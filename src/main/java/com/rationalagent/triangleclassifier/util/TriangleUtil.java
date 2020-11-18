package com.rationalagent.triangleclassifier.util;

import com.rationalagent.triangleclassifier.model.Triangle;
import com.rationalagent.triangleclassifier.util.message.Output;
import com.rationalagent.triangleclassifier.util.message.OutputMessage;
import com.rationalagent.triangleclassifier.util.message.OutputType;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;

public class TriangleUtil {

  public static Output convertToOutput(String[] args) {
    if(!consistsOfThreeArgs(args)) {
      return new Output(OutputType.ERROR, OutputMessage.WRONG_AMOUNT_OF_INPUTS.getMessage());
    } else if(!paramsAreNumeric(args)) {
      return new Output(OutputType.ERROR, OutputMessage.NON_NUMERIC_PARAMS.getMessage());
    } else if(!paramsAreLargerThanZero(args)) {
      return new Output(OutputType.ERROR, OutputMessage.SIDES_TOO_SMALL.getMessage());
    } else {
      return new Output(OutputType.OUTPUT, OutputMessage.TRIANGLE_MESSAGE.getMessage() + getTriangleTypeName(args));
    }
  }

  private static boolean consistsOfThreeArgs(String[] args) {
    return args.length == 3;
  }

  private static boolean paramsAreNumeric(String[] args) {
    return stream(args).allMatch(TriangleUtil::isANumber);
  }

  private static boolean paramsAreLargerThanZero(String[] args) {
    return stream(args).allMatch(TriangleUtil::isLargerThanZero);
  }

  private static String getTriangleTypeName(String[] args) {
    return new Triangle(parseInt(args[0]), parseInt(args[1]), parseInt(args[2]))
            .getType()
            .toString()
            .toLowerCase();
  }

  private static boolean isANumber(String arg) {
    try {
      Integer.parseInt(arg);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static boolean isLargerThanZero(String arg) {
    int n = Integer.parseInt(arg);
    return n > 0;
  }
}
