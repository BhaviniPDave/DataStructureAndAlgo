package string;

/**
 * <1,11,21,1211,111221,312211,13112221,1113213211,..>
 */
public class LookAndSay {
    public static void main(String [] args) {
        System.out.println(lookAndSay(8));
    }
    public static String lookAndSay(int n) {
        String s = "1";
        for (int i=1;i<n;i++) {
            s = nextNumber(s);
        }
        return s;
    }
    private static String nextNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            int count = 1;
            while ( i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                ++i;
                ++count;
            }
            sb.append(count).append(s.charAt(i));
        }
        return sb.toString();
    }
}
