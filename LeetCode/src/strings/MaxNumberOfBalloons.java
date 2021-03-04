package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 * Example 1:
 * Input: text = "nlaebolko"
 * Output: 1
 *
 * Example 2:
 * Input: text = "loonbalxballpoon"
 * Output: 2
 *
 * Example 3:
 * Input: text = "leetcode"
 * Output: 0
 */
public class MaxNumberOfBalloons {

    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxCount = 0;
        maxCount = map.getOrDefault('l', 0) / 2;
        maxCount = Math.min(map.getOrDefault('o', 0) / 2, maxCount);
        maxCount = Math.min(map.getOrDefault('b', 0), maxCount);
        maxCount = Math.min(map.getOrDefault('a', 0), maxCount);
        maxCount = Math.min(map.getOrDefault('n', 0), maxCount);
        return maxCount;
    }


    public static void main (String[] args) {
//        System.out.println(maxNumberOfBalloons("nlaebolko"));
//        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoo"));


    }
}
