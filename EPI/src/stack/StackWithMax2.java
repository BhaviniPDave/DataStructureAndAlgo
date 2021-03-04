package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMax2 {

    private static class Stack  {
        private Deque<Integer> stackMax = new ArrayDeque<>();
        private Deque<Integer> stackElement = new ArrayDeque<>();

        public boolean isEmpty() {
            return stackElement.isEmpty();
        }

        public Integer pop () {
            int element =  stackElement.removeFirst();
            if(stackMax.peekFirst() == element)
                stackMax.removeFirst();
            return element;
        }

        public Integer max() {
            return stackMax.peekFirst();
        }

        public void  push (Integer x) {
            if(stackMax.isEmpty() || x > stackMax.peekFirst())
                stackMax.addFirst(x);
            stackElement.addFirst(x);
        }
    }

    public static void  main (String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.max());

        System.out.println(stack.pop());
        System.out.println(stack.max());

        System.out.println(stack.pop());
        System.out.println(stack.max());

    }
}
