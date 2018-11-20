package middle.aboutChain;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
/**
* @Description:  给定一个链表以及一个数字X，现在让你改变这个链表使得链表中小于X的节点出现在X前面并且不改变节点的相对顺序；
* @Author: chenpeng
* @Date: 10:31 2018/11/8
* @param:
* @return:
*/
public class partitionList_86 {
    /***
     *  分两次遍历
     *  1：第一次遍历将链表中小于X的节点全部找出来；新增一个节点X，
     *  2：第二次遍历将找出的节点插入到合适的位置；
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head ==null  || head.next == null) {
            return head;
        }
        ListNode tpHead = new ListNode(Integer.MIN_VALUE);
        tpHead.next = head;
        ListNode thead = tpHead;
        boolean isFind = false;
        List<ListNode> list = new ArrayList<>();
        ListNode preNode = thead;
        while (thead != null) {
            if (thead.val <= x && thead.val != Integer.MIN_VALUE) {
                isFind = true;
            }
            if (isFind && thead.val<x) {
                ListNode tnext = thead.next;
                preNode.next = tnext;
                thead.next= null;
                list.add(thead);
                thead = tnext;
            } else {
                preNode = thead;
                thead = thead.next;
            }
        }
        if (!isFind  || list.size() == 0) {
            return head;
        }
        thead = tpHead;
        ListNode prNode = thead;
        while (true) {
            if (list.size() == 0) {
                break;
            }
            ListNode tmmNode = list.remove(0);
            while ( thead!=null && thead.val<tmmNode.val ) {
                prNode = thead;
                thead = thead.next;
            }
            prNode.next = tmmNode;
            prNode  = prNode.next;
            tmmNode.next = thead;
        }
        return tpHead.next;

    }

    /***
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition1(ListNode head, int x) {
        ListNode lowerHead = new ListNode(0);
        ListNode heigherHead = new ListNode (0);
        ListNode a = lowerHead,b = heigherHead;
        while (head != null) {
            if (head.val<x) {
                a.next = head;
                a =a.next;
            } else {
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }
        a.next = heigherHead.next;
        b.next = null;
        return lowerHead.next;
    }
    //[1,4,3,2,5,2]
    //3
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
        partitionList_86 list_86 = new partitionList_86();
        ListNode head = list_86.partition(node1,3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
