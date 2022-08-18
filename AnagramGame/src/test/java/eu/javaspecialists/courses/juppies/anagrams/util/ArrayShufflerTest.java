package eu.javaspecialists.courses.juppies.anagrams.util;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ArrayShufflerTest {
    @Test
    public void testShuffle() {
        int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayShuffler shuffler = new ArrayShuffler();
        String originalString = Arrays.toString(original);

        String shuffled1;
        String shuffled2;
        String sorted;

        {
            int[] indexes = original.clone();
            shuffler.shuffle(indexes);
            shuffled1 = Arrays.toString(indexes);
            Arrays.sort(indexes);
            sorted = Arrays.toString(indexes);
        }

        {
            int[] indexes = original.clone();
            shuffler.shuffle(indexes);
            shuffled2 = Arrays.toString(indexes);
        }

        assertNotEquals(shuffled1, originalString);
        assertNotEquals(shuffled2, originalString);
        assertNotEquals(shuffled1, shuffled2);
        assertEquals(originalString, sorted);
    }

    @Test
    public void testShuffleChars() {
        char[] letters = "hello world".toCharArray();
        ArrayShuffler shuffler = new ArrayShuffler();
        shuffler.shuffle(letters);
        String shuffle1 = new String(letters);

        letters = "hello world".toCharArray();
        shuffler.shuffle(letters);
        String shuffle2 = new String(letters);

        Arrays.sort(letters);
        String sorted = new String(letters);

        assertNotEquals("hello world", shuffle1);
        assertNotEquals(shuffle1, shuffle2);
        assertEquals(" dehllloorw", sorted);
    }
}