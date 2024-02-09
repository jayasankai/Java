/*
We are building a word processor and we would like to implement a "word-wrap" functionality.

Given a list of words followed by a maximum number of characters in a line, return a collection of strings where each string element represents a line that contains as many words as possible, with the words in each line being concatenated with a single '-' (representing a space, but easier to see for testing). The length of each string must not exceed the maximum character length per line.

Your function should take in the maximum characters per line and return a data structure representing all lines in the indicated max length.

Examples:

words1 = [ "The", "day", "began", "as", "still", "as", "the",
          "night", "abruptly", "lighted", "with", "brilliant",
          "flame" ]

wrapLines(words1, 13) "wrap words1 to line length 13" =>

  [ "The-day-began",
    "as-still-as",
    "the-night",
    "abruptly",
    "lighted-with",
    "brilliant",
    "flame" ]

wrapLines(words1, 12) "wrap words1 to line length 12" =>

  [ "The-day",
    "began-as",
    "still-as-the",
    "night",
    "abruptly",
    "lighted-with",
    "brilliant",
    "flame" ]    


wrapLines(words1, 20) "wrap words1 to line length 20" =>

  [ "The-day-began-as",
    "still-as-the-night",
    "abruptly-lighted",
    "with-brilliant-flame" ]

words2 = [ "Hello" ]

wrapLines(words2, 5) "wrap words2 to line length 5" =>

  [ "Hello" ]


wrapLines(words2, 30) "wrap words2 to line length 30" =>

  [ "Hello" ]  

words3 = [ "Hello", "Hello" ]

wrapLines(words3, 5) "wrap words3 to line length 5" =>

  [ "Hello",
  "Hello" ]

words4 = ["Well", "Hello", "world" ]

wrapLines(words4, 5) "wrap words4 to line length 5" =>

  [ "Well",
  "Hello",
  "world" ]

words5 = ["Hello", "HelloWorld", "Hello", "Hello"]

wrapLines(words5, 20) "wrap words 5 to line length 20 =>

  [ "Hello-HelloWorld",
    "Hello-Hello" ]


words6 = [ "a", "b", "c", "d" ]
wrapLines(words6, 20) "wrap words 6 to line length 20 =>

  [ "a-b-c-d" ]

wrapLines(words6, 4) "wrap words 6 to line length 4 =>

  [ "a-b",
    "c-d" ]

wrapLines(words6, 1) "wrap words 6 to line length 1 =>

  [ "a",
    "b",
    "c",
    "d" ]

All Test Cases:
          words,  max line length
wrapLines(words1, 13)
wrapLines(words1, 12)
wrapLines(words1, 20)
wrapLines(words2, 5)
wrapLines(words2, 30)
wrapLines(words3, 5)
wrapLines(words4, 5)
wrapLines(words5, 20)
wrapLines(words6, 20)
wrapLines(words6, 4)
wrapLines(words6, 1)

n = number of words OR total characters



*/
package com.jayasanka.atlasian;

import java.util.ArrayList;
import java.util.List;

public class WrapLines {
  public static void main(String[] argv) {
    
    String[] words1 = {"The","day","began","as","still","as","the","night","abruptly","lighted","with","brilliant","flame"};
    String[] words2 = {"Hello"};
    String[] words3 = {"Hello", "Hello"};
    String[] words4 = {"Well", "Hello", "world"};
    String[] words5 = {"Hello", "HelloWorld", "Hello", "Hello"};
    String[] words6 = {"a", "b", "c", "d"};
    
    // REad the array of string
    // get the lenth of each word and apend one work to next until the total length <= max_length
    // once the lenth exceed the max_length, then we add the new string to new array and moved to next string in the given array
    
    String[] finalArray = wrapLines(words1, 20);
    
    for (String word : finalArray) {
      System.out.println(word);
    }

  }
  
  private static String[] wrapLines(String[] words, int maxLength) {
    List<String> resultArr = new ArrayList<String>();
    
    String newString = "";
    String testString = "";
    for (int i = 0; i < words.length; i++ ) {
      testString = newString + "-" + words[i];
      
       // System.out.println(testString);
      
      if ((testString.substring(1).length() <= maxLength)) {
        newString = newString + "-" + words[i];
        if (i == words.length -1) {
          resultArr.add(newString.substring(1));
        }
      } else {
        resultArr.add(newString.substring(1));
        newString ="";
        i--;
      }
    }
    
    return resultArr.toArray(new String[0]);
    
  }
}
