package com.foursixfour;

import com.foursixfour.model.Triangle;
import com.foursixfour.model.TriangleType;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;

import static java.lang.Integer.parseInt;


public class TriangleClassifier {

  public static final String invalidInputMessage =
            "The correct way of executing the app is: "
          + "java -jar TriangleClassifier.jar <length of side a> <length of side b> <length of side c>" +
          "\n";

  public static void main(String[] args) {

    try {
      validateInputSize(args);
      validateCharacters(args);
      System.out.println("The type of your triangle is " + getTriangleTypeName(args) + "!");
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      System.err.println(invalidInputMessage);
    }
  }

  private static String getTriangleTypeName(String[] args) {
    return new Triangle(parseInt(args[0]), parseInt(args[1]), parseInt(args[2]))
        .getType()
        .toString()
        .toLowerCase();
  }

  public static void validateInputSize(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException("Amount of inputs is incorrect");
    }
  }

  public static void validateCharacters(String[] args) {
    boolean allParamsAreNumeric = Arrays.stream(args).allMatch(NumberUtils::isDigits);
    if(!allParamsAreNumeric) {
      throw new IllegalArgumentException("Not all input characters are numeric");
    }
  }
}
