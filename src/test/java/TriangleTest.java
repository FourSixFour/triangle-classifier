import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TriangleTest {

  private Triangle triangle;


  @Test
  void whenAllSidesAreOfEqualLengthReturnEquilateral() {
    triangle = new Triangle(2,2,2);
    Assertions.assertEquals(TriangleType.EQUILATERAL, triangle.getType());
  }

  @Test
  void whenTwoSidesAreOfEqualLengthReturnIsosceles() {
    triangle = new Triangle(2,2,1);
    Assertions.assertEquals(TriangleType.ISOSCELES, triangle.getType());
  }

  @Test
  void whenNoSidesAreOfEqualLengthReturnScalene() {
    triangle = new Triangle(1,2,3);
    Assertions.assertEquals(TriangleType.SCALENE, triangle.getType());
  }
}
