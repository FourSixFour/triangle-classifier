package com.foursixfour.model;

import com.foursixfour.model.triangle.Triangle;
import com.foursixfour.model.triangle.TriangleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {

  private Triangle triangle;


  @Test
  void whenAllSidesAreOfEqualLengthReturnEquilateral() {
    triangle = new Triangle(2, 2, 2);
    assertEquals(TriangleType.EQUILATERAL, triangle.getType());
  }

  @Test
  void whenTwoSidesAreOfEqualLengthReturnIsosceles() {
    triangle = new Triangle(2, 2, 1);
    assertEquals(TriangleType.ISOSCELES, triangle.getType());
  }

  @Test
  void whenNoSidesAreOfEqualLengthReturnScalene() {
    triangle = new Triangle(1, 2, 3);
    assertEquals(TriangleType.SCALENE, triangle.getType());
  }
}
