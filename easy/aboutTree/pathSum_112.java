package aboutTree;

import common.TreeNode;
/**
* @Description:  给定一颗二叉树，以及一个数字，
 * 让你判断这颗二叉树上面是否存在一条路径使得这条路径（根节点到叶子结点）的和等与这个数字
* @Author: chenpeng
* @Date: 11:49 2018/11/21
* @param:
* @return:
*/
public class pathSum_112 {
    boolean isHasPath = false;
    int TSum ;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        this.TSum = sum;
        isHasPath(root,0);
        return isHasPath;
    }
    public void isHasPath(TreeNode root,int val){
        if(root == null) {
            return ;
        }
        TSum =TSum-root.val;
        if (TSum == 0 && root.left == null && root.right == null) {
            isHasPath =  true;
            return;
        }
        isHasPath(root.left,root.val);
        isHasPath(root.right,root.val);
        if (isHasPath) {
            return;
        }
        TSum =TSum+root.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(-4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(-1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.right = node9;
        pathSum_112 pathSum_112 = new pathSum_112();
        boolean res = pathSum_112.hasPathSum(node6,-5);
        System.out.println(res);
    }
}
