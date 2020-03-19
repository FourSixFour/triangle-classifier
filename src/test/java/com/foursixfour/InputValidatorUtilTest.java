package com.foursixfour;

import org.junit.jupiter.api.Test;

import static com.foursixfour.model.ErrorMessages.NON_NUMERIC_PARAMS;
import static com.foursixfour.model.ErrorMessages.WRONG_AMOUNT_OF_INPUTS;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputValidatorUtilTest {

  @Test
  void shouldReturnErrorMessageWhenInputParamAmountIsIncorrect() {
    String[] NoParam = {};
    callInputValidation(NoParam);
    String[] oneParam = {"1"};
    callInputValidation(oneParam);
    String[] twoParam = {"1", "2"};
    callInputValidation(twoParam);
    String[] fourParam = {"1", "2", "3", "4"};
    callInputValidation(fourParam);
  }

  private void callInputValidation(String[] oneParam) {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
        InputValidatorUtil.validateInputSize(oneParam));
    assertTrue(e.getMessage().contains(WRONG_AMOUNT_OF_INPUTS.getMessage()));
  }

  @Test
  void shouldReturnErrorWhenParamsAreNotNumeric() {
    String[] oneParam = {"a"};
    callCharacterValidation(oneParam);
    String[] twoParam = {"a", "b"};
    callCharacterValidation(twoParam);
    String[] fourParam = {"a", "b", "c", "d"};
    callCharacterValidation(fourParam);
  }

  private void callCharacterValidation(String[] oneParam) {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
        InputValidatorUtil.validateCharacters(oneParam));
    assertTrue(e.getMessage().contains(NON_NUMERIC_PARAMS.getMessage()));
  }
}
