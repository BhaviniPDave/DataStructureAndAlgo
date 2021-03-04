package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class NumberOfScoreCombinations {

    public static  int numCombinationsForFinalScore(int finalScore, List<Integer> individualPlayScores) {
        int[][] numCombinationsForScore = new int[individualPlayScores.size()][finalScore +1];
        for(int i=0;i<individualPlayScores.size();i++) {
            numCombinationsForScore[i][0] = 1;
            for (int j=1;j<=finalScore;j++) {
                int withoutThisPlay = (i-1) >=0?numCombinationsForScore[i-1][j]:0;
                int withThisPlay = j>=individualPlayScores.get(i)?numCombinationsForScore[i][j-individualPlayScores.get(i)]:0;
                numCombinationsForScore[i][j] = withoutThisPlay + withThisPlay;
            }
        }
        return numCombinationsForScore[individualPlayScores.size()-1][finalScore];
    }

    public static void main(String[] args) {
        List<Integer> individualPlayScores = new ArrayList<>();
        individualPlayScores.add(2);
        individualPlayScores.add(3);
        individualPlayScores.add(7);
        System.out.println(numCombinationsForFinalScore(12,individualPlayScores));
    }
}
