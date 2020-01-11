import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

  @Test
  void shouldReturnErrorMessageWhenInputParamAmountIsIncorrect() {
    String[] NoParam = {};
    callInputValidation(NoParam);
    String[] oneParam = {"1"};
    callInputValidation(oneParam);
    String[] twoParam = {"1", "2"};
    callInputValidation(twoParam);
    String[] fourParam = {"10", "2", "3" ,"4"};
    callInputValidation(fourParam);
  }

  private void callInputValidation(String[] oneParam) {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Main.validateInputSize(oneParam));
    assertEquals("Incorrect input parameters.\n"
        + "The correct way of executing the app is: "
        + "java -jar TriangleClassifier <length of side a> <length of side b> <length of side c>", e.getMessage());
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
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Main.validateCharacters(oneParam));
    assertEquals("Incorrect input parameters. \n "
        + "The correct way of executing the app is: "
        + "java -jar TriangleClassifier <Side a> <Side b> <Side c>", e.getMessage());
  }
}
