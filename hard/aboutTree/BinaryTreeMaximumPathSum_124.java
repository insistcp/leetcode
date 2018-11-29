package hard.aboutTree;

import common.TreeNode;
/**
* @Description: 给定一颗二叉树，现在让返回这颗二叉树的最大路径和；
 * 路径的起点和终点可以为任意节点
* @Author: chenpeng
* @Date: 9:58 2018/11/29
* @param:
* @return:
*/
public class BinaryTreeMaximumPathSum_124 {
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return maxPath;
        }
        getMaxPath(root,0);
        return maxPath;
    }

    /***
     *  递归遍历：对于每一个节点首先将其当做根节点，寻找以它为根的最大路径，其次将其当做父节点的子节点：既最终返回路径中一个子集
     * @param root
     * @param curr
     * @return
     */
    public int getMaxPath(TreeNode root,int curr) {
        if (root == null) {
            return 0;
        }
        int leftSum = getMaxPath(root.left,root.val);
        int rightSum = getMaxPath(root.right,root.val);
        int returnV = root.val;
        int sum = root.val;
        if (leftSum>0) {
            if (leftSum>rightSum) {
                returnV+=leftSum;
            }
            sum+=leftSum;
        }
        if (rightSum>0) {
            if (rightSum>leftSum) {
                returnV+=rightSum;
            }
            sum+=rightSum;
        }
        if (sum>maxPath){
            maxPath = sum;
        }

        return returnV>0?returnV:0;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BinaryTreeMaximumPathSum_124 maximumPathSum_124 = new BinaryTreeMaximumPathSum_124();
        int res = maximumPathSum_124.maxPathSum(node1);
        System.out.println(res);

    }
}
