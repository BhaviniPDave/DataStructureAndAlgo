package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. Find and Replace Pattern
 *
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 *
 */
public class FindAndReplacePattern {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word: words)
            if (match(word, pattern))
                ans.add(word);
        return ans;
    }

    private static boolean match (String word,String pattern) {
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0;i< word.length();i++) {
            char wChar = word.charAt(i);
            char pChar = pattern.charAt(i);
            if(!map.containsKey(wChar))
                map.put(wChar,pChar);
            if(map.get(wChar) != pChar)
                return false;
        }

        boolean []  seen = new boolean[26];

        for(Character p: map.values())  {
            if(seen[p - 'a'])
                return false;

            seen[p - 'a'] = true;
        }
        return true;
    }

    public static void main (String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        List<String> ans = findAndReplacePattern(words,"abb");

    }
}
