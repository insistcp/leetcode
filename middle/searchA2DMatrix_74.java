package middle;
/**
* @Description: 给定一个二维矩阵matrix 以及一个数字，现在让你判断这个数字是否在这个二维数组中出现过
* @Author: chenpeng
* @Date: 11:19 2018/11/2
* @param:
* @return:
*/
public class searchA2DMatrix_74 {
    /***
     *  解题思路：以左下角为起点，i,j通过比较targets值和当前坐标值的大小不断移动坐标的大小 ，直到越界为止
      * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        if (target>matrix[row-1][col-1] ||target<matrix[0][0]) {
            return false;
        }
        int i = row-1,j = 0;
        while (i>=0 && j<col) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        searchA2DMatrix_74 matrix_74 = new searchA2DMatrix_74();
        boolean res = matrix_74.searchMatrix(matrix,21);
        System.out.println(res);
    }
}
