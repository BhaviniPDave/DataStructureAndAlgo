package arrays;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        for(int  i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(index <= nums.length)
                nums[index] = Math.abs(nums[index]) * -1;
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static int segregateNonPositive (int[] nums){
        int j = 0;
        for (int i=0;i<nums.length;i++) {
            if(nums[i] <= 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return j;
    }


    public static int firstMissing (int[] nums) {
        int j = segregateNonPositive(nums);
        int[] nums2 = new int[nums.length - j];
        for(int i=0;i<nums2.length;i++){
            nums2[i] = nums[j];
            j++;
        }
        int res = firstMissingPositive(nums2);
        return res;
    }

    public static void main (String[] args) {
        int[] nums = {1,2,0};
        int[] input2 = {1,1};

        System.out.println(firstMissing(nums));
    }
}
