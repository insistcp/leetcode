package middle.aboutTree;

import java.util.Deque;
import java.util.LinkedList;

/**
* @Description:  给定一颗带有next节点的二叉树，现在让你将这颗二叉树进行转换：
 *  依次从最左边开始连接右边近邻的节点；
* @Author: chenpeng
* @Date: 11:03 2018/11/23
* @param:
* @return:
*/
public class PopulatingNextRightPointersInEachNodeII_116 {
    /***
     * 本质上还是层次遍历：新增一个节点，每次讲这个节点指向每一层的第一个节点；
     * @param root
     */
    public void connect(TreeLinkNode root) {
        TreeLinkNode firstPoint = new TreeLinkNode(0);
        TreeLinkNode pre = firstPoint;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                root = firstPoint.next;
                pre = firstPoint;
                firstPoint.next = null;
            }
        }
    }


    /***
     *  层次遍历
     * @param root
     */
    public void connect1(TreeLinkNode root) {
        if (root == null ) {
            return;
        }
        Deque<TreeLinkNode> one = new LinkedList<>();
        Deque<TreeLinkNode> two = new LinkedList<>();
        one.add(root);
        while (!one.isEmpty() || !two.isEmpty()) {
            TreeLinkNode preNode = null;
            while (!one.isEmpty()) {
                TreeLinkNode node = one.pop();
                if (preNode == null) {
                    preNode = node;
                } else {
                    preNode.next = node;
                    preNode = node;
                }
                if (node.left!=null) {
                    two.add(node.left);
                }
                if (node.right!=null) {
                    two.add(node.right);
                }


            }
            preNode = null;
            while (!two.isEmpty()) {
                TreeLinkNode node = two.poll();
                if (preNode == null) {
                    preNode = node;
                } else {
                    preNode.next = node;
                    preNode = node;
                }
                if (node.left!=null) {
                    one.add(node.left);
                }
                if (node.right!=null) {
                    one.add(node.right);
                }



            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        PopulatingNextRightPointersInEachNodeII_116 rightPointersInEachNode_116 = new PopulatingNextRightPointersInEachNodeII_116();
        rightPointersInEachNode_116.connect(node1);
        System.out.println(node1.val);

    }
}

