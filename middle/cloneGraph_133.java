package middle;

import java.util.*;
/**
* @Description:  图的深度clone
* @Author: chenpeng
* @Date: 13:19 2018/10/18
* @param:
* @return:
*/
public class cloneGraph_133 {
    /**
    * @Description: 采用广度优先的遍历的方式解决：通过队列的方式，不断向队列中添加元素
    * @Author: chenpeng
    * @Date: 13:29 2018/10/18
    * @param:
    * @return:
    */
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode,UndirectedGraphNode> dict = new HashMap<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        dict.put(node,head);
        while (!queue.isEmpty()) {
            UndirectedGraphNode currNode = queue.poll();
            for (UndirectedGraphNode neightbor:currNode.neighbors) {
                if (!dict.containsKey(neightbor)) {
                    UndirectedGraphNode newneightbor = new UndirectedGraphNode(neightbor.label);
                    queue.add(neightbor);
                    dict.put(neightbor,newneightbor);
                }
                dict.get(currNode).neighbors.add(dict.get(neightbor));
            }
        }
        return head;
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode,UndirectedGraphNode> dict = new HashMap<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        dict.put(node,head);
        cloneDFS(head,dict);
        return head;
    }
    public void cloneDFS(UndirectedGraphNode currNode,Map<UndirectedGraphNode,UndirectedGraphNode> dict) {
        if (currNode == null) {
            return;
        }
        for (UndirectedGraphNode neighbor:currNode.neighbors){
            if (!dict.containsKey(neighbor)) {
                UndirectedGraphNode newNei = new UndirectedGraphNode(neighbor.label);
                dict.put(neighbor,newNei);
                cloneDFS(neighbor,dict);
            }
            dict.get(currNode).neighbors.add(dict.get(neighbor));
        }
    }
}
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};