package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class TrappingWater {

    public static int calculateTrappingWater (List<Integer> heights) {
        int maxHeightIndex = heights.indexOf(Collections.max(heights));
        return trappingWaterTillEnd(heights,0,maxHeightIndex,1) + trappingWaterTillEnd(heights, heights.size()-1,maxHeightIndex , -1);
    }

    private static int trappingWaterTillEnd (List<Integer> heights,int begin, int end, int steps) {
        int sum = 0;
        int highestSeenSoFar = Integer.MIN_VALUE;
        for (int i = begin;i != end; i += steps) {
            if(heights.get(i) >= highestSeenSoFar)  {
                highestSeenSoFar = heights.get(i);
            }
            else {
                sum += highestSeenSoFar - heights.get(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> waterLevel = new ArrayList<>();
        waterLevel.add(0);
        waterLevel.add(1);
        waterLevel.add(2);
        waterLevel.add(1);
        waterLevel.add(3);
        waterLevel.add(4);
        waterLevel.add(4);
        waterLevel.add(5);
        waterLevel.add(1);
        waterLevel.add(2);
        waterLevel.add(0);
        waterLevel.add(3);
        System.out.println(calculateTrappingWater(waterLevel));
    }
}
