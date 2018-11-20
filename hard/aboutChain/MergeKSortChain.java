package hard.aboutChain;

import common.ListNode;

/**
 * Created by cp
 * data  2018/9/15.
 * description
 */
public class MergeKSortChain {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode returnNode = new ListNode(1);
        int len = lists.length;
        while (true) {
            ListNode node = lists[0];
            for (int i = 1;i<len;i++){
                if (lists[i] == null) {
                    continue;
                }
                if (lists[i].val<node.val){
                    node = lists[i];
                }
            }
            ListNode tmpNode = node;
            returnNode.next = tmpNode;
            returnNode = returnNode.next;
            node = node.next;
            break;
        }
        return returnNode.next;
    }

}
