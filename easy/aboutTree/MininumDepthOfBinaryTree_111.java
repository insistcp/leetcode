package aboutTree;

import common.TreeNode;
/**
* @Description:  给定一颗二叉树，让你求这颗二叉树的最低高度；
* @Author: chenpeng
* @Date: 11:16 2018/11/21
* @param:
* @return:
*/
public class MininumDepthOfBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = getMinDepth(root);
        return depth;
    }
    public int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getMinDepth(root.left);
        int rightDepth = getMinDepth(root.right);
        if (leftDepth == 0) {
            return rightDepth+1;
        }
        if (rightDepth == 0){
            return leftDepth+1;
        }
        return Math.min(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node1.right = node4;
        node4.right = node5;
        MininumDepthOfBinaryTree_111 binaryTree_111 = new MininumDepthOfBinaryTree_111();
        int depth = binaryTree_111.minDepth(node1);
        System.out.println(depth);
    }
}
