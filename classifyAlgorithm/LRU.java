package classifyAlgorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
* @Description:  实现一个最近最少最少使用的页面淘汰算法
* @Author: chenpeng
* @Date: 9:46 2018/11/14
* @param:
* @return:
*/
public class LRU {
    /***
     *  具体实现方式：通过双向链表加字典的方式实现
     *  字典的键存储page,值存储页面的对应的节点；
     *  字典快速定位节点；链表快速移动节点；
     */
    private int size = 6;
    private LinkedList<Integer> list;
    private Map<Integer,Integer> dict;
    public LRU() {
        dict = new HashMap<>();
        list = new LinkedList<>();
    }
    public LRU (int size) {
        this.size = size;
        dict = new HashMap<>();
        list = new LinkedList<>();
    }
    public void push(int page) {
        Integer value  = new Integer(page);
        if (dict.containsKey(page)) {
            Integer val = dict.get(page);
            list.remove(val);
            list.add(value);
            dict.put(page,value);
            System.out.println("add element ---> :" + page);
        }else {
            if (dict.size() < size) {
                list.add(page);
                dict.put(page, value);
                System.out.println("add element ---> :" + page);
            } else {
                Integer move = list.remove(0);
                System.out.println("remove element --->: " + move);
                System.out.println("add element --->: " + page);
                dict.remove(move);
                dict.put(page, value);
                list.add(value);

            }
        }
        for (int val:list) {
            System.out.print(val +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.push(1);
        lru.push(2);
        lru.push(3);
        lru.push(2);
        lru.push(4);
        lru.push(5);
        lru.push(6);
        lru.push(7);
        lru.push(1);
        lru.push(4);
    }
}
