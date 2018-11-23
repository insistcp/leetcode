package middle.aboutTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
/**
* @Description:  给定一颗带有next节点的二叉树，现在让你将这颗二叉树进行转换：
 * 按照完全二叉树的标准：最左边如果有节点，依次从最左边开始连接右边最近邻的节点如果右边最近邻的节点为null则停止
* @Author: chenpeng
* @Date: 11:03 2018/11/23
* @param:
* @return:
*/
public class PopulatingNextRightPointersInEachNode_116 {
    /***
     *  类似于层次遍历，
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null ) {
            return;
        }
        TreeLinkNode pre  = root;
        TreeLinkNode curr = null;
        while(pre.left != null) {
            curr = pre;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            pre = pre.left;
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
        PopulatingNextRightPointersInEachNode_116 rightPointersInEachNode_116 = new PopulatingNextRightPointersInEachNode_116();
        rightPointersInEachNode_116.connect(node1);
        System.out.println(node1.val);

    }
}
class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}
