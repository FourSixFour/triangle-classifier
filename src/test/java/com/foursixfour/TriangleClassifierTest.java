package com.foursixfour;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    assertTrue(e.getMessage().contains("Amount of inputs is incorrect"));
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
    assertTrue(e.getMessage().contains("Not all input characters are numeric"));
  }
}
