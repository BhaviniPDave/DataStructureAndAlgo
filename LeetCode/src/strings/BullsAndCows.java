package strings;

import java.util.HashMap;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> h = new HashMap();

        int bulls = 0, cows = 0;
        int n = guess.length();
        for (int idx = 0; idx < n; ++idx) {
            char s = secret.charAt(idx);
            char g = guess.charAt(idx);
            if (s == g) {
                bulls++;
            } else {
                if (h.getOrDefault(s, 0) < 0)
                    cows++;
                if (h.getOrDefault(g, 0) > 0)
                    cows++;
                h.put(s, h.getOrDefault(s, 0) + 1);
                h.put(g, h.getOrDefault(g, 0) - 1);
            }
        }

        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }

    public static void main (String[] args) {
        BullsAndCows obj = new BullsAndCows();
        System.out.println((obj.getHint("1807","7810")));
    }
}
