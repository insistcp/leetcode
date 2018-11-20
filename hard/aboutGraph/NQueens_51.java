package hard.aboutGraph;

import java.util.ArrayList;
import java.util.List;
/**
* @Description:   n-queue 现在给你一个n*n的二维数组让你用n个皇后填充这个数组，
 * 使得所有的n个皇后既不在同一行也不再同一列，也不再同一个对角线上。
* @Author: chenpeng
* @Date: 10:56 2018/10/10
* @param:
* @return:
*/
public class NQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n<=0) {
            return res;
        }
        int[][] dp = new int[n][n];
        getAllCom(res,0,dp);
        return res;
    }
    public void getAllCom(List<List<String>> res,int start,int[][] dp) {
        if (start >= dp.length) {
            int wlen = dp.length;
            List<String> curr = new ArrayList<>();
            for (int i = 0;i<wlen;i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0;j<wlen;j++) {
                    if (dp[i][j] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                curr.add(sb.toString());
            }
            res.add(curr);
        } else {
            for (int i = 0;i<dp.length;i++) {
                if (isCanFill(dp,start,i)) {
                    dp[start][i] = 1;
                    getAllCom(res,start+1,dp);
                    dp[start][i] = 0;
                }
            }
        }
    }
    /**
    * @Description:  判断当前位置是否可以填充：行列，对角线是否有元素
    * @Author: chenpeng
    * @Date: 10:57 2018/10/10
    * @param:
    * @return:
    */
    public boolean isCanFill (int[][] dp,int i ,int j) {
        for (int m=0;m<dp.length;m++) {
            if (dp[i][m] == 1 || dp[m][j] == 1) {
                return false;
            }

        }
        int istart = i,jstart = j;
        while (istart>0 && jstart>0) {
            istart--;
            jstart--;
        }
        while (istart<dp.length && jstart<dp.length-1) {
            if (dp[istart++][jstart++] == 1) {
                return false;
            }
        }
        istart = i;jstart = j;
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
/**
 * 1 1 1 1
 * 1 2 2 2
 * 1 2 3 2
 * 1 1 1 1
 *
* @Description:
* @Author: chenpeng
* @Date: 10:03 2018/10/10
* @param:
* @return:
*/
    public static void main(String[] args) {
        int[][] dp = {
                {0,0,0,0},
                {0,0,0,0},
                {1,1,0,1},
                {0,0,0,1}
        };
        NQueens_51 nQueens_51 = new NQueens_51();
//        boolean res = nQueens_51.isCanFill(dp,0,2);
//        System.out.println(res);
        List<List<String>> res  = nQueens_51.solveNQueens(4);
        for(List<String> list:res) {
            for (String str:list) {
                System.out.println(str);
            }
            System.out.println();
        }
    }
}
