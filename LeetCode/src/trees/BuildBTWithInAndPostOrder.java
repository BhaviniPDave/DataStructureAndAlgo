package trees;

import java.util.HashMap;
import java.util.Map;

public class BuildBTWithInAndPostOrder {

    int postIndex;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        if(inorder.length != postorder.length)
            return null;

        if(postorder.length == 1)
            return new TreeNode(postIndex);

        for(int i=0;i< inorder.length;i++) {
            map.put(inorder[i],i);
        }

        return helper(inorder,postorder,0,inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int leftIndex, int rightIndex) {

        if(leftIndex > rightIndex)
            return null;

        TreeNode root = new TreeNode(postorder[postIndex]);

        int index = map.get(postorder[postIndex]);
        postIndex --;

        root.right = helper(inorder,postorder,index + 1,rightIndex);
        root.left = helper(inorder, postorder,leftIndex, index - 1);

        return root;

    }

    public static void main (String[] args) {
        BuildBTWithInAndPostOrder obj = new BuildBTWithInAndPostOrder();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode ans = obj.buildTree(inorder,postorder);
    }
}
