package com.rationalagent;

import com.rationalagent.triangleclassifier.App;
import com.rationalagent.triangleclassifier.util.message.OutputMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class AppIT {

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
    App.main(args);
    String result = outContent.toString().trim();
    assertEquals("The type of your triangle is equilateral", result);
  }

  @Test
  void shouldRespondWithIsosceles() {
    String[] args = {"4", "5", "5"};
    App.main(args);
    assertEquals("The type of your triangle is isosceles", outContent.toString().trim());
  }

  @Test
  void shouldRespondWithScalene() {
    String[] args = {"3", "4", "5"};
    App.main(args);
    assertEquals("The type of your triangle is scalene", outContent.toString().trim());
  }

  @Test
  void whenLettersShouldRespondWithErrorMessage() {
    String[] letters = {"two", "three", "four"};
    App.main(letters);
    assertTrue(errContent.toString().contains(OutputMessage.NON_NUMERIC_PARAMS.getMessage()));
    assertTrue(errContent.toString().contains(OutputMessage.INFO.getMessage()));
  }

  @Test
  void whenNegativeNumbersShouldRespondWithErrorMessage() {
    String[] negativeNumbers = {"-2", "4", "5"};
    App.main(negativeNumbers);
    assertTrue(errContent.toString().contains(OutputMessage.SIDES_TOO_SMALL.getMessage()));
    assertTrue(errContent.toString().contains(OutputMessage.INFO.getMessage()));
  }

  @AfterEach
  void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

}
