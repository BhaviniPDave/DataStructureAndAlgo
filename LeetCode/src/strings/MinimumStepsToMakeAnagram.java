package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 1347. Minimum Number of Steps to Make Two Strings Anagram
 * Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 *
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * Example 3:
 *
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 * Example 4:
 *
 * Input: s = "xxyyzz", t = "xxyyzz"
 * Output: 0
 * Example 5:
 *
 * Input: s = "friend", t = "family"
 * Output: 4
 *
 */
public class MinimumStepsToMakeAnagram {

    public static int minSteps(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for(char ch: s.toCharArray()) {
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        for(char ch: t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        int counter = 0;
        for(char ch: sMap.keySet()) {
            if(tMap.containsKey(ch)){
                int diff = sMap.get(ch) - tMap.get(ch);
                counter += diff >0 ?diff:0;
            }
            else if (!tMap.containsKey(ch))
                counter += sMap.get(ch);
        }
        return counter;

    }


    public static void main(String[] args) {
        System.out.println(minSteps("bab","aba"));
        System.out.println(minSteps("leetcode","practice"));
        System.out.println(minSteps("xxyyzz","xxyyzz"));
        System.out.println(minSteps("friend","family"));

    }
}
