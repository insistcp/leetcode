package hard.aboutArray;


import java.util.Arrays;
/**
* @Description: 给定一串股票价格数组，现在你最可以交易两次，求交易后的最大收益；
* @Author: chenpeng
* @Date: 11:32 2018/11/28
* @param:
* @return:
*/
public class BestTimeToBuyAndSellStockIII_123 {
    /***
     *  利用动态规划求解
     *  新建一个3*n的数组，从第二天价格开始遍历，寻找之前的价格中最低的价格（同时减去上一次交易所获得的收益）
     *  当前交易的最大收益为当前的股票的价格与上面获得的最小价格之差。
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <2) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[3][len];
        for (int k = 1;k<=2;k++) {
            for (int i = 1;i<len;i++) {
                int min = prices[0];
                for (int j = 1;j<=i;j++) {
                    min = Math.min(min,prices[j] - dp[k-1][j-1]);
                }
                dp[k][i] = Math.max(dp[k][i-1],prices[i]-min);
            }
        }
//        for (int[] arr:dp) {
//            System.out.println(Arrays.toString(arr));
//        }
        return dp[2][len-1];
    }
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII_123 toBuyAndSellStockIII_123 = new BestTimeToBuyAndSellStockIII_123();
        int[] profit = {3,3,5,0,0,3,1,4};
        System.out.println(Arrays.toString(profit));
        int res = toBuyAndSellStockIII_123.maxProfit(profit);
        System.out.println(res);
    }
}
