package com.foursixfour;

import com.foursixfour.model.Triangle;

import static com.foursixfour.model.ErrorMessages.NON_NUMERIC_PARAMS;
import static com.foursixfour.model.ErrorMessages.SIDES_TOO_SMALL;
import static com.foursixfour.model.ErrorMessages.WRONG_AMOUNT_OF_INPUTS;
import static java.lang.Integer.parseInt;


public class TriangleClassifier {

  public static void main(String[] args) {

    if(!InputValidatorUtil.isValidInput(args)) {
      System.err.println(getErrorMessage(args));
    } else {
      System.out.println("The type of your triangle is " + getTriangleTypeName(args) + "!");
    }
  }

  private static String getErrorMessage(String[] args) {
    if(!InputValidatorUtil.consistsOfThreeArgs(args)) {
      return WRONG_AMOUNT_OF_INPUTS.getMessage();
    } else if(!InputValidatorUtil.paramsAreNumeric(args)) {
      return NON_NUMERIC_PARAMS.getMessage();
    } else if(!InputValidatorUtil.paramsAreLargerThanZero(args)) {
      return SIDES_TOO_SMALL.getMessage();
    } else {
      return "Something is wrong with your input";
    }
  }

  private static String getTriangleTypeName(String[] args) {
    return new Triangle(parseInt(args[0]), parseInt(args[1]), parseInt(args[2]))
        .getType()
        .toString()
        .toLowerCase();
  }
}
