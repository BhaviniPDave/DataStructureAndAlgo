package arrays;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber {
    public boolean confusingNumber(int n) {
        int originalNumber = n;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        int ans = 0;
        while(n != 0) {
            int digit = n % 10;
            if(!map.containsKey(digit))
                return false;
            ans = ans * 10 + map.get(digit);
            n = n / 10;
        }

        if(ans != originalNumber)
            return true;
        return false;
    }

    public static void main (String[] args) {
        ConfusingNumber obj = new ConfusingNumber();
        System.out.println(obj.confusingNumber(6));
    }
}
