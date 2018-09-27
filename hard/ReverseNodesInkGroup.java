package leetcodeAgain.hard;

import ReviewDataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cp
 * data  2018/9/17.
 * title:25. Reverse Nodes in k-Group
 * description
 *
 */
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode tNode = head;
        int len = getSize(tNode);
        if(k == len){
            return reverse(head);
        }
        if (len<k) {
            return head;
        }
        boolean isAddLast = false;
        if (len%k == 0) {
            isAddLast = true;
        }
        List<ListNode> list = new ArrayList<>();
        while (tNode !=null){
            list.add(tNode);
            for(int i = 1;i<k;i++) {
                if (tNode == null) {
                    break;
                }
                tNode = tNode.next;
            }
            if (tNode == null) {
                break;
            }
            ListNode tmp = tNode.next;
            tNode.next = null;
            tNode = tmp;
        }
        int size = list.size();
        ListNode preNode = null;
        ListNode returnNode = null;
        for (int i = 0;i<size-1;i++) {
            ListNode node = list.get(i);
            ListNode resNode = reverse(list.get(i));
            if (preNode == null) {
                returnNode = resNode;
            } else {
                preNode.next = resNode;
            }
            preNode = node;
        }
        if (isAddLast) {
            preNode.next = reverse(list.get(size-1));
        } else {
            preNode.next = list.get(size-1);
        }
        return returnNode;
    }
    public int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    public ListNode reverse(ListNode node){
         ListNode currentNode = node;
         ListNode firstNode = node;
         ListNode nextNode = currentNode.next;
         while (currentNode != null && nextNode != null) {
             ListNode tmp = nextNode.next;
             firstNode.next = tmp;
             nextNode.next = currentNode;
             currentNode = nextNode;
             nextNode = tmp;
         }
         return currentNode;
    }

    public static void main(String[] args) {
        ReverseNodesInkGroup reverseNodesInkGroup = new ReverseNodesInkGroup();
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
        ListNode res = reverseNodesInkGroup.reverseKGroup(node6,2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

