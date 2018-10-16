package middle;

import java.util.ArrayList;
import java.util.List;
/**
* @Description: 给定一个字符串：让你找到这个字符串所有的分割方式使得分割后的字符串都是回文字符串
* @Author: chenpeng
* @Date: 14:43 2018/10/16
* @param:
* @return:
*/
public class PalindromePArtitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        getAllComb(res,new ArrayList<>(),0,s);
        return res;
    }
    public void getAllComb(List<List<String>> res,List<String> curr,int start,String sstr) {
        if (start>=sstr.length()) {
            res.add(new ArrayList<>(curr));
        } else {
            for (int i = start;i<sstr.length();i++) {
                String tmp  = sstr.substring(start,i+1);
                if (isPalindrome(tmp)) {
                    curr.add(tmp);
                    getAllComb(res,curr,i+1,sstr);
                    curr.remove(curr.size()-1);
                }
                continue;
            }
        }
    }
    public boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return true;
        }
        int len = str.length();
        int left = 0,right = len-1;
        while (left<right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePArtitioning_131 palindromePArtitioning_131 = new PalindromePArtitioning_131();
        String str = "a";
        List<List<String>> res = palindromePArtitioning_131.partition(str);
        for (List<String> list:res) {
            for (String str1:list) {
                System.out.print(str1+",");
            }
            System.out.println();
        }
    }
}
