package com.foursixfour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    String result =  outContent.toString();
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
  void shouldRespondWithErrorMessage() {
    String[] args = {"-2", "4", "5"};
    TriangleClassifier.main(args);
    assertTrue(errContent.toString().contains(TriangleClassifier.invalidInputMessage));
    assertTrue(errContent.toString().contains("Not all input characters are numeric"));
  }

  @AfterEach
  void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

}
