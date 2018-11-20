package middle.aboutGraph;

import java.util.ArrayList;
import java.util.List;
/**
* @Description: 给定一个二维数组现在让你按照层次遍历的方式遍历这个二维数组
* @Author: chenpeng
* @Date: 11:27 2018/10/10
* @param:
* @return:
*/
public class spiralMatix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        getAllElements(0,0,matrix,res,m*n,0);
        return res;
    }
    public void getAllElements(int i, int j, int[][] matrix, List<Integer> list,int total,int cicle) {
        // right
        if (list.size() >=total) {
            return;
        }
        while (list.size() <total && i<matrix.length-cicle && j<matrix[0].length-cicle)  {
            list.add(matrix[i][j++]);
        }
        if (list.size() >=total) {
            return;
        }
        i++;
        j--;
        // down
        while (list.size() <total && i<matrix.length-cicle && j<matrix[0].length-cicle)  {
            list.add(matrix[i++][j]);
        }
        if (list.size() >=total) {
            return;
        }
        // left

        i--;
        j--;
        while (list.size() <total && i<matrix.length-cicle && j>=cicle)  {
            list.add(matrix[i][j--]);
        }
        if (list.size() >=total) {
            return;
        }
        // up
        i--;
        j++;
        while (list.size() <total && i>cicle && j<matrix[0].length-cicle)  {
            list.add(matrix[i--][j]);
        }
        i++;
        j++;
        cicle++;
        getAllElements(i,j,matrix,list,total,cicle);
    }

    public static void main(String[] args) {
        int[][] dp = {
            { 1, 2, 3,10 }};
        spiralMatix_54 matix_54 = new spiralMatix_54();
        List<Integer> res = matix_54.spiralOrder(dp);
        for (int tmp:res) {
            System.out.println(tmp);
        }
    }
}
