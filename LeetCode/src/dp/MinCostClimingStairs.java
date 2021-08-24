package dp;

public class MinCostClimingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length + 1];
        for(int i=2;i< memo.length;i++) {
            int oneStepCost  = cost[i-1] + memo[i-1];
            int twoStepCost = cost[i-2] + memo[i-2];
            memo[i] = Math.min(oneStepCost, twoStepCost);
        }
        return memo[memo.length - 1];
    }

    public static void main (String[] args) {
        MinCostClimingStairs obj = new MinCostClimingStairs();
        int[] costs = {10,15,20};
        System.out.println(obj.minCostClimbingStairs(costs));
    }
}
