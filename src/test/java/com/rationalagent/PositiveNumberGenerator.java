package com.rationalagent;


import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class PositiveNumberGenerator extends Generator<String> {

  private static final String NUMBERS = "123456789";

  public PositiveNumberGenerator() {
    super(String.class);
  }

  @Override
  public String generate(SourceOfRandomness random, GenerationStatus status) {
    StringBuilder sb = new StringBuilder();
    int randomIndex = random.nextInt(NUMBERS.length());
    sb.append(NUMBERS.charAt(randomIndex));
    return sb.toString();
  }
}