package middle.aboutGraph;
/**
* @Description: 题目描述：给定一个二维数组，现在让你求从左上方的点到右下方最短的距离
 * 利用动态规划的思想：dp[i][j] = Min(dp[i-1][j],dp[i][j-1])+grid[i][j]
* @Author: chenpeng
* @Date: 11:18 2018/10/30
* @param:
* @return:
*/
public class minimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        if (grid== null || grid.length <= 0 ||grid[0].length <= 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 1;i<c;i++){
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }
        for (int i = 1;i<r;i++){
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for (int i =1;i<r;i++) {
            for (int j = 1;j<c;j++) {
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }

        return grid[r-1][c-1];
    }
    private int minSum = Integer.MAX_VALUE;
    public int minPathSum1(int[][] grid) {
        if (grid== null || grid.length <= 0 ||grid[0].length <= 0) {
            return 0;
        }
        getAllSum(grid,0,0,grid[0][0]);
        return minSum;
    }
    public void getAllSum(int[][] grid,int i,int j,int currSum) {
        if(i > grid.length  || j>grid[0].length) {
            return;
        }
        if (i == grid.length-1 && j == grid[0].length-1) {
            if (currSum<minSum) {
                minSum = currSum;
            }
            return;
        }
        if (j+1<grid[0].length && currSum+grid[i][j+1]<minSum) {
            getAllSum(grid,i,j+1,currSum+grid[i][j+1]);
        }
        if (i+1<grid.length && currSum+grid[i+1][j]<minSum) {
            getAllSum(grid,i+1,j,currSum+grid[i+1][j]);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
        {1,3,1},
        {1,5,1},
        {4,2,1}};
        minimumPathSum_64 pathSum_64 = new minimumPathSum_64();
        int res = pathSum_64.minPathSum(grid);
        System.out.println(res);
    }
}
