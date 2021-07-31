package strings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 833. Find And Replace in String
 *
 * You are given a 0-indexed string s that you must perform k replacement operations on.
 * The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.
 *
 * To complete the ith replacement operation:
 *
 * Check if the substring sources[i] occurs at index indices[i] in the original string s.
 * If it does not occur, do nothing.
 * Otherwise if it does occur, replace that substring with targets[i].
 * For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee",
 * then the result of this replacement will be "eeecd".
 *
 * All replacement operations must occur simultaneously,
 * meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will not overlap.
 *
 * For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"]
 * will not be generated because the "ab" and "bc" replacements overlap.
 * Return the resulting string after performing all replacement operations on s.
 *
 * A substring is a contiguous sequence of characters in a string.
 * Example 1:
 * Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
 * Output: "eeebffff"
 * Explanation:
 * "a" occurs at index 0 in s, so we replace it with "eee".
 * "cd" occurs at index 2 in s, so we replace it with "ffff".
 *
 * Example 2:
 * Input: s = "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation:
 * "ab" occurs at index 0 in s, so we replace it with "eee".
 * "ec" does not occur at index 2 in s, so we do nothing.
 *
 * Solution:
 * The main thing here to note is that if we replace a substring, then the indexing of remaining original charaters to
 * the right of that replacement would change, and hence any future operation to the right of the substring
 * won't point to the correct index.
 * So, what can we do? We can do the operation from right to left.
 * In this way no future operations will be affected by current change.
 * So we first store the source and target based on indices in hashmaps and sort the indices array.
 * Then from right to left we traverse the indices array and make replacement in the original string if necessary.
 */
public class FindAndReplaceInStringG {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, String> sourceIndex = new HashMap<>();
        HashMap<Integer, String> targetIndex = new HashMap<>();
        for(int i=0; i<indices.length; i++){
            sourceIndex.put(indices[i], sources[i]);
            targetIndex.put(indices[i], targets[i]);
        }
        Arrays.sort(indices);
        StringBuilder str = new StringBuilder(s);
        for(int i=indices.length-1; i>=0; i--){
            int index = indices[i];
            String source = sourceIndex.get(index);
            StringBuilder target = new StringBuilder(targetIndex.get(index));
            if(str.substring(index, index+source.length()).toString().equals(source)){
                str = new StringBuilder(str.substring(0, index)).append(target).append(new StringBuilder(str.substring(index+source.length())));
            }
        }
        return str.toString();
    }

    public static void main (String[] args) {
        FindAndReplaceInStringG obj = new FindAndReplaceInStringG();
        String s = "abcd";
        int[] indices = {0,2};
        String[] sources = {"a","cd"};
        String[] targets = {"eee","ffff"};
        System.out.println(obj.findReplaceString(s,indices,sources,targets));
    }
}
