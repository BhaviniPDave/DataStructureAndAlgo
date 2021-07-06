package strings;

import java.util.*;

/**
 * 127. Word Ladder
 *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 *
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        int changes = 1;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Queue<String> visited = new LinkedList<>();
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            for(int i=0;i<queue.size();i++) {
                String word = queue.poll();
                if(word.equals(endWord)) return changes;

                for(int j =0;j< word.length();j++) {
                    for(int k = 'a' ;k<= 'z';k++) {
                        char[] arr = word.toCharArray();

                        arr[j] = (char)k;
                        String str = new String(arr);
                        if(set.contains(str) && !visited.contains(str)) {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            ++changes;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        // For forward BFS
        Set<String> dictStart = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        start.add(beginWord);
        dictStart.remove(beginWord); // We remove from dict for faster lookups and so that we dont come back at same element

        // For backward BFS
        Set<String> dictEnd = new HashSet<>(wordList);
        Set<String> end = new HashSet<>();
        if(!dictEnd.contains(endWord)){
            return 0;
        }
        end.add(endWord);
        dictEnd.remove(endWord);

        int forwardSteps = 1;
        int backSteps = 1;
        while(!start.isEmpty()&&!end.isEmpty()){
            start = getNext(dictStart, start);
            if(!start.isEmpty()) { // This means that the 1 step is taken in forward direction
                forwardSteps++;
            }
            if(isIntersecting(start, end)) {
                return forwardSteps+backSteps-1;
            }

            end = getNext(dictEnd, end);
            if(!end.isEmpty()) { // This means that the 1 step is taken in backward direction
                backSteps++;
            }
            if(isIntersecting(end, start)) {
                return forwardSteps+backSteps-1;
            }
        }
        return 0;
    }

    private Set<String> getNext(Set<String> dict, Set<String> inQueue) {
        Set<String> next = new HashSet<>();
        for(String s: inQueue) {
            char[] sArray = s.toCharArray();
            for(int i=0;i<s.length();i++){ // For all the chars we flip the character and see if its present in the dict
                char cur = sArray[i];
                for(char j='a';j<='z';j++){
                    sArray[i]= j;
                    String newStr = String.valueOf(sArray);
                    if(dict.contains(newStr)){
                        next.add(newStr);
                        dict.remove(s);
                    }
                }
                sArray[i] = cur;
            }
        }
        return next;
    }

    private boolean isIntersecting(Set<String> start, Set<String> end) {
        for(String s: start) {
            if(end.contains(s)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordLadder obj = new WordLadder();
        List<String> words = new ArrayList<>();
        words.add("ted");
        words.add("tex");
        words.add("red");
        words.add("tax");
        words.add("tad");
        words.add("den");
        words.add("rex");
        words.add("pee");

        System.out.println(obj.ladderLength2("red","tax",words));
    }
}
