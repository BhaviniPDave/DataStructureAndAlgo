package strings;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a)); //create a max heap here

        for(int i = 0; i < stones.length; i++) { //iterate through stones array, then add each stone into maxHeap
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size() > 1) {
            int firstStone = maxHeap.remove(); //remove the biggest element
            int secondStone = maxHeap.remove(); //remove the second biggest element
            if(firstStone!=secondStone) {  //take the bigger stone - smaller stone
                maxHeap.add(firstStone-secondStone);
            }

        }
        return maxHeap.isEmpty() ? 0 : maxHeap.remove(); //if heap has one or lesser elements, return 0 or the leftover element
    }
    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(arr));
    }

}
