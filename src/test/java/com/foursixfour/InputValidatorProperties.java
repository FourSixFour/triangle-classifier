package com.foursixfour;

import com.foursixfour.model.message.OutputType;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(JUnitQuickcheck.class)
public class InputValidatorProperties {

    @Property(trials = 1000) public void positiveNumbersAreValid(
        @From(PositiveNumberGenerator.class) String n1,
        @From(PositiveNumberGenerator.class) String n2,
        @From(PositiveNumberGenerator.class) String n3) {
      String[] input = {n1, n2, n3};
      assertEquals(OutputType.OUTPUT, InputValidatorUtil.getMessage(input).getOutputType());
    }
}
