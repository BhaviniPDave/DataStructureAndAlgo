package strings;

import java.util.Stack;

public class LongestAbsoluteFilePathG {
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        Stack<String> path = new Stack();
        int maxLength = 0, currLength = 0;
        for(String part : parts) {
            String[] tabSplits = part.split("\t");
            int curTabSpaces = tabSplits.length - 1;
            // in case we are too deep in some directory, we need to move back, analogus to cd..
            while(path.size() > curTabSpaces)
                currLength -= (path.pop().length() + 1);

            String dir = tabSplits[tabSplits.length - 1];
            currLength += (dir.length() + 1); // adding 1 for / in final result

            // in case dir is a file!
            if(dir.contains(".")) { maxLength = Math.max(currLength, maxLength); }
            path.push(dir);
        }

        return Math.max(maxLength - 1, 0);
    }

    public static void main (String[] args) {
        LongestAbsoluteFilePathG obj = new LongestAbsoluteFilePathG();
        String str1 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String str2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        System.out.println(obj.lengthLongestPath(str1));
        System.out.println(obj.lengthLongestPath(str2));

    }
}
