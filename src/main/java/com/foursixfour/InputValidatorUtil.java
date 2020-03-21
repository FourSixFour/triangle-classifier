package com.foursixfour;

import static java.util.Arrays.stream;

public class InputValidatorUtil {

  public static boolean isValidInput(String[] args) {
    return consistsOfThreeArgs(args)
        && paramsAreNumeric(args)
        && paramsAreLargerThanZero(args);
  }

  public static boolean consistsOfThreeArgs(String[] args) {
    return args.length == 3;
  }

  public static boolean paramsAreLargerThanZero(String[] args) {
    return stream(args).allMatch(InputValidatorUtil::isLargerThanZero);
  }

  private static boolean isLargerThanZero(String arg) {
    int n = Integer.parseInt(arg);
    return n > 0;
  }

  public static boolean paramsAreNumeric(String[] args) {
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
