package hard.aboutString;

import java.util.Arrays;
/**
* @Description: 给定三个字符串s1,s2,s3；现在问你s3是否可以由s1和s2组成交叉组成；
* @Author: chenpeng
* @Date: 11:06 2018/11/14
* @param:
* @return:
*/
public class interleavingString_97 {
    /***
     *  使用动态规划的方式解题：
     *  一样的规律dp数组的宽为s2长度+1，长为s1长度+1；
     *  dp[i][j] = (dp[i-1][j] && s2.chatAt(i-1) == s3.chatAt(i+j-1)) || (dp[i][j-1] && s1.chatAt(j-1) == s3.chatAt(i+j-1));
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null && s1 == null && s2 == null) {
            return true;
        }
        if (s3 == null && (s1 != null || s2 != null)) {
            return false;
        }
        if (s3.length() != (s1.length()+s2.length())) {
            return false;
        }
        int len1 = s1.length(),len2 = s2.length();
        boolean[][] dp = new boolean[len2+1][len1+1];
        dp[0][0] = true;
        for (int i = 1;i<=len1;i++) {
            dp[0][i] = dp[0][i-1] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1;i<=len2;i++) {
            dp[i][0] = dp[i-1][0] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1;i<=len2;i++) {
            for (int j = 1;j<=len1;j++) {
                dp[i][j] = (dp[i-1][j] && s2.charAt(i-1) == s3.charAt(i+j-1)) ||(dp[i][j-1] &&  s1.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        for (boolean[] arr:dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[len2][len1];
    }

    public static void main(String[] args) {
        String s1 = "aabccc", s2 = "dffeee", s3 = "aadbffccceee";
        interleavingString_97 interleavingString = new interleavingString_97();
        boolean res = interleavingString.isInterleave(s1,s2,s3);
        System.out.println(res);
    }
}
