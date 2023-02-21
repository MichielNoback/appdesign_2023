package nl.bioinf.lesson2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @DisplayName("Tests normal cases")
    @Test
    void getLongestWord_withNormalUse() {
        String input = "Hallo dit is een test string";
        String expectedResult = "string";

        StringUtils utils = new StringUtils();
        String longestWord = utils.getLongestWord(input);

        assertEquals(expectedResult, longestWord);
    }

    @ParameterizedTest(name = "longest word of {0} should be {1}")
    @CsvSource({"a bb ccc d, ccc", "aaa b ccc dd, aaa", "aa   b \\t cc ddd , ddd"})
    void getLongestWord_withNormalUse_params(String input, String expectedResult) {
        //System.out.println("input = " + input);
        //System.out.println("expectedResult = " + expectedResult);
        StringUtils utils = new StringUtils();
        String longestWord = utils.getLongestWord(input);

        assertEquals(expectedResult, longestWord);
    }

    @Test
    void getLongestWord_withTie() {
        String input = "Halloo dit is een testje";
        String expectedResult = "Halloo";

        StringUtils utils = new StringUtils();
        String longestWord = utils.getLongestWord(input);

        assertEquals(expectedResult, longestWord);
    }

    @Test
    void getLongestWord_withInterpunction() {
        String input = "Hallo, dit is een testje!";
        String expectedResult = "testje";

        StringUtils utils = new StringUtils();
        String longestWord = utils.getLongestWord(input);

        assertEquals(expectedResult, longestWord);
    }

    @Test
    void getLongestWord_nullInput() {
        String input = null;
        StringUtils utils = new StringUtils();
        assertThrows(IllegalArgumentException.class,
                () -> utils.getLongestWord(input));
    }

    @Test
    void getLongestWord_nullInput_withoutLambda() {
        StringUtils utils = new StringUtils();
        try {
            utils.getLongestWord(null);
            fail();
        } catch (IllegalArgumentException ex) {
            //pass silently
        }
    }

    @Test
    void getLongestWord_emptyString() {
        String input = "";
        String expectedResult = "";

        StringUtils utils = new StringUtils();
        String longestWord = utils.getLongestWord(input);

        assertEquals(expectedResult, longestWord);
    }

}