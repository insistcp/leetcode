package middle.aboutTree;

import common.ListNode;
import common.TreeNode;

/**
* @Description: 将一个有序链表转化为一颗二叉排序树
* @Author: chenpeng
* @Date: 10:31 2018/11/21
* @param:
* @return:
*/
public class convertSortedListToBinarySearchTree_109 {
    /***
     *  通过设置额外的节点，以及链表的长度，来构造二叉搜索树；
     *  时间复杂度：O(1) 空间复杂度O(n)
     *  额外的头结点用来记录遍历的进度；
     */
    private ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        this.head = head;
        int len = 0;
        ListNode iter = head;
        while (iter != null) {
            len++;
            iter = iter.next;
        }

        return contructTreeFromChain(len);
    }

    private TreeNode contructTreeFromChain(int len) {
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            TreeNode root = new TreeNode(head.val);
            head = head.next;
            return root;
        }
        int mid = len/2;
        TreeNode left  = contructTreeFromChain(mid);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        TreeNode right = contructTreeFromChain(len-mid-1);
        root.left = left;
        root.right = right;
        return root;
    }
    private TreeNode helper (int len) {
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            TreeNode root = new TreeNode(head.val);
            head = head.next;
            return root;
        }

        int mid = len / 2;
        TreeNode left = helper(mid);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        TreeNode right = helper(len - mid - 1);
        root.left = left;
        root.right = right;
        return root;
    }
    /***
     * 时间复杂度 O(n)空间复杂度O（n）
     * @param head
     * @return
     */
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode thead = head;
        int size = getSize(thead);
        thead = head;
        int[] vals = new int[size];
        int index = 0;
        while (thead != null) {
            vals[index++] = thead.val;
            thead = thead.next;
        }
        TreeNode res = constructTree(vals,0,size-1);
        return res;
    }
    public int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    public TreeNode constructTree(int[] vals, int start,int end) {
        if (start>end) {
            return null;
        }
        int mid = (start+end)/2;
        if ((start+end)%2 == 1) {
            mid =(start+end+1)/2;
        }
        TreeNode node = new TreeNode(vals[mid]);
        node.left = constructTree(vals,start,mid-1);
        node.right = constructTree(vals,mid+1,end);
        return node;
    }
    public void travel(TreeNode head) {
        if (head == null) {
            return;
        }
        travel(head.left);
        System.out.println(head.val);
        travel(head.right);
    }
    //-10,-3,0,5,9
    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        convertSortedListToBinarySearchTree_109 binarySearchTree_109 = new convertSortedListToBinarySearchTree_109();
        TreeNode node = binarySearchTree_109.sortedListToBST(node1);
        binarySearchTree_109.travel(node);
    }

}
