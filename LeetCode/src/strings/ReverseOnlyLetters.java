package strings;

/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 * Input: "ab-cd"
 * Output: "dc-ba"
 *
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 *
 * Input: "Test1ng-Leet==code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 *
 */

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String str) {
        char[] strArray = str.toCharArray();
        int start = 0;
        int end = str.length() -1;
        while (start < end) {
            if(!Character.isLetter(strArray[start]))
                start++;
            else if(!Character.isLetter(strArray[end]))
                end--;
            else {
                char temp = strArray[start];
                strArray[start] = strArray[end];
                strArray[end] = temp;
                start++;
                end--;
            }
        }
        return new String(strArray);
    }

    public static void main (String[] args) {
        ReverseOnlyLetters obj = new ReverseOnlyLetters();
        System.out.println(obj.reverseOnlyLetters("Test1ng-Leet==code-Q!"));
    }
}
