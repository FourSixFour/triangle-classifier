import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    Main.main(args);
    String result =  outContent.toString();
    assertEquals("The type of your triangle is equilateral!", result);
  }

  @Test
  void shouldRespondWithIsosceles() {
    String[] args = {"4", "5", "5"};
    Main.main(args);
    assertEquals("The type of your triangle is isosceles!", outContent.toString());
  }

  @Test
  void shouldRespondWithScalene() {
    String[] args = {"3", "4", "5"};
    Main.main(args);
    assertEquals("The type of your triangle is scalene!", outContent.toString());
  }

  @AfterEach
  void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

}
