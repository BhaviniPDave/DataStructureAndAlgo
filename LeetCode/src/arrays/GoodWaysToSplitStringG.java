package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1525. Number of Good Ways to Split a String
 *
 * You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q where its concatenation is equal to s and the number of distinct letters in p and q are the same.
 *
 * Return the number of good splits you can make in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aacaba"
 * Output: 2
 * Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
 * ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: 1
 * Explanation: Split the string as follows ("ab", "cd").
 *
 * Example 3:
 *
 * Input: s = "aaaaa"
 * Output: 4
 * Explanation: All possible splits are good.
 * Example 4:
 *
 * Input: s = "acbadbaada"
 * Output: 2
 */
public class GoodWaysToSplitStringG {
    public int numSplits(String str) {
        Map<Character,Integer> leftMap = new HashMap<>();
        Map<Character,Integer> rightMap = new HashMap<>();
        for(int i = 0 ; i<str.length() ; i++) {
            rightMap.put(str.charAt(i), rightMap.getOrDefault(str.charAt(i),0)+1);
        }
        int res = 0;
        for(int i = 0 ; i<str.length() ; i++) {
            char s = str.charAt(i);
            leftMap.put(s, leftMap.getOrDefault(s,0)+1);
            if(rightMap.get(s) == 1) {
                rightMap.remove(s);
            } else {
                rightMap.put(s, rightMap.get(s)-1);
            }
            if(leftMap.size() == rightMap.size()) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GoodWaysToSplitStringG obj = new GoodWaysToSplitStringG();
        System.out.println(obj.numSplits("acbadbaada"));
    }
}
