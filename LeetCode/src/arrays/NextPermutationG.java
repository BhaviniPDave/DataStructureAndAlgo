package arrays;

public class NextPermutationG {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >=0 && nums[i+1] <= nums[i]) {
            i--;
        }

        if(i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse (int[] nums, int start) {
        int i = start;
        int j = nums.length;
        while(i < j) {
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main (String[] args) {
        NextPermutationG obj = new NextPermutationG();
        int [] nums = {};
        obj.nextPermutation(nums);
        System.out.println(nums);
    }

}
