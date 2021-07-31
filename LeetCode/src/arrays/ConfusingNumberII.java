package arrays;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumberII {
    public int confusingNumberII(int n) {
        int count = 0;
        for(int i = 0;i<=n;i++){
            if(isConfusing(i))
                count ++;
        }
        return count;
    }
    private boolean isConfusing(int n) {
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
        ConfusingNumberII obj = new ConfusingNumberII();
        System.out.println(obj.confusingNumberII(100));
    }
}
