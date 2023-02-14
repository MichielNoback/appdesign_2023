package nl.bioinf.lesson2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    void getLongestWord_withNormalUse() {
        String input = "Hallo dit is een test string";
        String expectedResult = "string";

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
        String input = "Hallo, dit is een testje";
        String expectedResult = "testje";

        StringUtils utils = new StringUtils();
        String longestWord = utils.getLongestWord(input);

        assertEquals(expectedResult, longestWord);
    }

    @Test
    void getLongestWord_nullInput() {
        String input = null;
        StringUtils utils = new StringUtils();
        assertThrows(IllegalArgumentException.class, () -> utils.getLongestWord(input));
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