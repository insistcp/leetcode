package middle.aboutTree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**
* @Description: 给定一颗二叉树，以及一个数字现在让找出这棵二叉树中所有路径和位给定数字的组合；
* @Author: chenpeng
* @Date: 10:36 2018/11/22
* @param:
* @return:
*/
public class PathSumII_113 {
    private int curr;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        getAllCombination(res, new ArrayList<>(), root, sum);
        return res;
    }

    /***
     *  注意这里找到之后，记得将最后一个元素移除，总体的和减
     * @param res
     * @param list
     * @param root
     * @param sum
     */
    public void getAllCombination(List<List<Integer>> res ,List<Integer> list,TreeNode root,int sum) {
        if (root == null) {
            return;
        }
        curr+=root.val;
        list.add(root.val);
        if (sum == curr && root.right == null && root.left == null) {
            res.add(new ArrayList<>(list));
            curr-=root.val;
            list.remove(list.size()-1);
            return;
        }
        getAllCombination(res, list, root.left, sum);
        getAllCombination(res, list, root.right, sum);
        curr-=root.val;
        list.remove(list.size()-1);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node10;
        node6.right = node9;
        PathSumII_113 pathSumII_113 = new PathSumII_113();
        List<List<Integer>> res = pathSumII_113.pathSum(node1, 22);
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
