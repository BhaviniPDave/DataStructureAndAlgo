package strings;

/**
 * Largest Substring Between Two Equal Characters
 *
 * Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.
 * A substring is a contiguous sequence of characters within a string.
 *
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two 'a's.
 *
 * Input: s = "abca"
 * Output: 2
 * Explanation: The optimal substring here is "bc".
 *
 * Input: s = "cabbac"
 * Output: 4
 * Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".
 */
public class LargestSubStringBtnTwoEqualChars {
    public int maxLengthBetweenEqualCharacters(String s) {

        int result = -1;
        for(int i=0;i<s.length();i++){
            result = Math.max(result,s.lastIndexOf(s.charAt(i))-i-1);
        }
        return result;
    }
    public static void main (String[] args) {
        LargestSubStringBtnTwoEqualChars obj = new LargestSubStringBtnTwoEqualChars();
        System.out.println(obj.maxLengthBetweenEqualCharacters("cabbac"));
    }
}
