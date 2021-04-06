package string;

import java.util.Map;

/**
 * I,V,X,L,C,D,M
 * I -> 1
 * V -> 5
 * X -> 10
 * L -> 50
 * C -> 100
 * D -> 500
 * M -> 1000
 */
public class RomanToInteger {
    public static void main (String[] args) {
        System.out.println(romanToInteger("IC"));
    }
    public static int romanToInteger (String s) {
        Map<Character,Integer> T = Map.of('I',1,'V',5,'X',10,'C',100,'D',500,'M',1000);
        int sum = T.get(s.charAt(s.length() -1));
        for (int i =s.length() -2;i>=0;--i) {
            if(T.get(s.charAt(i)) < T.get(s.charAt(i+1))) {
                sum -= T.get(s.charAt(i));
            }
            else {
                sum += T.get(s.charAt(i));
            }
        }
        return sum;
    }
}
