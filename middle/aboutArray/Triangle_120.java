package middle.aboutArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
* @Description: 给定一个三角形数组，现在让你求这个三角形从顶部到底部的最小路径和，要求上下层只能有一步的偏差，
 * 比如：第3层是第1个元素则第4层只能是1和2个元素
* @Author: chenpeng
* @Date: 11:23 2018/11/27
* @param:
* @return:
*/
public class Triangle_120 {
    /***
     *  超时：
     */
    private  int minSum = Integer.MAX_VALUE;
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 ) {
           return 0;
        }
        getMinFromList(triangle,0,0,0);
        return minSum;
    }
    public void getMinFromList(List<List<Integer>> triangle,int Lindex,int sum,int i) {
        if (i>=triangle.size()) {
            if (sum<minSum) {
                minSum = sum;
            }
        } else {
            List<Integer> curr = triangle.get(i);
            if (i == 0) {
                for (int m = 0;m<curr.size();m++) {
                    sum += curr.get(m);
                    getMinFromList(triangle,m,sum,i+1);
                    sum -= curr.get(m);
                }
            } else {
                 for (int m = Lindex;m<=Lindex+1;m++) {
                     sum+=curr.get(m);
                     getMinFromList(triangle,m,sum,i+1);
                     sum -= curr.get(m);
                 }
            }
        }
    }

    /***
     *  通过动态规划求解：新建一个dp数组，从三角形的最后一层开始向上遍历；
     *  最后一层直接复制到数据元素中；
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 ) {
            return 0;
        }
        int size = triangle.size();
        int[] dp = new int[size+1];
        for (int i = size-1;i>=0;i--) {
            for(int j = 0;j<triangle.get(i).size();j++) {
                dp[j] =  Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
    //  [2],
    //    [3,4],
    //   [6,5,7],
    //  [4,1,8,3]
    //[[-1],[2,3],[1,-1,-3]]
    public static void main(String[] args) {
        Triangle_120 triangle_120 = new Triangle_120();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        List<Integer> list2= new ArrayList<>();
        list2.add(2);
        list2.add(3);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        res.add(list1);
        res.add(list2);
        res.add(list3);
        //res.add(list4);
        int resTR = triangle_120.minimumTotal(res);
        System.out.println(resTR);
    }
}
