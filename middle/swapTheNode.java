package  middle;

import common.ListNode;

/**
 * Created by cp
 * data  2018/9/17.
 * description
 */
public class swapTheNode {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(1);
        preHead.next = head;
        ListNode returnNode = preHead;
        while (preHead!=null && preHead.next!=null && preHead.next.next!=null) {
            ListNode currentNode = preHead.next;
            ListNode nextNode = preHead.next.next;
            ListNode tmp = nextNode.next;
            preHead.next = nextNode;
            nextNode.next = currentNode;
            currentNode.next = tmp;
            preHead = currentNode;
        }
        return returnNode.next;
    }

    public static void main(String[] args) {
        swapTheNode theNode = new swapTheNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode res = theNode.swapPairs(node7);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
