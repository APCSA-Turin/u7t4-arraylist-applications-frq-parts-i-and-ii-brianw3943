package com.example.project.WordScramble;
import java.util.ArrayList;
public class WordScramble {
  /** Scrambles a given word.
   *
   *  @param word  the word to be scrambled
   *  @return  the scrambled word (possibly equal to word)
   *
   *  Precondition: word is either an empty string or contains only uppercase letters.
   *  Postcondition: the string returned was created from word as follows:
   *  - the word was scrambled, beginning at the first letter and continuing from left to right
   *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
   *  - letters were swapped at most once
   */
  public static String scrambleWord(String word) {
    ArrayList<String> wordAsList = new ArrayList<>();
    String word2 = "";
    for (int i = 0; i < word.length(); i++) {
      wordAsList.add(word.substring(i, i + 1));
    }
    for (int i = 0; i < word.length() - 1; i++) {
      if (word.substring(i, i + 1).equalsIgnoreCase("a")) {
        if (!word.substring(i + 1, i + 2).equalsIgnoreCase("a")) {
          wordAsList.add(i, wordAsList.remove(i + 1));
        }
      }
    }
    for (int i = 0; i < wordAsList.size(); i++) {
      word2 += wordAsList.get(i);
    }
    word = word2;
    return word;
  }


  /** Modifies wordList by replacing each word with its scrambled
   *  version, removing any words that are unchanged as a result of scrambling.
   *
   *  @param wordList the list of words
   *
   *  Precondition: wordList contains only non-null objects
   *  Postcondition:
   *  - all words unchanged by scrambling have been removed from wordList
   *  - each of the remaining words has been replaced by its scrambled version
   *  - the relative ordering of the entries in wordList is the same as it was
   *    before the method was called
   */
  public static ArrayList<String> scrambleOrRemove(ArrayList<String> wordList) {
    for (int i = 0; i < wordList.size(); i++) {
      int count = 0;
      for (int j = 0; j < wordList.get(i).length(); j++) {
        if (wordList.get(i).substring(j, j + 1).equals(scrambleWord(wordList.get(i)).substring(j, j + 1))) {
          count++;
        }
      }
      if (count == wordList.get(i).length()) {
        wordList.remove(i);
        i--;
      }
    }
    for (int i = 0; i < wordList.size(); i++) {
      wordList.set(i, scrambleWord(wordList.get(i)));
    }
    return wordList;
  }
}