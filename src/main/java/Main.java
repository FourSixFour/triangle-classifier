import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.stream.Stream;


public class Main {

  private static final String invalidInputMessage =
      "Incorrect input parameters. \n "
          + "The correct way of executing the app is: "
          + "java -jar TriangleClassifier <Side a> <Side b> <Side c>";

  public static void main(String[] args) {
    validateInputSize(args);
    validateCharacters(args);

    Triangle triangle = new Triangle(
        Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    System.out.println("The type of your triangle is " + triangle.getType().toString().toLowerCase() + "!");
  }

  public static void validateInputSize(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException(invalidInputMessage);
    }
  }

  public static void validateCharacters(String[] args) {
    boolean allParamsAreNumeric = Arrays.stream(args).allMatch(NumberUtils::isDigits);
    if(!allParamsAreNumeric) {
      throw new IllegalArgumentException(invalidInputMessage);
    }
  }
}
