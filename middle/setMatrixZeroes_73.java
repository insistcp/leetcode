package middle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
* @Description:  给定一个矩阵：现在让你将这个矩阵中为0的点所在的行和列都转化为0
* @Author: chenpeng
* @Date: 10:17 2018/11/5
* @param:
* @return:
*/
public class setMatrixZeroes_73 {
    /**
    * @Description:
     * 分两次遍历
     *  1：第一次遍历，如果某一个元素的值为0，将这个元素所在行的第一个元素置为0，所在列的第一个元素置为0；
     *      PS:把第一列单独拿出来处理
    *   2：第二次遍历
     *      先处理所有的列。需要将第一行和第一列抛开
            在处理行
     * @Author: chenpeng
    * @Date: 10:36 2018/11/5
    * @param:
    * @return:
    */
    public void setZeroes1(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        boolean rzero = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0 ;i<row;i++) {
            if (matrix[i][0] == 0) rzero = true;
            for (int j = 1;j<col;j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int j = 1;j<col;j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1;i<row;i++) {
                    matrix[j][i]= 0;
                }
            }
        }

        for (int i = 0;i<row;i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0;j<col;j++) {
                    matrix[i][j]= 0;
                }
            }
            if (rzero) {
                matrix[i][0] = 0;
            }
        }

        for (int[] r:matrix) {
            System.out.println(Arrays.toString(r));
        }
    }
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> rows  = new HashSet<>();
        Set<Integer> cols  = new HashSet<>();
        for (int i = 0;i<row;i++) {
            for (int j = 0;j<col;j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int ro:rows) {
            for (int i =0;i<col;i++) {
                matrix[ro][i] = 0;
            }
        }
        for (int co:cols) {
            for (int i =0;i<row;i++) {
                matrix[i][co] = 0;
            }
        }
        for (int[] r:matrix) {
            System.out.println(Arrays.toString(r));
        }
    }
    //[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    public static void main(String[] args) {
        setMatrixZeroes_73 matrixZeroes_73 = new setMatrixZeroes_73();
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};
        matrixZeroes_73.setZeroes1(matrix);
    }
}
