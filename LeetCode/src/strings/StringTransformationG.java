package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Problem:

1153. String Transforms Into Another String
Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.

Return true if and only if you can transform str1 into str2.

Example 1:

Input: str1 = "aabcc", str2 = "ccdee"
Output: true
Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
Example 2:

Input: str1 = "leetcode", str2 = "codeleet"
Output: false
Explanation: There is no way to transform str1 to str2.

Solution:

Following are few observations:

All occurences of a character can only be transformed to a single unique character.
From above observation, if a character needs to be transformed to more than 1 unique character then transformation is not possible.
Two different characters can be transformed to same character but not vice-versa. i.e. a->c & b-> c is allowed, but NOT a->c & a->b.
In case of a circular dependency, such as "ab" -> "ba" which has transformations as a-> b and b-> a, we can use some other english character to perform intermediary transformations. Example: a-> x, b->a, x->b . Here 'x' is an intermediary character. Now this can be achieved only when we have an available intermediary character out of 26 lower case english letters. Meaning, there shouldn't be any other transformation case for 'x' else condition 3 will not be met.
Algorithm:

Iterate through str1 and str2, character by character
For any character in str1 create a transformation mapping for character at same index in str2. While doing this check if there already exists a transformation for same character in str1 for a different character in str2. If it exists, return false as condition 3 in above mentioned observations is not met.
If we exit the loop without returning then it means we a 1 to 1 mapping for all the characters in str1 to str2. But we need to care for circular dependency as stated in 4th observation above. Example: "abcdefghijklmnopqrstuvwyz" -> "bcadefghijklmnopqrstuvwzz". If there's at-least 1 available character from str2, that can be used in intermediary transformations, then return true else false.
 */
public class StringTransformationG {
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2))
            return true;
        Set<Character> exhaustedChars = new HashSet<>();
        Map<Character, Character> charTransformationMap = new HashMap<>();

        int n = str1.length();
        for(int i=0;i<n;i++){
            char fromChar = str1.charAt(i);
            char toChar = str2.charAt(i);
            if(charTransformationMap.containsKey(fromChar)){
                if(charTransformationMap.get(fromChar) != toChar)
                    return false;
            }else{
                charTransformationMap.put(fromChar, toChar);
                exhaustedChars.add(toChar);
            }
        }
        return exhaustedChars.size() < 26;
    }
}
