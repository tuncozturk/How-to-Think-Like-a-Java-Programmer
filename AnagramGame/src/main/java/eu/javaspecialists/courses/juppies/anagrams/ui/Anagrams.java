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

package eu.javaspecialists.courses.juppies.anagrams.ui;

import eu.javaspecialists.courses.juppies.anagrams.lib.*;

import javax.swing.*;
import java.awt.event.*;

public class Anagrams extends JFrame {
    private JPanel contentPane;
    private JButton guess;
    private JButton newWord;
    private JTextField scrambledWord;
    private JTextField yourGuess;
    private JLabel progress;
    private JLabel feedbackLabel;

    private int wordIdx = -1;
    private final WordLibrary wordLibrary =
            WordLibraries.createDefaultWordLibrary();

    public Anagrams() {
        setContentPane(contentPane);
        pack();

        guess.addActionListener(new GuessActionListener());
        newWord.addActionListener(new NewWordActionListener());
        newWord();
    }

    private void guess() {
        if (wordLibrary.isCorrect(wordIdx, yourGuess.getText())) {
            feedbackLabel.setText("Correct! Try a new word!");
            getRootPane().setDefaultButton(newWord);
        } else {
            feedbackLabel.setText("Incorrect! Try again!");
            yourGuess.setText("");
        }
        yourGuess.requestFocusInWindow();
    }

    private void newWord() {
        wordIdx = (wordIdx + 1) % wordLibrary.getSize();
        scrambledWord.setText(wordLibrary.getScrambledWord(wordIdx));

        progress.setText("%d/%d".formatted(wordIdx + 1, wordLibrary.getSize()));
        feedbackLabel.setText("");
        yourGuess.setText("");
        yourGuess.requestFocusInWindow();
        getRootPane().setDefaultButton(guess);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Anagrams frame = new Anagrams();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    private class GuessActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            guess();
        }
    }

    private class NewWordActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            newWord();
        }
    }
}
