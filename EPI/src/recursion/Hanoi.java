package recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hanoi {

    private static final int NUM_PEGS = 3;

    public static List<List<Integer>> computeTowerOfHanoi(int numRings) {
        List<Deque<Integer>> pegs = IntStream.range(0,NUM_PEGS)
                .mapToObj(i -> new ArrayDeque<Integer>())
                .collect(Collectors.toList());

        //Initialize Pegs
        for(int i=numRings;i>=1;i--) {
            pegs.get(0).addFirst(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        computeTowerOfHanoiSteps(numRings,pegs,0,1,2,result);
        return result;
    }

    public static void computeTowerOfHanoiSteps(int numRingsToMove,List<Deque<Integer>> pegs,
                                                               int fromPeg, int toPeg, int usePeg,
                                                               List<List<Integer>> result) {
        if (numRingsToMove > 0) {
            computeTowerOfHanoiSteps(numRingsToMove - 1, pegs,fromPeg,usePeg,toPeg,result);
            pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
            result.add(List.of(fromPeg,toPeg));
            computeTowerOfHanoiSteps(numRingsToMove -1,pegs,usePeg,toPeg,fromPeg,result);

        }
    }

    public static void main(String[] args) {

    }
}
