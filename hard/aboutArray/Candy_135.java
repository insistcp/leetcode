package hard.aboutArray;

/**
* @Description:  给定一个数组，数组中元素代表该位置的小朋友获取糖果的概率，要求相邻位置的小朋友概率高的人获取的糖果数更多；
 * 现在问题最少需要多少个糖果才能满足所有小朋友的分配要求。
* @Author: chenpeng
* @Date: 11:48 2018/11/30
* @param:
* @return:
*/
public class Candy_135 {
    /***
     *  找到最小概率的小朋友，然后依次采用贪心算法求解
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int len = ratings.length;
        int[] dp = new int[len];
        int minIndex = 0;
        for (int i = 1;i<len;i++) {
            if (ratings[i]<ratings[minIndex]) {
                minIndex = i;
            }
        }
        dp[minIndex] = 1;
        fillDPUp(dp,ratings,minIndex+1);
        fillDPDown(dp,ratings,minIndex-1);
        int sum = 0;
        for (int i =0;i<len;i++) {
            sum+=dp[i];
        }
        return sum;
    }
    public int fillDPDown(int[] dp,int[] rating,int start) {
        if (start < 0 || start>=dp.length) {
            return 0;
        } else {
            while (true) {
                if (rating[start] > rating[start+1]) {
                    dp[start] = dp[start + 1] + 1;
                } else {
                    if (dp[start+1] == 1  && rating[start] != rating[start+1]) {
                        return 1;
                    } else {
                        dp[start] = 1;
                    }
                }
                int returnV = fillDPDown(dp,rating,start-1);
                if ( returnV == 1) {
                    int tmpIndex = start;
                    dp[start] = dp[start]+1;
                    while (start<dp.length && rating[start+1]>rating[start] && dp[start+1]<=dp[start]) {
                        dp[start+1] = dp[start+1]+1;
                        start++;
                    }
                    start = tmpIndex-1;
                } else {
                    return 0;
                }
            }
        }
    }
    public int fillDPUp(int[] dp,int[] rating,int start) {
        if (start <= 0 || start>=dp.length) {
            return 0;
        } else {
            while (true) {
                if (rating[start] > rating[start-1]) {
                    dp[start] = dp[start - 1] + 1;
                }  else {
                    if (dp[start-1] == 1 && rating[start] != rating[start-1]) {
                        return 1;
                    } else {
                        dp[start] = 1;
                    }
                }
                int returnV = fillDPUp(dp,rating,start+1);
                if ( returnV == 1) {
                    int tmpIndex = start;
                    dp[start] = dp[start]+1;
                    while (start-1>=0 && rating[start-1]>rating[start] && dp[start-1] <= dp[start]) {
                        dp[start-1] = dp[start-1]+1;
                        start--;
                    }
                    start = tmpIndex+1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Candy_135 candy_135 = new Candy_135();
        int[] candy = {1,3,2,2,1};
        int res = candy_135.candy(candy);
        System.out.println(res);
    }
}
