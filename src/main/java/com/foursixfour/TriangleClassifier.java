package com.foursixfour;

import com.foursixfour.model.Triangle;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;


public class TriangleClassifier {

  public static final String invalidInputMessage =
            "The correct way of executing the app is: "
          + "java -jar TriangleClassifier.jar <length of side a> <length of side b> <length of side c>" +
          "\n";

  public static void main(String[] args) {

    try {
      validateInputSize(args);
      validateCharacters(args);

      Triangle triangle = new Triangle(
          Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
      System.out.println("The type of your triangle is " + triangle.getType().toString().toLowerCase() + "!");
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      System.err.println(invalidInputMessage);
    }
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
