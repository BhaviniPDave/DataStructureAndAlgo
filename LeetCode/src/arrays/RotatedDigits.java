package arrays;

import java.util.Arrays;
import java.util.HashSet;

public class RotatedDigits {
    public int rotatedDigits(int n) {
        HashSet<Integer> rotateDiff = new HashSet<>(Arrays.asList(2, 5, 6, 9));
        HashSet<Integer> rotateInvalid = new HashSet<>(Arrays.asList(3, 4, 7));
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            int diffCount = 0, iCopy = i;
            boolean flag = true;
            while (iCopy > 0) {
                int bit = iCopy % 10;
                if (rotateInvalid.contains(bit)) {
                    flag = false;
                    break;
                }
                if (rotateDiff.contains(bit)) {
                    diffCount++;
                    System.out.println(bit);
                }
                iCopy /= 10;
            }
            if (flag && diffCount > 0) {
                ret++;
            }
        }

        return ret;
    }

    public static void main (String[] args) {
        RotatedDigits obj = new RotatedDigits();
        System.out.println(obj.rotatedDigits(20));
    }
}
