package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    List<String> combinations = new ArrayList<>();
    Map<Character, String> letters = new HashMap<>();
    String phoneDigits;
    public List<String> letterCombinations(String digits) {
        letters.put('2',"abc");
        letters.put('3',"def");
        letters.put('4',"ghi");
        letters.put('5',"jkl");
        letters.put('6',"mno");
        letters.put('7',"pqrs");
        letters.put('8',"tuv");
        letters.put('9',"wxyz");

        if(digits.length() == 0)
            return combinations;

        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int index, StringBuilder path) {
        if(path.length() == phoneDigits.length()){
            combinations.add(path.toString());
            return;
        }
        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for(char letter: possibleLetters.toCharArray()) {
            path.append(letter);
            backtrack(index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main (String[] args) {
        LetterCombinations obj = new LetterCombinations();
        List<String> letterCombinations = obj.letterCombinations("23");
        for(String str: letterCombinations) {
            System.out.println(str);
        }
    }
}
