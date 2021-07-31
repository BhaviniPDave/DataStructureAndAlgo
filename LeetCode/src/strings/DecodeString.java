package strings;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String str) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();

        String res = "";
        int index = 0;

        while (index < str.length()) {
            if(Character.isDigit(str.charAt(index))) {
                int count = 0;
                while (Character.isDigit(str.charAt(index))) {
                    count = 10 * count + (str.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            }
            else if (str.charAt(index) == '[') {
                result.push(res);
                res = "";
                index++;
            }
            else if (str.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();
                for(int i=0;i<count;i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            }
            else {
                res += str.charAt(index);
                index++;
            }
        }

        return res;
    }
    public static void main (String[] args) {
        String str = "abc3[cd]xyz";
        DecodeString obj = new DecodeString();
        System.out.println(obj.decodeString(str));
        System.out.println(obj.decodeString("3[a2[c]]"));
    }
}
