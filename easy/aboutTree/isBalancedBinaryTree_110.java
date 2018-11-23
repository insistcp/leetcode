package aboutTree;

import common.TreeNode;
/**
* @Description: 给定一颗二叉树，让你判断这颗二叉树是否是一颗平衡二叉树
* @Author: chenpeng
* @Date: 10:58 2018/11/21
* @param:
* @return:
*/
public class isBalancedBinaryTree_110 {
    private boolean isBa=true;
    public boolean isBalanced(TreeNode root,int dtp) {
       if(root == null){
           return true;
       }
       GetCent(root,0);
       return isBa;
    }
    public int GetCent(TreeNode root,int depth) {
        if (root == null) {
            return 0;
        }
        int leftDepth = GetCent(root.left,depth);
        int rightDepth = GetCent(root.right,depth);
        if (Math.abs(leftDepth-rightDepth)>1) {
            isBa = false;
        }
        return Math.max(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
    }
}
