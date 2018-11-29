package aboutArray;

import java.util.ArrayList;
import java.util.List;
/**
* @Description:  给定一个数组n现在让你返回杨辉三角形的第n层的结果，第一层的下标为0；
* @Author: chenpeng
* @Date: 10:53 2018/11/27
* @param:
* @return:
*/
public class PascalsTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        odd.add(1);
        even.add(1);
        even.add(1);

        for (int index = 2;index<=rowIndex;index++) {
            if ((index)%2 == 0) {
                odd.clear();;
                odd.add(1);
                int first = even.get(0);
                int second = even.get(1);
                for (int i = 1;i<index;i++) {
                    int tmp = first+second;
                    odd.add(tmp);
                    first = second;
                    if (i+1<even.size()) {
                        second = even.get(i+1);
                    }
                }
                odd.add(1);
            } else {
                even.clear();;
                even.add(1);
                int first = odd.get(0);
                int second = odd.get(1);
                for (int i = 1;i<index;i++) {
                    int tmp = first + second;
                    even.add(tmp);
                    first = second;
                    if (i + 1 < odd.size()) {
                        second = odd.get(i + 1);
                    }
                }
                even.add(1);
            }
        }
         return rowIndex%2==0?odd:even;
    }

    public static void main(String[] args) {
        PascalsTriangleII_119 pascalsTriangleII_119 = new PascalsTriangleII_119();
        List<Integer> res = pascalsTriangleII_119.getRow(2);
        for (int tmp:res){
            System.out.print(tmp+" ");
        }
    }
}
