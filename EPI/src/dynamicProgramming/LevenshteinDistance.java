package dynamicProgramming;

import java.util.Arrays;

public class LevenshteinDistance {

    public static int  levenshteinDistance (String A, String B) {
     int[][] distanceBetweenPrefixes = new int[A.length()][B.length()];
     for (int[] row: distanceBetweenPrefixes) {
         Arrays.fill(row,-1);
     }
     return computeDistanceBetweenPrefixes(A,A.length()-1,B,B.length() -1, distanceBetweenPrefixes);
    }

    public static int computeDistanceBetweenPrefixes (String A, int aIdx, String B, int bIdx, int[][] distanceBetweenPrefixes){
        if (aIdx < 0) {
            return bIdx  +1; //A is empty so add all of B's Characters
        }
        else if(bIdx <  0) {
            //B is empty, delete all of  A's characters
            return aIdx +1;
        }
        if (distanceBetweenPrefixes[aIdx][bIdx] == -1) {
            if(A.charAt(aIdx) == B.charAt(bIdx)) {
                distanceBetweenPrefixes[aIdx][bIdx] = computeDistanceBetweenPrefixes(A,aIdx -1, B, bIdx -1, distanceBetweenPrefixes);
            }
            else {
                int substitueLast = computeDistanceBetweenPrefixes(A,aIdx-1,B,bIdx-1,distanceBetweenPrefixes);
                int addLast = computeDistanceBetweenPrefixes(A,aIdx,B,bIdx-1,distanceBetweenPrefixes);
                int deleteLast = computeDistanceBetweenPrefixes(A,aIdx-1,B,bIdx,distanceBetweenPrefixes);
                distanceBetweenPrefixes[aIdx][bIdx] = 1 + Math.min(substitueLast,Math.min(addLast,deleteLast));
            }
        }
        return distanceBetweenPrefixes[aIdx][bIdx];
    }

    public static void main (String[] args) {
        System.out.println(levenshteinDistance("Carthorse","Orchestra"));
    }
}
