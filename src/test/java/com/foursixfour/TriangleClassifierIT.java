package com.foursixfour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.foursixfour.model.ErrorMessages.NON_NUMERIC_PARAMS;
import static com.foursixfour.model.ErrorMessages.SIDES_TOO_SMALL;
import static com.foursixfour.model.ErrorMessages.WRONG_AMOUNT_OF_INPUTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TriangleClassifierIT {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @BeforeEach
  void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @Test
  void shouldRespondWithEquilateral() {
    String[] args = {"5", "5", "5"};
    TriangleClassifier.main(args);
    String result = outContent.toString();
    assertEquals("The type of your triangle is equilateral!\n", result);
  }

  @Test
  void shouldRespondWithIsosceles() {
    String[] args = {"4", "5", "5"};
    TriangleClassifier.main(args);
    assertEquals("The type of your triangle is isosceles!\n", outContent.toString());
  }

  @Test
  void shouldRespondWithScalene() {
    String[] args = {"3", "4", "5"};
    TriangleClassifier.main(args);
    assertEquals("The type of your triangle is scalene!\n", outContent.toString());
  }

  @Test
  void whenLettersShouldRespondWithErrorMessage() {
    String[] letters = {"two", "three", "four"};
    TriangleClassifier.main(letters);
    assertEquals(NON_NUMERIC_PARAMS.getMessage() + "\n", errContent.toString());
  }

  @Test
  void whenNegativeNumbersShouldRespondWithErrorMessage() {
    String[] negativeNumbers = {"-2", "4", "5"};
    TriangleClassifier.main(negativeNumbers);
    assertEquals(SIDES_TOO_SMALL.getMessage() + "\n", errContent.toString());
  }

  @AfterEach
  void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

}
