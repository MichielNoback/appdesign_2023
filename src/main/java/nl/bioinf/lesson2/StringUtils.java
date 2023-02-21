package nl.bioinf.lesson2;

import java.util.Arrays;

public class StringUtils {
    /**
     * This method searches for the longest string in an input text.
     *
     * When there is a tie, this first will be returned.
     *
     * @param text
     * @return longest word
     */
    public String getLongestWord(String text) {
        // TODO returns null!
        //return null; //DANGER
        // Better first default implementation for TDD
        //throw new UnsupportedOperationException("not implemented yet");
        if(null == text) throw new IllegalArgumentException("text can not be null");
        text = text.replaceAll("[^a-zA-Z ]", "");
        String[] elmnts = text.split("\\s+");
        String longest = "";
        for(String word : elmnts) {
            if (word.length() > longest.length()) longest = word;
        }
        return longest;
    }
}
