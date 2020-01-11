package com.foursixfour;

import com.foursixfour.TriangleClassifier;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleClassifierTest {

  @Test
  void shouldReturnErrorMessageWhenInputParamAmountIsIncorrect() {
    String[] NoParam = {};
    callInputValidation(NoParam);
    String[] oneParam = {"1"};
    callInputValidation(oneParam);
    String[] twoParam = {"1", "2"};
    callInputValidation(twoParam);
    String[] fourParam = {"1", "2", "3" ,"4"};
    callInputValidation(fourParam);
  }

  private void callInputValidation(String[] oneParam) {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.validateInputSize(oneParam));
    assertEquals("Incorrect input parameters.\n"
        + "The correct way of executing the app is: "
        + "java -jar com.foursixfour.TriangleClassifier <length of side a> <length of side b> <length of side c>", e.getMessage());
  }

  @Test
  void shouldReturnErrorWhenParamsAreNotNumeric() {
    String[] oneParam = {"a"};
    callCharacterValidation(oneParam);
    String[] twoParam = {"a", "b"};
    callCharacterValidation(twoParam);
    String[] fourParam = {"a", "b", "c" ,"d"};
    callCharacterValidation(fourParam);
  }

  private void callCharacterValidation(String[] oneParam) {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.validateCharacters(oneParam));
    assertEquals(  "Incorrect input parameters.\n"
        + "The correct way of executing the app is: "
        + "java -jar com.foursixfour.TriangleClassifier <length of side a> <length of side b> <length of side c>",
        e.getMessage());
  }
}
