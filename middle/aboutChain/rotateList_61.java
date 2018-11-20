package middle.aboutChain;

import common.ListNode;
/**
* @Description: 给定一个链表，以及一个k值，现在让你将这个链表从倒数第k个位置开始旋转，例如
 *  1->2->3->4->5->6  k=3
 * 结果为：
 *  4->5->6->1->2->3
* @Author: chenpeng
* @Date: 11:23 2018/10/25
* @param:
* @return:
*/
public class rotateList_61 {
    /**
    * @Description:   先求得链表的长度，然后取余数，求得真正需要旋转的次数
    * @Author: chenpeng
    * @Date: 11:25 2018/10/25
    * @param:
    * @return:
    */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next ==null  || k<=0) {
            return head;
        }
        ListNode thead = head;
        int len =getSize(thead);
        k = k%len;
        if (k == 0) {
            return head;
        }
        int dis = len-k;
        thead = head;
        ListNode preNode = head;
        for (int i =1;i<=dis;i++) {
            preNode = thead;
            thead = thead.next;
        }
        ListNode reNode = thead;
        preNode.next = null;
        while (thead.next !=null){
            thead = thead.next;
        }
        thead.next= head;
        return reNode;

    }
    public int getSize(ListNode head) {
        int k = 0;
        while (head != null) {
            k++;
            head = head.next;
        }
        return k;
    }

    public static void main(String[] args) {
        rotateList_61 list_61 = new rotateList_61();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode head = list_61.rotateRight(node5,2);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
