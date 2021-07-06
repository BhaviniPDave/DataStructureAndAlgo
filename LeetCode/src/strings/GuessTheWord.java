package strings;

/**
 * 843. Guess the Word
 *
 * This is an interactive problem.
 *
 * You are given an array of unique strings wordlist where wordlist[i] is 6 letters long, and one word in this list is chosen as secret.
 *
 * You may call Master.guess(word) to guess a word. The guessed word should have type string and must be from the original list with 6 lowercase letters.
 *
 * This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word. Also, if your guess is not in the given wordlist, it will return -1 instead.
 *
 * For each test case, you have exactly 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or fewer calls to Master.guess and at least one of these guesses was secret, then you pass the test case.
 *
 *
 *
 * Example 1:
 *
 * Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"], numguesses = 10
 * Output: You guessed the secret word correctly.
 * Explanation:
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
 * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 * We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
 * Example 2:
 *
 * Input: secret = "hamada", wordlist = ["hamada","khaled"], numguesses = 10
 * Output: You guessed the secret word correctly.
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 *  */
interface Master {
      int guess(String word);
}

class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        int m = wordlist[0].length();
        int maxAttempt = 10;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            // maximize the similarity of the word we are going to guess
            String guess = getStringToGuess(wordlist, wordlist.length, m);
            int x = master.guess(guess);
            // minimize the number of words we need to guess in next round
            List<String> temp = new ArrayList<>();
            for (String w : wordlist) {
                if (match(guess, w) == x) {
                    temp.add(w);
                }
            }
            wordlist = temp.toArray(new String[temp.size()]);
        }
    }

    private String getStringToGuess(String[] wordlist, int n, int m) {
        int[][] count = new int[m][26];
        for (String w : wordlist) {
            for (int i = 0; i < m; i++) {
                count[i][w.charAt(i) - 'a']++;
            }
        }
        int highestSimilarity = 0;
        // random guess has ~80% of chance to get a word with 0 similarity wtih other words
        String guess = wordlist[new Random().nextInt(n)];
        for (String w : wordlist) {
            int similarity = 0;
            for (int i = 0; i < m; i++) {
                similarity += count[i][w.charAt(i) - 'a'];
            }
            if (similarity > highestSimilarity) {
                highestSimilarity = similarity;
                guess = w;
            }
        }
        return guess;
    }

    private int match(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return 0;
        }
        int match = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                match++;
            }
        }
        return match;
    }
}
