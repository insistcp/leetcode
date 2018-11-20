package classifyAlgorithm;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
* @Description: 二叉树的遍历方式
* @Author: chenpeng
* @Date: 10:40 2018/11/13
* @param:
* @return:
*/
public class treeTraversal {
    /***
     *  二叉树的先序遍历 非递归
     * @param root
     */
    public void preOrderTree(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println(root.val);
                stack.add(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pollLast();
                root = root.right;
            }
        }
    }

    /***
     *  二叉树的中序遍历：非递归
     * @param root
     */
    public void midOrderTree(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pollLast();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    /***
     * 二叉树的后序遍历： 非递归
     * @param root
     */
    public void lastOrderTree(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                list.add(0);
                root = root.left;
            }
            while (!stack.isEmpty() && list.peekLast().intValue() == 1) {
                list.pollLast();
                System.out.println(stack.pollLast().val);
            }
            if (!stack.isEmpty()) {
                list.pollLast();
                list.add(1);
                root = stack.peekLast();
                root = root.right;
            }
        }
    }

    /***
     * 层次遍历：使用两个栈
     * @param root
     */
    public void layerOrder(TreeNode root) {
        Stack<TreeNode> one = new Stack<>();
        Stack<TreeNode> two = new Stack<>();
        one.add(root);
        while (!one.isEmpty() || !two.isEmpty()) {
            while (!one.isEmpty()) {
                TreeNode node = one.pop();
                System.out.print(node.val);
                if (node.left != null) {
                    two.add(node.left);
                }
                if (node.right != null) {
                    two.add(node.right);
                }
            }
            System.out.println();
            while (!two.isEmpty()) {
                TreeNode node = two.pop();
                System.out.print(node.val);

                if (node.right != null) {
                    one.add(node.right);
                }
                if (node.left != null) {
                    one.add(node.left);
                }
            }
            System.out.println();
        }
    }




    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right  =node5;
        node3.left = node6;
        node3.right = node7;
        treeTraversal treeTraversal = new treeTraversal();
        treeTraversal.preOrderTree(node1);
        System.out.println("------------------------------------------------------------------");

        treeTraversal.midOrderTree(node1);
        System.out.println("------------------------------------------------------------------");

        treeTraversal.lastOrderTree(node1);

        System.out.println("------------------------------------------------------------------");

        treeTraversal.layerOrder(node1);
        treeTraversal.layerOrder(node1);
//        for(ArrayList<Integer> list:res) {
////            for (int tmp:list) {
////                System.out.print(tmp+" ");
////            }
////            System.out.println();
////        }
    }
}
