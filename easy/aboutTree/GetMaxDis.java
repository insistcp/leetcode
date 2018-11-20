package aboutTree;

import common.TreeNode;

/**
 * Created by cp
 * data  2018/9/10.
 * description
 */
public class GetMaxDis {
    public int maxTreeDis(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int[] depth = new int[1];
        return getMaxDepth(depth,node);
    }
    public int getMaxDepth(int[] depth,TreeNode node) {
        if (node == null) {
            depth[0] = 0;
            return 0;
        }
        int left_child_max_depth = getMaxDepth(depth,node.left);
        int leftDepth = depth[0];
        int right_child_max_depth = getMaxDepth(depth,node.right);
        int rightDepth = depth[0];
        depth[0] = Math.max(leftDepth+1,rightDepth+1);
        int max = Math.max(left_child_max_depth,right_child_max_depth);
        int returnMax = Math.max(max,(leftDepth+rightDepth+1));
        return returnMax;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(7);
        TreeNode node10 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node7.left = node8;
        node7.right = node9;
        node9.right = node10;
        GetMaxDis getMaxDis = new GetMaxDis();
        int res = getMaxDis.maxTreeDis(node1);
        System.out.println(res);
    }
}
