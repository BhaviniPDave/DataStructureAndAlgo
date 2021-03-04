package strings;

public class BalancedStringSplit {
    public static int balancedStringSplit(String s) {

        int countL = 0;
        int countR = 0;
        int countMax = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == 'L') {
                countL ++;
            }
            else if(s.charAt(i) == 'R') {
                countR ++;
            }
            if(countL == countR){
                countMax++;
                countL=0;
                countR=0;
            }
        }
        return countMax;
    }
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

}
