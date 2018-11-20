package middle.aboutChain;

import common.ListNode;
/**
* @Description: 给定一个链表，以及两个数字m和n，现在让你将这个链表中的第m和n节点之间节点逆序；
 * 返回逆序处理之后链表
* @Author: chenpeng
* @Date: 11:13 2018/11/12
* @param:
* @return:
*/
public class reverseLinkedListII_92 {
    /***
     * 将链表的第m到第n个节点截取出来，对其进行逆序处理，再分别将前面的节点和后面的节点拼接上；
     * 这里需要注意的是前面部分或者后面部分为null的情况
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m==n){
            return head;
        }
        ListNode thead = head;
        int size = getSize(thead);
        if (m>=size){
            return head;
        }
        if (n>=size) {
            n = size;
        }
        thead = head;
        ListNode cNode = thead;
        ListNode cPNode = thead;
        if (m != 1) {
            for (int i =1;i<m;i++) {
                cPNode = cNode;
                cNode = cNode.next;
            }
            cPNode.next =null;
        }
        ListNode ctnode = cNode;
        for (int i = 1;i<=n-m;i++) {
            ctnode = ctnode.next;
        }
        ListNode ctLNode = null;
        if(ctnode!=null) {
            ctLNode = ctnode.next;
            ctnode.next = null;
        }

        ListNode newHead = reverseNode(cNode);
        if (m != 1 ) {
            cPNode.next = newHead;
        }
        ListNode tnewHead = newHead;
        while (tnewHead.next != null) {
            tnewHead = tnewHead.next;
        }
        tnewHead.next = ctLNode;
        return m==1?newHead:head;

    }
    public ListNode reverseNode (ListNode head) {
        ListNode preNode = head;
        ListNode currentNode = head.next;
        preNode.next = null;
        while (currentNode != null) {
                ListNode nextNode = currentNode.next;
                currentNode.next = preNode;
                preNode = currentNode;
                currentNode = nextNode;
        }
        return preNode;
    }
    public int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static void main(String[] args) {
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
        reverseLinkedListII_92 linkedListII_92 = new reverseLinkedListII_92();
        ListNode res = linkedListII_92.reverseBetween(node1,2,4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
