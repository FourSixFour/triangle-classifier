package com.rationalagent.triangleclassifier.util;

import com.rationalagent.triangleclassifier.util.message.Output;
import com.rationalagent.triangleclassifier.util.message.OutputMessage;
import com.rationalagent.triangleclassifier.util.message.OutputType;

import static java.util.Arrays.stream;

public class InputValidatorUtil {

  public static Output getMessage(String[] args) {
    if(!consistsOfThreeArgs(args)) {
      return new Output(OutputType.ERROR, OutputMessage.WRONG_AMOUNT_OF_INPUTS);
    } else if(!paramsAreNumeric(args)) {
      return new Output(OutputType.ERROR, OutputMessage.NON_NUMERIC_PARAMS);
    } else if(!paramsAreLargerThanZero(args)) {
      return new Output(OutputType.ERROR, OutputMessage.SIDES_TOO_SMALL);
    } else {
      return new Output(OutputType.OUTPUT, OutputMessage.TRIANGLE_MESSAGE);
    }
  }

  private static boolean consistsOfThreeArgs(String[] args) {
    return args.length == 3;
  }

  private static boolean paramsAreLargerThanZero(String[] args) {
    return stream(args).allMatch(InputValidatorUtil::isLargerThanZero);
  }

  private static boolean isLargerThanZero(String arg) {
    int n = Integer.parseInt(arg);
    return n > 0;
  }

  private static boolean paramsAreNumeric(String[] args) {
    return stream(args).allMatch(InputValidatorUtil::isANumber);
  }

  private static boolean isANumber(String arg) {
    try {
      Integer.parseInt(arg);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
