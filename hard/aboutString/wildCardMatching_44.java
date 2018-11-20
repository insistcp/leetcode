package hard.aboutString;

import java.util.Arrays;
/**
 *
* @Description:  给定一个字符串s和一个字符串p其中字符串p中包含*可以匹配0至多个任意的字符串，
 * 字符串？可以匹配一个任意的字符串，现在让你判断字符串s是否可以由字符串p匹配得到；利用动态规划求解
* @Author: chenpeng
* @Date: 10:45 2018/10/8
* @param:
* @return:
*/
public class wildCardMatching_44 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[plen+1][slen+1];
        dp[0][0] = true;
        for (int i = 1;i<=plen;i++) {
            if (p.charAt(i-1) == '*' ) {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1;i <= plen;i++) {
            char pat = p.charAt(i-1);
            for (int j = 1;j <= slen;j++) {
                char comp = s.charAt(j-1);
                if (pat  == '*' ) {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j];
                }
                if (pat == '?' || pat == comp) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        for (int i =0;i<=plen;i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[plen][slen];
    }
   //"aab"
   //"c*a*b"
    //"adceb"
   //"*a*b"
    //"abefcdgiescdfimde"
   //"ab*cd?i*de"
    //"ab"
   //"*?*?*"
    public static void main(String[] args) {
        wildCardMatching_44 matching_44 = new wildCardMatching_44();
        String str = "ab";
        String pattern = "*?*?*";
        boolean res = matching_44.isMatch(str,pattern);
        System.out.println(res);
    }
}
