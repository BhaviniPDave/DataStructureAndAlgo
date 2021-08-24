package dp;

public class LongestPalindromicSubStringG {

    public String longestPalindrome(String str) {
        if(str == null || str.length() == 0)
            return "";
        int len = str.length();
        int max = 0;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0;i<len;i++) {
            for(int j = 0;j<=i;j++) {
                if(str.charAt(i) == str.charAt(j) && (i-j <= 2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                }
                if(dp[j][i] && max < i-j+1){
                    max = i-j+1;
                    start = j;
                    end = i;
                }
            }
        }
        return str.substring(start,end + 1);
    }

    public static void main (String[] args) {
        LongestPalindromicSubStringG obj = new LongestPalindromicSubStringG();
        System.out.println(obj.longestPalindrome("aaaabbaa"));
    }
}
