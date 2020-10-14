package com.rationalagent.triangleclassifier.model;

import java.util.stream.Stream;


public class Triangle {

  private int sideA;
  private int sideB;
  private int sideC;

  public Triangle(int sideA, int sideB, int sideC) {
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
