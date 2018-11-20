package middle.aboutChain;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;
/**
* @Description:  给定一个排序的链表，现在让你将这个链表中重复的元素删除；并返回最终的链表
* @Author: chenpeng
* @Date: 11:59 2018/11/7
* @param:
* @return:
*/
public class removeDuplicatesFormSortedListII_82 {
    /***
     * 统计链表中每一个元素的出现频率，将出现次数为1次的节点重新其中
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode retNode = new ListNode(1);
        ListNode phead = head;
        Map<Integer,Integer> map = new HashMap<>();
        while (phead != null) {
           map.put(phead.val,map.getOrDefault(phead.val,0)+1);
           phead  = phead.next;
        }
        phead = head;
        ListNode rett = retNode;
        while (phead != null) {
            if (map.get(phead.val) == 1) {
                rett.next = phead;
                rett = rett.next;

            }
            phead = phead.next;
        }
        rett.next = null;

        return retNode.next;
    }

    /***
     * 通过预设值一个前置节点；没访问一个节点时就对该节点进行判断看是否要添加到返回的列表中
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        ListNode phead = preNode;
        ListNode curr = head;
        while (phead != null && curr != null) {
            boolean isRea = false;
            while (curr.next!=null && curr.val == curr.next.val) {
                curr  = curr.next;
                isRea = true;
            }
            if (isRea && curr!=null) {
                curr = curr.next;
                continue;
            } else {
                phead.next = curr;
            }
            curr = curr.next;
            phead = phead.next;
        }
        phead.next = null;
        return preNode.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        node1.next =  node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        removeDuplicatesFormSortedListII_82 formSortedListII_82 = new removeDuplicatesFormSortedListII_82();
        ListNode res = formSortedListII_82.deleteDuplicates1(node1);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
