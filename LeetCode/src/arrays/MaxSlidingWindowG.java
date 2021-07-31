package arrays;

import java.util.ArrayDeque;

public class MaxSlidingWindowG {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    public int[] maxSlidigWindow(int[] nums, int k) {
        int n = nums.length;
        if(n * k == 0)
            return new int[0];
        if(k == 1)
            return nums;

        int[] output = new int[n- k + 1];
        int max_index = 0;
        for(int i=0;i<k;i++) {
            cleanDeque(nums,i,k);
            deq.addLast(i);
            if(nums[i] > nums[max_index])
                max_index = i;
        }
        output[0] = nums[max_index];
        for(int i = k;i<n;i++) {
            cleanDeque(nums,i,k);
            deq.addLast(i);
            output[i-k+1] = nums[deq.getFirst()];
        }
        return output;
    }
    private void cleanDeque(int[] nums, int i, int k) {
        // remove indexes of elements not from sliding window
        if(!deq.isEmpty() && deq.getFirst() == i-k) {
            deq.removeFirst();
        }
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }

    public static void main (String[] args) {
        MaxSlidingWindowG obj = new MaxSlidingWindowG();
        int[] nums = {1,3,-1,-3,5,3,6,7};

        int[] output = obj.maxSlidigWindow(nums, 3);
        for (int i:output) {
            System.out.println(i);
        }
    }
}
