package middle.aboutString;

import java.util.*;
/**
* @Description: 给定两个单词startWord,endWord以及一个单词数组：wordList
 * 现在让你从这个单词数组中找出将单词startWord转化到endWord需要的最小转换次数；
* @Author: chenpeng
* @Date: 11:34 2018/11/29
* @param:
* @return:
*/
public class wordLadder_127 {

    private int minDis = Integer.MAX_VALUE;

    /***
     * 找出每一个单词的临近单词，依次遍历，
     * 超时了；
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size()<1 || !wordList.contains(endWord)) {
            return 0;
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        if (beginWord.length() == 1) {
            return 2;
        }
        Map<String,List<String>> dict = new HashMap<>();
        int size = wordList.size();
        for (int i =0;i<size;i++) {
            String key = wordList.get(i);
            for(int j =0;j<size;j++) {
                if(i == j) {
                    continue;
                }
                String value  = wordList.get(j);
                if (isDifOne(key,value)) {
                    List<String> list = dict.get(key);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(value);
                    dict.put(key, list);
                }
            }
        }
        List<String> starts = dict.get(beginWord);
        if(starts == null) {
            return 0;
        }
        getAll(starts,dict,beginWord,endWord,1,new HashSet<String>());
        if (minDis == Integer.MAX_VALUE) {
            return 0;
        }
        return minDis;
    }
    public void getAll(List<String> starts, Map<String,List<String>> dict, String startWord, String endword, int index, Set<String> used) {
        if (starts ==null || starts.size() <=0) {
            return;
        } else {
            for (String str:starts) {
                if (str.equals(endword)) {
                    if(index<minDis) {
                        minDis = index+1;
                    }
                }
                if (str.equals(startWord) || used.contains(str)) {
                    continue;
                }
                used.add(str);
                getAll(dict.get(str),dict,startWord,endword,index+1,used);
                used.remove(str);
            }
        }
    }
    public boolean isDifOne(String word1,String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int len = word1.length();
        int diff = 0;
        for (int i = 0;i<len;i++){
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
            if (diff>1) {
                return false;
            }
        }
        return true;
    }

    /***
     *  从起始单词依次替换单词的每一个位置的字母（从a-z）判断单词在单词数组中是否存在，如果存在则加入到队列中，并将其移除；
     *  不断遍历队列，直到找到最后一个元素位置，如果当前队列的元素为空则表示没有单词数组不存在这种转换
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String cur = q.poll();
                for (int i = 0; i < endWord.length(); i++) {
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder newWord = new StringBuilder(cur);
                        newWord.setCharAt(i, letter);
                        if (set.contains(newWord.toString())) {
                            if (newWord.toString().equals(endWord))
                                return step + 1;
                            set.remove(newWord.toString());
                            q.offer(newWord.toString());
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

//"hot"
//"dog"
//["hot","dog"]
    public static void main(String[] args) {
        wordLadder_127 ladder_127 = new wordLadder_127();
        String beginWord = "hot", endWord = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");

        int res = ladder_127.ladderLength1(beginWord,endWord,wordList);
        System.out.println(res);
    }

}
