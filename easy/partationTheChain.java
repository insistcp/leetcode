
import common.ListNode;

import java.util.Collections;

/**
 * Created by cp
 * data  2018/9/11.
 * description
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */
public class partationTheChain {
    public ListNode partition(ListNode head, int x) {
        if (head == null  ) {
            return head;
        }
        ListNode thead = head;
        ListNode tPreNode = head;
        while (thead != null) {
            if (thead.val >= x) {
                break;
            }
            tPreNode  = thead;
            thead = thead.next;
        }
        ListNode preNode = thead;
        if (thead == head) {
            ListNode returnNode = null,tmpNode = null;
            ListNode pNode = thead;
            while (thead != null){
                if (thead.val < x) {
                    pNode.next = thead.next;
                    if (returnNode == null){
                        returnNode = thead;
                        tmpNode = thead;
                    } else {
                        tmpNode.next = thead;
                        tmpNode = tmpNode.next;
                        tmpNode.next = null;
                        thead = pNode.next;
                    }
                } else {
                    pNode = thead;
                    thead = thead.next;
                }


            }
            if (tmpNode != null) {
                tmpNode.next = preNode;
            }

            returnNode = returnNode==null?head:returnNode;
            return returnNode;
        } else {

            ListNode nextNode = thead;
            while (thead != null){
                if (thead.val < x) {
                    preNode.next  = thead.next;
                    tPreNode.next = thead;
                    tPreNode = tPreNode.next;
                } else {
                    preNode = thead;
                }

                thead = thead.next;
            }
            if (tPreNode != nextNode) {
                tPreNode.next = nextNode;
            }

        }

        return head;
    }
    public ListNode partation(ListNode head,int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prefixNode = new ListNode(0);
        prefixNode.next = head;
        ListNode tNode = prefixNode;
        while (tNode.next !=null && tNode.next.val<x) {
            tNode = tNode.next;
        }
        ListNode preNode  = tNode.next;
        while (preNode != null && preNode.next != null) {
            if (preNode.next.val >=x) {
                preNode = preNode.next;
                continue;
            }
            ListNode currNode = preNode.next;
            preNode.next = currNode.next;
            currNode.next = tNode.next;
            tNode.next = currNode;
            tNode = tNode.next;
        }
        return  prefixNode.next;
    }
    //1->4->3->2->5->2
    //[4,4,1,1,0,0,3,2,1,3,1,1,2]
     //       3
    //[1,3,-1,5,2,1]
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(0);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(1);
        ListNode node10 = new ListNode(3);
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(1);
        ListNode node13 = new ListNode(2);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        partationTheChain theChain = new partationTheChain();
        ListNode res = theChain.partation(node5,3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
