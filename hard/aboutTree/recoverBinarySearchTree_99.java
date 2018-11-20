package hard.aboutTree;

import common.TreeNode;

/**
* @Description:  给定一颗二叉排序树，但这棵二叉树中有两个节点的元素顺序反了，
 * 需要你将这两个元素找出来并将其恢复
* @Author: chenpeng
* @Date: 10:50 2018/11/20
* @param:
* @return:
*/
public class recoverBinarySearchTree_99 {
    private TreeNode firstMisNode = null;
    private TreeNode secondMisNode = null;
    private TreeNode preVNode = new TreeNode(Integer.MIN_VALUE);

    /***
     *  分别使用三个节点来记录节点
     *  firstNode 记录第一个逆序元素
     *  secondNode 记录第二个逆序元素
     *  preNode 记录前一个遍历的元素
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        travel(root);
        int tmp = firstMisNode.val;
        firstMisNode.val = secondMisNode.val;
        secondMisNode.val = tmp;
    }
    public void travel(TreeNode root ) {
        if (root == null){
            return;
        }
        travel(root.left);
        if (firstMisNode == null && preVNode.val >= root.val) {
            firstMisNode = preVNode;
        }
        if (firstMisNode != null && preVNode.val>=root.val) {
            secondMisNode = root;
        }
        System.out.println(root.val);
        preVNode = root;
        travel(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node3;
        node3.right = node2;
        recoverBinarySearchTree_99 binarySearchTree_99 = new recoverBinarySearchTree_99();
        binarySearchTree_99.recoverTree(node1);
        binarySearchTree_99.travelPre(node1);

    }
    public void travelPre(TreeNode root){
        if (root == null){
            return;
        }
        travelPre(root.left);
        System.out.println(root.val);
        travelPre(root.right);
    }
}
