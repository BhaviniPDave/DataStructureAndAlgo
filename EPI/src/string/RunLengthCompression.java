package string;

/**
 * "aaaabcccaa" -> "4a1b3c2a" (Encoding)
 * "3e4f2e" -> "eeeffffee" (Decoding)
 */
public class RunLengthCompression {
    public static void main (String[] args) {
        System.out.println(decoding("3e4f2e"));
        System.out.println(encoding("aaaabcccaa"));
    }
    public static String decoding(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                count = count * 10 + c - '0';
            }
            else { //c is a letter or alphabet
                while (count > 0) { //Appends count copies of c to result
                    result.append(c);
                    count --;
                }
            }
        }
        return result.toString();
    }

    public static String encoding (String s) {
        int count =1;
        StringBuilder result = new StringBuilder();
        for (int i=1;i<=s.length();i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i-1)){
                //Found new character so write the count of previous character.
                result.append(count).append(s.charAt(i-1));
                count = 1;
            }
            else { // s.charAt(i) == s.charAt(i-1)
                count ++;
            }
        }
        return result.toString();
    }
}
