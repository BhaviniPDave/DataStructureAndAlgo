package arrays;

public class NumArrayImmutable {
    private int[] nums;
    public NumArrayImmutable (int[] nums) {
        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
        }
        this.nums = nums;
    }
    public int sumRange(int start, int end){
        if(start == 0)
            return nums[end];
        return nums[end] - nums[start - 1];
    }

    public static void main (String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArrayImmutable obj = new NumArrayImmutable(nums);
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(0,5));
        System.out.println(obj.sumRange(2,5));

    }
}
