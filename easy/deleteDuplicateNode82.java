package easy;
import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cp
 * data  2018/9/10.
 * description
 * ��Ŀ������ɾ�������е��ظ�Ԫ��
 * ����һ����������ɾ�����к����ظ����ֵĽڵ㣬ֻ����ԭʼ������ û���ظ����� �����֡�
 * ��������һ���µ�ͷ�ڵ�
 */
public class deleteDuplicateNode82 {
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode thead = head;
        Map<Integer,Integer> map = new HashMap<>();
        while (thead != null) {
            map.put(thead.val,map.getOrDefault(thead.val,0)+1);
            thead = thead.next;
        }

        thead = head;
        ListNode returnNode = null,rNode = null;
        while (thead != null) {
            if (map.get(thead.val) == 1) {
                if (returnNode == null) {
                    returnNode = thead;
                    rNode = thead;
                } else {
                    rNode.next = thead;
                    rNode = rNode.next;
                }
            }
            thead = thead.next;
        }
        if(rNode != null){
            rNode.next = null;
        }
        return returnNode;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode tmpNode = new ListNode(-1);
        tmpNode.next = head;
        ListNode preNode = tmpNode;
        ListNode currNode = head;
        boolean flag = false;
        while (currNode != null ) {
            while (currNode.next != null && currNode.next.val == currNode.val) {
                currNode.next = currNode.next.next;
                flag = true;
            }
            if (flag) {
                preNode.next = currNode.next;
                flag = false;
            } else {
                preNode = currNode;
            }
            currNode = currNode.next;
        }
        return tmpNode.next;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        deleteDuplicateNode82 duplicateNode82 = new deleteDuplicateNode82();
        ListNode res = duplicateNode82.deleteDuplicates(node1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
