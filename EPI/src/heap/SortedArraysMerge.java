package heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortedArraysMerge {

    private static  class ArrayEntry {
        public Integer value;
        public Integer arrayId;

        public ArrayEntry (Integer value, Integer arrayId) {
            this.value =  value;
            this.arrayId = arrayId;
        }
    }

    public static List<Integer> mergeSortedArrays (List<List<Integer>> sortedArrays)  {
        List<Iterator<Integer>> iter = new ArrayList<>(sortedArrays.size());
        for  (List<Integer> array: sortedArrays) {
            iter.add(array.iterator());
        }

        PriorityQueue<ArrayEntry>  minHeap = new PriorityQueue<>(
                sortedArrays.size(), (o1,o2) -> Integer.compare(o1.value,o2.value)
        );

        for (int i=0;i<iter.size();i++) {
            if(iter.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iter.get(i).next(),i));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);
            if(iter.get(headEntry.arrayId).hasNext()) {
                minHeap.add(new ArrayEntry(iter.get(headEntry.arrayId).next(),headEntry.arrayId));
            }
        }

        return result;
    }
}
