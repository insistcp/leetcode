package hard.aboutString;

import java.util.Arrays;
/**
* @Description: 给定两个字符串 s和t 现在让你将字符串s进行变换
 * (删除其中某几个字符串)使得s变为t，问你有多少种变换方式
* @Author: chenpeng
* @Date: 11:32 2018/11/22
* @param:
* @return:
*/
public class DistinctSubsequences_115 {
    /***
     *  使用动态规划来做
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length()<t.length()) {
            return 0;
        }
        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[tlen+1][slen+1];
        for (int i = 0;i<=slen;i++) {
            dp[0][i] = 1;
        }

        for (int i=0;i<tlen;i++) {
            for(int j = 0;j<slen;j++) {
                    if (t.charAt(i) == s.charAt(j)) {
                        dp[i+1][j+1] =  dp[i][j]+dp[i+1][j];
                    } else {
                        dp[i+1][j+1] = dp[i+1][j];
                    }
            }
        }
        for (int[] arr:dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[tlen][slen];
    }

    public static void main(String[] args) {
        String tstr = "bag",sstr = "babgbag";
        DistinctSubsequences_115 subsequences_115 = new DistinctSubsequences_115();
        int res = subsequences_115.numDistinct(sstr, tstr);
        System.out.println(res);
    }
}
