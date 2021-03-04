package strings;

public class UpperToLower {

    public static String toLower(String str) {
        String result = "";
        char ch = ' ';
        for (int i=0;i< str.length();i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                ch = (char) (str.charAt(i) + 32);
            }
            else {
                ch = str.charAt(i);
            }
            result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(toLower("ABCDabcd"));
    }

}
