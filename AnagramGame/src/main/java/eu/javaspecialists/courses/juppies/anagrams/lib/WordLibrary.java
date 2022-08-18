/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/* Anagram Game Application */

package eu.javaspecialists.courses.juppies.anagrams.lib;

/**
 * Word library defining logic for the Anagram Game application.
 */
public sealed interface WordLibrary permits
        ScrambledWordLibrary, ShuffledWordLibrary, StaticWordLibrary {
    /**
     * Gets the word at a given index.
     *
     * @param idx index of required word
     * @return word at that index in its natural form
     */
    String getWord(int idx);

    /**
     * Gets the word at a given index in its scrambled form.
     *
     * @param idx index of required word
     * @return word at that index in its scrambled form
     */
    String getScrambledWord(int idx);

    /**
     * Gets the number of words in the library.
     *
     * @return the total number of plain/scrambled word pairs in the library
     */
    int getSize();

    /**
     * Checks whether a user's guess for a word at the given index is correct.
     *
     * @param idx       index of the word guessed
     * @param userGuess the user's guess for the actual word
     * @return true if the guess was correct; false otherwise
     */
    default boolean isCorrect(int idx, String userGuess) {
        return userGuess.equals(getWord(idx));
    }
}
