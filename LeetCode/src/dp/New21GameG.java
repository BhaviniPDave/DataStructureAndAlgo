package dp;

/**
 * Alice plays the following game, loosely based on the card game "21".
 *
 * Alice starts with 0 points and draws numbers while she has less than k points. During each draw, she gains an integer number of points randomly from the range [1, maxPts], where maxPts is an integer. Each draw is independent and the outcomes have equal probabilities.
 *
 * Alice stops drawing numbers when she gets k or more points.
 *
 * Return the probability that Alice has n or fewer points.
 *
 * Answers within 10-5 of the actual answer are considered accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10, k = 1, maxPts = 10
 * Output: 1.00000
 * Explanation: Alice gets a single card, then stops.
 * Example 2:
 *
 * Input: n = 6, k = 1, maxPts = 10
 * Output: 0.60000
 * Explanation: Alice gets a single card, then stops.
 * In 6 out of 10 possibilities, she is at or below 6 points.
 * Example 3:
 *
 * Input: n = 21, k = 17, maxPts = 10
 * Output: 0.73278
 */
public class New21GameG {
    public double new21Game(int N, int K, int W) {
        if(N >= K+W-1)
            return 1.0;
        // all possibilities of positions after alice stops playing are from [K, K+W-1]

        double p[] = new double[K+W];
        double prob = 1/(W+0.0); // single elem probability

        double prev = 0;

        p[0] = 1; // Since we start from 0, initialize it to 1

        //Until K
        for(int i = 1; i <= K; i++) {
            prev = prev - (i-W-1 >= 0 ? p[i - W -1] : 0) + p[i-1];
            p[i] = prev*prob;
        }

        double req = p[K];

        // From K+1, we don't add the p[i-1] term here as it is >= K
        for(int i = K+1; i <= N; i++) {
            prev = prev - (i-W-1 >= 0 ? p[i - W -1] : 0);
            p[i] = prev * prob;
            req += p[i];
            //System.out.println(p[i]);
        }

        return req;
    }

    public double new21GameII(int N, int K, int W) {
        if (K == 0 || N >= K + W) return 1;
        double dp[] = new double[N + 1],  Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            dp[i] = Wsum / W;
            if (i < K)
                Wsum += dp[i];
            else
                res += dp[i];
            if (i - W >= 0)
                Wsum -= dp[i - W];
        }
        return res;
    }

    public static void main (String[] args) {
        New21GameG obj = new New21GameG();
        System.out.println(obj.new21Game(21,17,10));
    }
}
