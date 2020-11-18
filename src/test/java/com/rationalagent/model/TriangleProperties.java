package com.rationalagent.model;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import com.rationalagent.generators.PositiveIntegerGenerator;
import com.rationalagent.triangleclassifier.model.Triangle;
import com.rationalagent.triangleclassifier.model.TriangleType;

import org.junit.runner.RunWith;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class TriangleProperties {

    @Property(trials = 1000)
    public void whenAllSidesAreOfEqualLengthReturnEquilateral(
            @From(PositiveIntegerGenerator.class) Integer sideLength
    ) {
        Triangle triangle = new Triangle(sideLength, sideLength, sideLength);
        assertEquals(TriangleType.EQUILATERAL, triangle.getType());
    }

    @Property(trials = 1000)
    public void whenTwoSidesAreOfEqualLengthReturnIsosceles(
            @From(PositiveIntegerGenerator.class) Integer sideLength
    ) {
        int differentSideLength = sideLength - ThreadLocalRandom.current().nextInt(1, 10);
        Triangle triangle = new Triangle(sideLength, sideLength, differentSideLength);
        assertEquals(TriangleType.ISOSCELES, triangle.getType());
    }

    @Property(trials = 1000)
    public void whenNoSidesAreOfEqualLengthReturnScalene(
            @From(PositiveIntegerGenerator.class) Integer sideA
    ) {
        int sideB = sideA - ThreadLocalRandom.current().nextInt(1, 10);
        int sideC = sideB - ThreadLocalRandom.current().nextInt(1, 10);

        Triangle triangle = new Triangle(sideA, sideB, sideC);
        assertEquals(TriangleType.SCALENE, triangle.getType());
    }
}
