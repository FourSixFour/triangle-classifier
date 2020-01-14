package com.foursixfour.model;

import java.util.stream.Stream;

import static com.foursixfour.model.ErrorMessages.SIDES_TOO_SMALL;

public class Triangle {

  private int sideA;
  private int sideB;
  private int sideC;

  public Triangle(int sideA, int sideB, int sideC) {
    if (Stream.of(sideA, sideB, sideC).anyMatch(a -> a < 1)) {
      throw new IllegalArgumentException(SIDES_TOO_SMALL.getMessage());
    }
    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
  }

  public TriangleType getType() {
    int distinctLengths = (int) Stream.of(sideA, sideB, sideC).distinct().count();
    switch (distinctLengths) {
      case 1:
        return TriangleType.EQUILATERAL;
      case 2:
        return TriangleType.ISOSCELES;
      case 3:
        return TriangleType.SCALENE;
      default:
        throw new IllegalArgumentException("Wrong amount: " + distinctLengths);
    }
  }
}
