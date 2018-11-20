package middle.aboutTree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
* @Description: 给定一颗二叉树，让你采用之字形打印二叉树
* @Author: chenpeng
* @Date: 11:06 2018/11/20
* @param:
* @return:
*/
public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> one = new Stack<>();
        Stack<TreeNode> two = new Stack<>();
        one.add(root);
        while (!one.isEmpty() || !two.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            while (!one.isEmpty()) {
                TreeNode node = one.pop();
                list1.add(node.val);
                if (node.left != null) {
                    two.add(node.left);
                }
                if (node.right != null) {
                    two.add(node.right);
                }

            }
            if (!list1.isEmpty()) {
                res.add(list1);
            }
            List<Integer> list2 = new ArrayList<>();
            while (!two.isEmpty()) {
                TreeNode node = two.pop();
                list2.add(node.val);

                if (node.right != null) {
                    one.add(node.right);
                }
                if (node.left != null) {
                    one.add(node.left);
                }
            }
            if (!list2.isEmpty()) {
                res.add(list2);
            }
        }
        return res;
    }
}
