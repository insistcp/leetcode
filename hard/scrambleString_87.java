package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
* @Description: 给定两个字符串s1和s2，让你判断s2是否是s1的scramble的字符串；
 * scramble字符串的定义：
        great    ---------------> great
    gr      eat   --------------> eatgr
g       r  e   at  -------------> rgeat  rgate
              a   t --->  greta raeta
* @Author: chenpeng
* @Date: 11:59 2018/11/8
* @param:
* @return:
*/
public class scrambleString_87 {
    /***
     * 利用递归的算法；
     * 将元素字符串从1开始进行分割，分割后字符串进行判断，是否是完全相等；或者时其对换字符串；
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1,String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] times = new int[26];
        int len = s1.length();
        for (int i=0;i<len;i++) {
            times[s1.charAt(i)-'a']++;
            times[s2.charAt(i)-'a']--;
        }
        for (int i=0;i<26;i++) {
             if (times[i] !=0) {
                 return false;
             }
        }
        for(int i=1;i<len;i++) {
            if ((isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))) ){
                return true;
            }
            if (isScramble(s1.substring(0,i),s2.substring(s2.length()-i)) && isScramble(s1.substring(i),s2.substring(0,s2.length()-i)) ) {
                return true;
            }
        }
        return false;
    }

    /***
     * 找到字符串s的所有的scramble字符串，然后判断字符串t是否在其中
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        Set<String> res = new HashSet<>();
        getAllScraStr(res,s1,s1.length());
        for (String s:res) {
            System.out.println(s);
        }
        return res.contains(s2);
    }
    public String getAllScraStr(Set<String> set,String s,int l) {
        if (s.length() == 1) {
            return s;
        }
        int len = s.length();
        int index = len/2;
        String left = s.substring(0,index);
        String right = s.substring(index);
        List<String> curr = new ArrayList<>();
        curr.add(left);
        curr.add(right);
        List<String> tmp = new ArrayList<>();
        String resr = "";
        for (String str:curr) {
            String exL =  getAllScraStr(set,str,l);
            tmp.add(exL);
        }
        for (String st:tmp) {
            resr+=st;
        }
        set.add(resr);
        return right+left;
    }

    public static void main(String[] args) {
        scrambleString_87 scrambleString87 = new scrambleString_87();
        String str1 = "great";
        String str2 = "eatgr";
        scrambleString87.isScramble(str1,str2);
    }
}
