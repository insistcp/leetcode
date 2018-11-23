package aboutArray;

import java.util.ArrayList;
import java.util.List;
/**
* @Description: 给定一个数字n,让你生成n层的杨辉三角形
 *  例如给出的数字为5，则输出如下三角形
 *      1
 *     1 1
 *    1 2 1
 *   1 3 3 1
 *  1 4 6 4 1
 *
* @Author: chenpeng
* @Date: 11:31 2018/11/23
* @param:
* @return:
*/
public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        if (numRows >= 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            res.add(list);
        }
        if (numRows >=2) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            res.add(list);
        }
        if (numRows >=3) {
            int index = 3;
            for (;index<=numRows;index++) {
                List<Integer> list = new ArrayList<>();
                List<Integer> preList = res.get(index-2);
                list.add(1);
                int first = 0,second = 1;
                for (int m = 2;m<index;m++) {
                    int tmp = preList.get(first)+preList.get(second);
                    list.add(tmp);
                    first = second;
                    second++;
                }
                list.add(1);
                res.add(list);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle_118  triangle_118 = new PascalsTriangle_118();
        List<List<Integer>> res = triangle_118.generate(5);
        for (List<Integer> list:res){
            for (int tmp:list){
                System.out.print(tmp+",");
            }
            System.out.println();
        }
    }
}
