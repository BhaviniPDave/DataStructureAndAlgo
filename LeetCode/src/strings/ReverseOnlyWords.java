package strings;

import java.util.Stack;
/**
 * 151. Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Example 4:
 *
 * Input: s = "  Bob    Loves  Alice   "
 * Output: "Alice Loves Bob"
 * Example 5:
 *
 * Input: s = "Alice does not even like bob"
 * Output: "bob like even not does Alice"
 */
public class ReverseOnlyWords {

    public static String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        String[] rev=s.trim().split(" ");
        int n=rev.length;
        if(n==1 || n==0){
            return s;
        }
        for(int i=n-1;i>0;i--){
            if(rev[i].trim().isEmpty()){
                continue;
            }
            sb.append(rev[i]);
            sb.append(" ");
        }
        sb.append(rev[0]);
        return sb.toString();
    }

    public static String reverseWordsUsingStack(String s) {
        Stack<String> st = new Stack<String>();
        StringBuilder sb  = new StringBuilder();

        // Store the whole String
        // in String stream
        String[] ss = s.split(" ");

        for (String temp : ss)
        {
            // Push each word of the
            // String into the stack
            if(!temp.equals(""))
                st.add(temp);
        }

        // Print the String in reverse
        // order of the words
        while (!st.isEmpty())
        {
           sb.append(st.peek() + " ");
            st.pop();
        }
        sb.substring(0,sb.length()-2);
        return sb.substring(0,sb.length()-2);
    }

    public static String reverseWordsInPlace(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        for(int j=0; j<arr.length; j++){
            if(arr[j]==' '){
                reverse(arr, i, j-1);
                i=j+1;
            }
        }
        reverse(arr, i, arr.length-1);

        reverse(arr, 0, arr.length-1);

        return arr.toString();
    }

    private static void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }

    public static void main (String[] args) {
        System.out.println(reverseWordsInPlace("a good   example"));
    }
}
