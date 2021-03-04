package heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KClosetStars {

    private static class Star implements Comparable<Star> {
        private double x,y,z;
        public Star(double x, double y,double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public double distance () {
            return Math.sqrt(x*x*y*y*z*z);
        }
        @Override
        public int compareTo(Star o) {
            return Double.compare(this.distance(),o.distance());
        }
    }

    public static List<Star> findKClosetStars (Iterator<Star> stars,int k) {
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        while (stars.hasNext()) {
            Star star = stars.next();
            maxHeap.add(star);
            if(maxHeap.size() == k+1){
                maxHeap.remove();
            }
        }
        return Stream.generate(maxHeap :: remove).limit(maxHeap.size()).collect(Collectors.toList());
    }
}
