package arrays;

public class SplitArrayLargestSumG {
    /**
     * 1: The answer is between maximum value of input array numbers and sum of those numbers.
     * 2: Use binary search to approach the correct answer. We have l = max number of array; r = sum of all numbers in the array;Every time we do mid = (l + r) / 2;
     * 3: Use greedy to narrow down left and right boundaries in binary search.
     * 3.1 Cut the array from left.
     * 3.2 Try our best to make sure that the sum of numbers between each two cuts (inclusive) is large enough but still less than mid.
     * 3.3 We'll end up with two results: either we can divide the array into more than m subarrays or we cannot.
     * If we can, it means that the mid value we pick is too small because we've already tried our best to make sure each part holds as many non-negative numbers as we can but we still have numbers left. So, it is impossible to cut the array into m parts and make sure each parts is no larger than mid. We should increase m. This leads to l = mid + 1;
     * If we can't, it is either we successfully divide the array into m parts and the sum of each part is less than mid, or we used up all numbers before we reach m. Both of them mean that we should lower mid because we need to find the minimum one. This leads to r = mid - 1;
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        long l = 0;
        long r = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            r += nums[i];
            if (l < nums[i]) {
                l = nums[i];
            }
        }
        long ans = r;
        while (l <= r) {
            long mid = (l + r) >> 1;
            long sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt ++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (cnt <= m) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        SplitArrayLargestSumG obj = new SplitArrayLargestSumG();
        int [] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(obj.splitArray(nums,m));
    }
}
