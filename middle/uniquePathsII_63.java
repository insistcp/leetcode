package middle;
/**
* @Description:  给定一个二维数组，二维数组由0,1组成，
 * 现在让你从这个二维数组的左上角出发，走到数组的右下角；有多少种走法PS:遇到1表示这条路走不通。
 *
* @Author: chenpeng
* @Date: 11:07 2018/10/30
* @param:
* @return:
*/
public class uniquePathsII_63 {
    private int total = 0;
    /**
    * @Description:  利用动态规划的思想；
     * 达到某一个点的方式等与到达其上方的种数+到达其左方的种数
     * dp[i][j] = dp[i-1][j]+dp[i][j-1] dp[i][j] == 0
     * dp[i][j] = 0  dp[i][j]!=0
      @Author: chenpeng
    * @Date: 11:07 2018/10/30
    * @param:
    * @return:
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length==0 || obstacleGrid[0][0] ==1) {
            return 0;
        }
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        // 第一列
        obstacleGrid[0][0] =1;
        for (int i = 1;i<r;i++) {
            obstacleGrid[i][0] = (obstacleGrid[i-1][0]==1 && obstacleGrid[i][0] == 0)?1:0;
        }
        for (int i = 1;i<c;i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i-1]==1 && obstacleGrid[0][i] == 0)?1:0;
        }
        for (int i = 1;i<r;i++) {
            for (int j = 1;j<c;j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[r-1][c-1];
    }
    /**
    * @Description: 利用图的广度优先遍历的方式；超时
    * @Author: chenpeng
    * @Date: 11:09 2018/10/30
    * @param:
    * @return:
    */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length==0 || obstacleGrid[0][0] ==1) {
            return 0;
        }

        getAllPath(obstacleGrid,0,0);
        return total;
    }
    public void getAllPath(int[][] obsta,int i,int j) {
        if (i>obsta.length || j>obsta[i].length) {
            return;
        }
        if (i == obsta.length-1 && j == obsta[0].length-1) {
            total++;
            return;
        }
        // right
        if (j+1<obsta[0].length && obsta[i][j+1] != 1) {
            getAllPath(obsta,i,j+1);
        }
        // down
        if (i+1<obsta.length && obsta[i+1][j] != 1) {
            getAllPath(obsta,i+1,j);
        }
    }

    public static void main(String[] args) {
        int[][] obs = {{0,0,0},
                {0,1,0},
                {0,0,0}};
        uniquePathsII_63 pathsII_63 = new uniquePathsII_63();
        int res = pathsII_63.uniquePathsWithObstacles(obs);
        System.out.println(res);
    }
}
