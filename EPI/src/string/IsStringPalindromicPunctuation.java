package string;

public class IsStringPalindromicPunctuation {
    public static void main (String[] args) {
        System.out.println(isPalindrome("A man,a plan,a canal, Panama"));
        System.out.println(isPalindrome("Able was I,ere I saw Elba!"));
        System.out.println(isPalindrome("Ray a Ray"));
    }
    public static boolean isPalindrome(String s) {
        //i moves forward. and j moves backward
        int i=0, j=s.length() -1;
        while (i < j) {
            //i and j both skip alphanumeric characters.
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j){
                ++i;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j){
                --j;
            }
            if (Character.toLowerCase(s.charAt(i++)) !=
                Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }
}

