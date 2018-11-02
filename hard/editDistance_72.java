package hard;



import java.util.Arrays;
/**
* @Description:   给定两个单词，现在让你对这两个单词word1 和word2 现在让你对word2做变换：只能做如下变化
 *  1：替换一个单词
 *  2：删除一个单词
 *  3：添加一个单词
 *  让你计算最少需要多少次变化可以使得word2变为word1
* @Author: chenpeng
* @Date: 11:03 2018/11/2
* @param:
* @return:
*/
public class editDistance_72 {
    /***
     * 初始版本：对第一行和第一列单独处理；需要特殊情况第一个单词一旦被用了下次就算想等也不可再用
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int res = 0;
        if (word1 == null && word2 == null) {
            return res;
        }
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        if (word1.equals(word2)) {
            return res;
        }

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len2][len1];
        if (word2.charAt(0) == word1.charAt(0)) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        boolean used = false;
        for (int i = 1;i<len1;i++) {
            if (!used && word2.charAt(0) == word1.charAt(i)) {
                used = true;
                dp[0][i] = dp[0][i-1];
            } else {
                dp[0][i] = dp[0][i-1]+1;
            }
        }
        used = false;
        for (int i = 1;i<len2;i++) {
            if (!used && word1.charAt(0) == word2.charAt(i)) {
                used = true;
                dp[i][0] = dp[i-1][0];
            } else {
                dp[i][0] = dp[i-1][0]+1;
            }
        }
        for (int i = 1;i<len2;i++) {
            for (int j = 1;j<len1;j++) {
                if (word1.charAt(j) == word2.charAt(i)) {
                    dp[i][j] =  dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        for (int[] rr:dp) {
            System.out.println(Arrays.toString(rr));
        }
        return dp[len2-1][len1-1];
    }

    /***
     * 改进版本：初始化dp数组时多初始化一列，用""去匹配第一行和第一列；
     * 真是的第一行和第一列就不需要特殊处理
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance1(String word1, String word2) {
        int res = 0;
        if (word1 == null && word2 == null) {
            return res;
        }
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        if (word1.equals(word2)) {
            return res;
        }
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len2+1][len1+1];
        for (int i = 0;i<=len1;i++) {
            dp[0][i] =i;
        }

        for (int i = 0;i<=len2;i++) {
            dp[i][0] = i;
        }
        for (int i = 1;i<=len2;i++) {
            for (int j = 1;j<=len1;j++) {
                if (word1.charAt(j-1) == word2.charAt(i-1)) {
                    dp[i][j] =  dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        for (int[] rr:dp) {
            System.out.println(Arrays.toString(rr));
        }
        return dp[len2-1][len1-1];
    }
    public int minDistance11(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        for (int[] rr:cost) {
            System.out.println(Arrays.toString(rr));
        }
        return cost[m][n];
    }
    //word1 = "horse", word2 = "ros"
    //"zoologicoarchaeologist"
    //"zoogeologist"
    //"pneumonoultramicroscopicsilicovolcanoconiosis"
    //"ultramicroscopically"
    public static void main(String[] args) {
        String word1 = "pneumonoultramicroscopicsilicovolcanoconiosis",word2 = "ultramicroscopically";
        editDistance_72 distance_72 = new editDistance_72();
        int res = distance_72.minDistance1(word1,word2);

    }
}
