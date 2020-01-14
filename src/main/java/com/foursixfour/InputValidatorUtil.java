package com.foursixfour;

import static com.foursixfour.model.ErrorMessages.*;
import static java.util.Arrays.stream;

public class InputValidatorUtil {

  public static void validateInputSize(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException(WRONG_AMOUNT_OF_INPUTS.getMessage());
    }
  }

  public static void validateCharacters(String[] args) {
    boolean allParamsAreNumeric = stream(args).allMatch(InputValidatorUtil::isANumber);
    if (!allParamsAreNumeric) {
      throw new IllegalArgumentException(NON_NUMERIC_PARAMS.getMessage());
    } else {
      boolean allNumbersAreLargerThanZero = stream(args).allMatch(InputValidatorUtil::isLargerThanZero);
      if (!allNumbersAreLargerThanZero) {
        throw new IllegalArgumentException(SIDES_TOO_SMALL.getMessage());
      }
    }
  }

  private static boolean isLargerThanZero(String arg) {
    int n = Integer.parseInt(arg);
    return n > 0;
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
