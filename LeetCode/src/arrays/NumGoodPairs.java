package arrays;

public class NumGoodPairs {

    public static int numIdenticalPairs(int[] nums) {

        int j=1;
        int i=0;
        int count= 0;
        while(i<=j) {
            if(j==nums.length) {
                i++;
                j=i+1;
            }

            if(j<nums.length && nums[i]==nums[j]){
                count++;
            }
            j++;
            if(i==nums.length-1)
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input  = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(input));
    }


}
