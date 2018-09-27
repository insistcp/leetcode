package leetcodeAgain.hard;

import java.util.Arrays;

/**
 * Created by cp
 * data  2018/9/14.
 * title:10. Regular Expression Matching
 * description :
 *  给定两个字符串s和p其中s为目标字符串，而p为模式字符串，其中对于字符串P有如下约定
 *  * 可以代表一个或者多个字符串，而.可以代表任意一个字符串
 *
 */
public class RegularExpression {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }
        int slen = s.length(),plen = p.length();
        boolean[][] dp = new boolean[slen+1][plen+1];
        dp[0][0] = true;
        for (int i = 1;i<=p.length();i++){
            if (p.charAt(i-1) == '*' && i>=2 && dp[0][i-2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1;i <= slen;i++ ) {
            for (int j = 1;j <= plen;j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1) == '*') {
                    if (j>=2 && s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.') {
                        dp[i][j] = dp[i][j-2];
                    } else {
                        dp[i][j] = (dp[i][j-1] || dp[i-1][j] ||( j>=2 && dp[i][j-2]));
                    }
                }
            }
        }
        for (int i = 0;i<=slen;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[slen][plen];
    }

    public static void main(String[] args) {
        //"aaa"
       // "ab*ac*a"
        //"aab"
       // "c*a*b"
        String str1 = "aaa";
        String str2 = "ab*ac*a";
        RegularExpression expression = new RegularExpression();
        boolean res = expression.isMatch(str1,str2);
        System.out.println(res);
    }
}
