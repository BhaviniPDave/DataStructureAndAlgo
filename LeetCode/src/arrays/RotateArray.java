package arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};

        obj.rotate(nums, 3);
        System.out.println(nums);

    }
}
