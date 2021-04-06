package string;

/**
 * Replace all a's with two d's and remove all b's.
 *
 */
public class ReplaceAndRemove {
    public static void main(String[] args) {
        char[] ch = {'a','c','d','b','b','c','a'};
        System.out.println(replaceAndRemove(7,ch));
    }
    public static int replaceAndRemove(int size, char[] s) {
        //Forward iteration: remove b's and count the number of a's
        int writeIndex = 0;
        int aCount = 0;
        for (int i=0;i<size;i++) {
            if(s[i] != 'b')
                s[writeIndex ++] = s[i];
            if (s[i] == 'a')
                aCount ++;
        }
        //Backward iteration: replace a's with dd's starting from the end.
        int curIdx = writeIndex - 1;
        writeIndex = writeIndex + aCount -1;
        final int finalSize = writeIndex +1;
        while (curIdx >= 0) {
            if (s[curIdx] == 'a'){
                s[writeIndex --] = 'd';
                s[writeIndex --] = 'd';
            }
            else {
                s[writeIndex -- ] = s[curIdx];
            }
            --curIdx;
        }
        return finalSize;
    }
}
