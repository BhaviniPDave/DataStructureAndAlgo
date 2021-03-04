package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMax {
    private static class ElementWithCachedMax {
        public Integer element;
        public Integer max;
        public  ElementWithCachedMax (Integer element, Integer max) {
            this.element = element;
            this.max = max;
        }
    }

    public  static class  Stack  {
        private Deque<ElementWithCachedMax> elementWithCachedMaxes = new ArrayDeque<>();
        public boolean isEmpty() {
            return elementWithCachedMaxes.isEmpty();
        }

        public Integer pop () {
            return elementWithCachedMaxes.removeFirst().element;
        }

        public Integer max() {
            return elementWithCachedMaxes.peekFirst().max;
        }

        public void  push (Integer x) {
            elementWithCachedMaxes.addFirst(new ElementWithCachedMax(x, Math.max(x,isEmpty()?x:max())));
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
        System.out.println(stack.pop());
        System.out.println(stack.max());
        System.out.println(stack.pop());
        System.out.println(stack.max());

    }
}
