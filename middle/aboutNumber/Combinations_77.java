package middle.aboutNumber;

import java.util.ArrayList;
import java.util.List;
/** 
* @Description:
    两个数字n和k,现在让你将1，2，，，n中进行k个元素一组一组的组合；找出所有的可能组合
* @Author: chenpeng
* @Date: 11:11 2018/11/6  
* @param: 
* @return:  
*/  
public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k>n) {
            return res;
        }
        GetAllComb(res, new ArrayList<>(),1,k,n);
        return res;
    }
    public void GetAllComb(List<List<Integer>> res,List<Integer> curr,int index,int k,int n) {
        if (curr.size() >= k) {
            res.add(new ArrayList<>(curr));
        } else {
            for (int i = index;i<=n;i++) {
                curr.add(i);
                GetAllComb(res,curr,i+1,k,n);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        combine(answer, new ArrayList<>(), 1, n, k);
        return answer;
    }

    private void combine(List<List<Integer>> answer, List<Integer> arr, int i, int n, int k) {
        if (arr.size() == k) {
            answer.add(new ArrayList<>(arr));
        } else {
            int index = arr.size();
            int end = n - k + index + 1;
            for (; i <= end; i++) {
                arr.add(i);
                combine(answer, arr, i + 1, n, k);
                arr.remove(index);
            }
        }
    }
    public static void main(String[] args) {
        Combinations_77 combinations_77 = new Combinations_77();
        List<List<Integer>> res =  combinations_77.combine(6,6);
        for (List<Integer> curr:res) {
            for (Integer t:curr) {
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }
}
