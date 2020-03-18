package com.foursixfour;

import com.foursixfour.model.Triangle;

import static java.lang.Integer.parseInt;


public class TriangleClassifier {

  public static void main(String[] args) {

    try {
      InputValidatorUtil.validateInputSize(args);
      InputValidatorUtil.validateCharacters(args);
      System.out.println("The type of your triangle is " + getTriangleTypeName(args) + "!");
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String getTriangleTypeName(String[] args) {
    return new Triangle(parseInt(args[0]), parseInt(args[1]), parseInt(args[2]))
        .getType()
        .toString()
        .toLowerCase();
  }
}
