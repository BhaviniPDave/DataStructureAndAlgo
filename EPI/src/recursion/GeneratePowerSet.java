package recursion;

import java.util.ArrayList;
import java.util.List;

public class GeneratePowerSet {
    public List<List<Integer>> generatePowerSet(List<Integer> nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        for(int i = 0;i< (1 << nums.size()) ;i++) {
            int bitArray = i;
            List<Integer> subSet = new ArrayList<>();
            while (bitArray != 0) {
                subSet.add(nums.get((int) ((Math.log(bitArray & ~(bitArray -1)))/Math.log(2))));
                bitArray &= bitArray - 1;
            }
            powerSet.add(subSet);
        }
        return powerSet;
    }
    public List<List<Integer>> generatePowerSetII(List<Integer> nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        directedPowerSet(nums,0,new ArrayList<Integer>(),powerSet);
        return powerSet;
    }
    private void directedPowerSet(List<Integer> inputSet,int toBeSelected,List<Integer> selectedSoFar,List<List<Integer>> powerSet) {
        if(toBeSelected == inputSet.size()) {
            powerSet.add(new ArrayList<>(selectedSoFar));
            return;
        }

        //Generate all subsets that contain inputSet[toBeSlected]
        selectedSoFar.add(inputSet.get(toBeSelected));
        directedPowerSet(inputSet,toBeSelected + 1, selectedSoFar, powerSet);
        //Generate all subsets that do not contain inputSet[toBeSlected]
        selectedSoFar.remove(selectedSoFar.size() - 1);
        directedPowerSet(inputSet, toBeSelected + 1, selectedSoFar, powerSet);


    }

    public static void main(String[] args) {
        GeneratePowerSet obj = new GeneratePowerSet();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> result = obj.generatePowerSetII(list);
        for(List<Integer> res: result){

        }
    }
}
