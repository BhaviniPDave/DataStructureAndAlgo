package heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAlmostSortedArray {

    public static List<Integer> sortApproximateSortedData(Iterator<Integer> sequence, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //Adds first k elements into min Heap. Stop if there are less then k elements.
        for(int i=0;i< k && sequence.hasNext();i++){
            minHeap.add(sequence.next());
        }
        List<Integer> result = new ArrayList<>();
        while (sequence.hasNext()) {
            minHeap.add(sequence.next());
            Integer minElement = minHeap.remove();
            result.add(minElement);
        }
        //sequence is exhausted, iteratively extracts remaining elements
        result.addAll(Stream.generate(
                minHeap:: remove
        ).limit(minHeap.size()).collect(Collectors.toList()));
        return  result;
    }
}
