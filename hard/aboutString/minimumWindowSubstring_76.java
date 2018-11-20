package hard.aboutString;

import java.util.HashMap;
import java.util.Map;
/**
* @Description: 给定两个字符串字符串s 和字符串t ; 现在让你找到字符串s中包含t的最小字符串；例如
 * s = ADOBECODEBANC t = ABC;
 * 字结果为BANC；
* @Author: chenpeng
* @Date: 12:55 2018/11/5
* @param:
* @return:
*/
public class minimumWindowSubstring_76 {
    /***
     * 将字符串t建立一个字典；然后遍历字符串s，依次从字符串s中第一个出现在字符串t中的位置开始找字符串t的其他元素，知道找到所有元素为止
     * but 超时
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        int slen = s.length();
        int tlen = t.length();
        if (tlen>slen) {
            return "";
        }

        int min = Integer.MAX_VALUE;
        String rtStr = "";
        int start = 0;
        Map<Character,Integer> dict = new HashMap<>();
        for (int i = 0;i<tlen;i++) {
            dict.put(t.charAt(i),dict.getOrDefault(t.charAt(i),0)+1);
        }
        for (int i = 0;i<slen;i++) {
            int count  = 0;
            boolean isEnter = false;
            if (dict.containsKey(s.charAt(i)) && dict.get(s.charAt(i))>=1) {
                start = i;
                count++;
                dict.put(s.charAt(i),dict.get(s.charAt(i))-1);
                isEnter = true;

                for (int j = i+1;j<slen;j++) {
                    if (dict.containsKey(s.charAt(j)) && dict.get(s.charAt(j))>=1) {
                        dict.put(s.charAt(j),dict.get(s.charAt(j))-1);
                        count++;
                    }
                    if (count == tlen) {
                        min =Math.min( j-i+1,min);
                        rtStr = s.substring(start,j+1);
                        break;
                    }

                }
            }
            if (isEnter) {
                dict.clear();
                for (int m = 0;m<tlen;m++) {
                    dict.put(t.charAt(m),dict.getOrDefault(t.charAt(m),0)+1);
                }
            }

        }
        return rtStr;
    }
    /**
    * @Description:
     * 1：同样先要以字符串t建立一个字典
     * 2：设置一个window；以及两个坐标点left和right；
     *  遍历字符串（移动right）s找到包含所有字符串t的window；
     *  然后移动left，找到最小的包含字符串t的window，记录改长度；
     *  当window不包含t时继续移动right，直到包含字符串t时在判断此时的长度和之前找到的长度长短，依次类推
    * @Author: chenpeng
    * @Date: 12:55 2018/11/5
    * @param:
    * @return:
    */
    public String minWindow2(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        int slen = s.length();
        int tlen = t.length();
        if (tlen > slen) {
            return "";
        }
        Map<Character,Integer> dictT = new HashMap<>();
        for (int i = 0;i<tlen;i++) {
            dictT.put(t.charAt(i),dictT.getOrDefault(t.charAt(i),0)+1);
        }
        int l = 0,r = 0;
        Map<Character,Integer> windows = new HashMap<>();
        int[] res = {-1,0,0};
        int un = dictT.size();
        int allU = 0;
        while (r < slen) {
            char c = s.charAt(r);
            windows.put(c,windows.getOrDefault(c,0)+1);
            if (dictT.containsKey(c) && windows.get(c).intValue() == dictT.get(c).intValue()) {
                allU++;
            }
            while (l <= r && allU == un) {
                char tc = s.charAt(l);
                if (res[0] == -1 || r-l+1<res[0]) {
                    res[0] = r-l+1;
                    res[1] = l;
                    res[2] = r;
                }

                windows.put(tc,windows.get(tc)-1);
                if (dictT.containsKey(tc) && windows.get(tc).intValue()<dictT.get(tc).intValue()) {
                    allU--;
                }
                l++;
            }
            r++;
        }
        return res[0] == -1?"":s.substring(res[1],res[2]+1);
    }

    public String minWindow1(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        minimumWindowSubstring_76 windowSubstring_76 = new minimumWindowSubstring_76();
      String s = "ADOBECODEBANC" ;
      String t = "ABC";
        String res = windowSubstring_76.minWindow2(s, t);
        System.out.println(res);
    }
}
