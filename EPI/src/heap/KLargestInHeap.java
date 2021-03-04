package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestInHeap {
    private static class HeapEntry {
        private Integer index;
        private Integer value;
        public HeapEntry (Integer index,Integer value) {
            this.index = index;
            this.value = value;
        }
    }
    private static final int DEFAULY_CAPACITY =16;
    public static List<Integer>  kLargetInBinaryHeap(List<Integer> A, int k) {
        if(k<=0) {
            return Collections.emptyList();
        }
        PriorityQueue<HeapEntry> candidateMaxHeap = new PriorityQueue<>(DEFAULY_CAPACITY, (o1,o2) -> Integer.compare(o2.value,o1.value));
        candidateMaxHeap.add(new HeapEntry(0,A.get(0)));
        List<Integer> result =  new ArrayList<>();
        for(int i=0;i<k;i++) {
            Integer candidateIndex = candidateMaxHeap.peek().index;
            result.add(candidateMaxHeap.remove().value);
            Integer leftChildIndex = 2 * candidateIndex + 1;
            if(leftChildIndex < A.size()) {
                candidateMaxHeap.add(new HeapEntry(leftChildIndex,A.get(leftChildIndex)));
            }
            Integer rightChildIndex = 2 * candidateIndex + 2;
            if(rightChildIndex < A.size()) {
                candidateMaxHeap.add(new HeapEntry(rightChildIndex, A.get(rightChildIndex)));
            }
        }

        return result;
    }
}

