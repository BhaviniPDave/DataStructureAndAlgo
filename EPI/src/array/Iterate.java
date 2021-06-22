package array;

import java.util.HashSet;
import java.util.Iterator;

public class Iterate {
    public static void main (String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        Iterator<Integer> itr = set.iterator();
        while( itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
