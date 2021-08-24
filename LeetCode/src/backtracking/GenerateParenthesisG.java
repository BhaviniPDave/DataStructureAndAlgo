package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesisG {
    List<String> output =new ArrayList<>();
    public void parenthesis(String current, int start,int end, int max)
    {
        if(current.length()==2*max)
        {
            output.add(current);
            return;
        }
        if(start<max)
            parenthesis(current+"(",start+1,end,max);
        if(end<start)
            parenthesis(current+")",start,end+1,max);
    }
    public List<String> generateParenthesis(int n) {
        // using backtracking for this problem

        parenthesis("",0,0,n);
        return output;
    }

    public static void main (String[] args) {
        GenerateParenthesisG obj = new GenerateParenthesisG();
        List<String> result = obj.generateParenthesis(3);
        for(String str: result) {
            System.out.println(str);
        }
    }
}
