package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 */
public class SubSetWithDuplicate {
    /**
     * Intuition
     *
     * Assume the given array has no duplicate elements. In this case, there will be a total of 2 ^ n2
     * n
     *   distinct subsets. To find all the subsets we start with an empty subset. This will be the first subset. Next, we consider one element at a time and add it to each of the existing subsets. This can be better understood in the following animation:
     *   However, in this problem, the given array can have duplicate elements which will produce duplicate subsets if we follow the previously mentioned approach. Thus, we need to omit the duplicate subsets. For this, we need to sort the given array first. To avoid adding duplicate subsets we follow this rule:
     *
     * Whenever the element under consideration has duplicates, we add one of the duplicate elements to all the existing subsets to create new subsets. For the rest of the duplicates, we only add them to the subsets created in the previous step. By convention, whenever a value is encountered for the first time, we add it to all the existing subsets. Then onwards we add its duplicates only to the subsets created in the previous step.
     *
     * In other words, we treat a group of duplicate elements as an array. Suppose we have an array [3, 3, 3]. The ways to add the elements from this array to the existing subsets are as follows:
     *
     * Not add any element having value 3 in any subset.
     *
     * Add one 3 in all the subsets.
     *
     * Add two 3 in all the subsets.
     *
     * Add three 3 in all the subsets.
     *
     * This can be better understood with the following animation:
     * Algorithm
     *
     * First, sort the array in ascending order.
     *
     * Initialize a variable subsetSize to 0. subsetSize holds the index of the subset in the subsets list from where we should start adding the current element if the current element is a duplicate. In other words, it holds the index of the first subset generated in the previous step.
     *
     * Iterate over the nums array considering one element at a time.
     *
     * If we haven't seen the value of the current element before, we need to add this element to all the previously generated subsets. So set startingIndex to 0.
     *
     * If the current element is a duplicate element, add it only to subsets that were created in the previous iteration. This means we will skip every subset that was created earlier than the previous iteration. So instead of setting startingIndex to 0, set it equal to subsetSize.
     *
     * Set subsetSize to the current subsets size. This will be the starting index of the subsets generated in this iteration.
     *
     * Add the current element to all the subsets in the subsets list created before the current iteration starting from startingIndex.
     *
     * Return subsets list.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());

        int subsetSize = 0;

        for (int i = 0; i < nums.length; i++) {
            int startingIndex = (i >= 1 && nums[i] == nums[i - 1]) ? subsetSize : 0;
            // subsetSize refers to the size of the subset in the previous step. This value also indicates the starting index of the subsets generated in this step.
            subsetSize = subsets.size();
            for (int j = startingIndex; j < subsetSize; j++) {
                List<Integer> currentSubset = new ArrayList<>(subsets.get(j));
                currentSubset.add(nums[i]);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }
    public static void main(String[] args) {
        SubSetWithDuplicate obj = new SubSetWithDuplicate();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> result = obj.subsetsWithDup(new int[]{1,2,2});
        for(List<Integer> res: result){

        }
    }


}
