package middle;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
* @Description: 给定一颗二叉树：假设从根节点到叶子结点构成一个数组，现在让你计算这棵二叉树可以构成的所有数字之和
* @Author: chenpeng
* @Date: 10:50 2018/10/15  
* @param: 
* @return:  
*/  
public class SumRootToLeafNumbers_129 {
    /**
    * @Description:  采用递归的方式，每次累加计算
    * @Author: chenpeng
    * @Date: 11:33 2018/10/15
    * @param:
    * @return:
    */
    public int sumNumbers(TreeNode root) {
        return getAllCombine(root,0,0);
    }
    public int getAllCombine(TreeNode root, int res ,int sum) {
        if (root == null) {
          return res;
        }
        sum =  sum*10+root.val;
        if (root.left==null  && root.right == null ) {
           res += sum;
        } else {
            res = getAllCombine(root.left, res, sum);
            res = getAllCombine(root.right, res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        //[4,9,0,null,1]
        int[] res = {4,9,0,5,1};
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        SumRootToLeafNumbers_129 toLeafNumbers_129 =  new SumRootToLeafNumbers_129();
        int res1 = toLeafNumbers_129.sumNumbers(node1);
        System.out.println(res1);
    }
}
