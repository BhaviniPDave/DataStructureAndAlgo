package dp;

public class MaxPointsFromCards {
        public int maxScore(int[] cardPoints, int k) {
            int frontScore = 0;
            int rearScore = 0;
            int n = cardPoints.length;

            for (int i = 0; i < k; i++) {
                frontScore += cardPoints[i];
            }

            // take all k cards from the beginning
            int maxScore = frontScore;

            // take i from the beginning and k - i from the end
            for (int i = k - 1; i >= 0; i--) {
                rearScore += cardPoints[n - (k - i)];
                frontScore -= cardPoints[i];
                int currentScore = rearScore + frontScore;
                maxScore = Math.max(maxScore, currentScore);
            }

            return maxScore;
        }
        public static void main (String[] args) {
            MaxPointsFromCards obj = new MaxPointsFromCards();
            int[] arr = {1,79,80,1,1,1,200,1};

            System.out.print(obj.maxScore(arr,3));
        }
}