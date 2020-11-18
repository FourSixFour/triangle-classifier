package com.rationalagent;

import com.rationalagent.generators.NonPositiveIntegerGenerator;
import com.rationalagent.generators.PositiveIntegerGenerator;
import com.rationalagent.triangleclassifier.util.message.Output;
import com.rationalagent.triangleclassifier.util.message.OutputMessage;
import com.rationalagent.triangleclassifier.util.message.OutputType;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import com.rationalagent.triangleclassifier.util.TriangleUtil;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(JUnitQuickcheck.class)
public class TriangleUtilProperties {

    @Property(trials = 1000)
    public void positiveNumbersAreValid(
            @From(PositiveIntegerGenerator.class) Integer n1,
            @From(PositiveIntegerGenerator.class) Integer n2,
            @From(PositiveIntegerGenerator.class) Integer n3
    ) {
      String[] input = {n1.toString(), n2.toString(), n3.toString()};
      Output output = TriangleUtil.convertToOutput(input);

      assertEquals(OutputType.OUTPUT, output.getOutputType());
      assertTrue(output.getMessage().contains(OutputMessage.TRIANGLE_MESSAGE.getMessage()));
    }

    @Property(trials = 1000)
    public void nonPositiveNumbersAreInvalid(
            @From(NonPositiveIntegerGenerator.class) Integer n1,
            @From(NonPositiveIntegerGenerator.class) Integer n2,
            @From(NonPositiveIntegerGenerator.class) Integer n3
    ) {
        String[] input = {n1.toString(), n2.toString(), n3.toString()};
        Output output = TriangleUtil.convertToOutput(input);

        assertEquals(OutputType.ERROR, output.getOutputType());
        assertTrue(output.getMessage().contains(OutputMessage.SIDES_TOO_SMALL.getMessage()));
    }
}
