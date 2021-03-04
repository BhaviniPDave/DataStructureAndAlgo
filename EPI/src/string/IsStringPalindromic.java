package string;

public class IsStringPalindromic {
    public static void main(String args[]){
        IsStringPalindromic oobj = new IsStringPalindromic();
        System.out.println(oobj.isPalindromic("abcdcba"));
        System.out.println(oobj.isPalindromic("abccba"));
        System.out.println(oobj.isPalindromic("ba"));

    }

    public boolean isPalindromic(String str){
        for(int i=0, j= str.length() - 1;i<j;i++,j--){
            if(str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }
}
