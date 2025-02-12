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
    if (word.length() == 0) {
      return word;
    } else {
      for (int i = 0; i < word.length() - 1; i++) {
        if (word.substring(i, i + 1).equals("A") && !word.substring(i + 1, i + 2).equals("A")) {
          String firstHalf;
          String secondHalf;
          if ((i != 0) && (i + 2 != word.length() - 1)) {
            firstHalf = word.substring(0, i);
            secondHalf = word.substring(i + 2);
            word = firstHalf + word.substring(i + 1, i + 2) + word.substring(i, i + 1) + secondHalf;
          } else if (i != 0) {
            firstHalf = word.substring(0, i);
            word = firstHalf + word.substring(i + 1, i + 2) + word.substring(i, i + 1);
          } else if (i + 2 != word.length() - 1) {
            secondHalf = word.substring(i + 2);
            word = word.substring(i + 1, i + 2) + word.substring(i, i + 1) + secondHalf;
          } else {
            word = word.substring(i + 1, i + 2) + word.substring(i, i + 1);
          }
          i++;
         
        }
      }
      return word;
    }
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
    ArrayList<String> list = new ArrayList<String>();  
    for (String string : wordList) {
        if (scrambleWord(string) != string) {
          list.add(scrambleWord(string));
        }
      }
      return list;
  }
}