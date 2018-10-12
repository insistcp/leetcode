package hard;
/**
* @Description: 给定n个皇后，让你计算有多少个不同的摆放方式可以完成皇后的摆放。
* @Author: chenpeng
* @Date: 10:46 2018/10/12
* @param:
* @return:
*/
public class nQueueII_52 {
    private int totalRes = 0;
    public int totalNQueens(int n) {
        if (n <= 0 ) {
            return 0;
        }
        int[][] dp = new int[n][n];
        getAllComp(dp,0);
        return totalRes;
    }
    public void  getAllComp(int[][] dp,int start) {
        if (start>=dp.length) {
            totalRes++;
        } else {
            for (int i = 0;i<dp.length;i++) {
                if (canFill(dp,start,i)) {
                    dp[start][i] = 1;
                    getAllComp(dp,start+1);
                    dp[start][i] = 0;
                }
            }
        }
    }
    public boolean canFill(int[][] dp,int i,int j) {
        for (int m = 0;m<dp.length;m++) {
            if (dp[i][m] == 1 ||  dp[m][j] == 1) {
                return false;
            }
        }
        int istart = i,jstart = j;
        while (istart>0 && jstart>0) {
            istart--;
            jstart--;
        }
        while (istart<dp.length &&jstart<dp.length) {
            if (dp[istart++][jstart++] == 1) {
                return false;
            }
        }

        istart = i;
        jstart = j;
        while (istart>0 && jstart<dp.length-1) {
            istart--;
            jstart++;
        }

        while (istart<dp.length && jstart>=0) {
            if (dp[istart++][jstart--] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] dp = {
                {0,0,0,0},
                {0,1,0,0},
                {0,0,0,0},
                {0,0,0,0}};
        nQueueII_52 queueII_52 = new nQueueII_52();
        int res =  queueII_52.totalNQueens(5);
        System.out.println(res);
    }
}
