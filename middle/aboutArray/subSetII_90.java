package middle.aboutArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
* @Description: 给定一个数组现在让你求解这个数组中所有的子集，且子集不还能重复
* @Author: chenpeng
* @Date: 10:06 2018/11/9
* @param:
* @return:
*/
public class subSetII_90 {
    /***
     * 先对元素组进行排序，采用递归的方式遍历数组，不断遍历数组，获取子数；
     * PS： 为了过滤掉重复的子集，通过设置一个used数组标志某一个元素是否被用过；
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        boolean[] used = new boolean[nums.length];
        getAllComb(nums,res,new ArrayList<>(),0,used);
        return res;
    }
    public void getAllComb(int[] nums,List<List<Integer>> res,List<Integer> curr,int index,boolean[] used) {
        if (!curr.isEmpty()) {
            res.add(new ArrayList<>(curr));
        }
        if (index>=nums.length) {
           return;
        } else {

            for (int i = index;i<nums.length;i++) {
                if (i>0 && nums[i] == nums[i-1] && !used[i-1]) {
                    continue;
                }
                used[i] = true;
                curr.add(nums[i]);
                getAllComb(nums,res,curr,i+1,used);
                curr.remove(curr.size()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        subSetII_90 setII_90 = new subSetII_90();
        int[] arr = {4,4,4,1,4};
        List<List<Integer>> res = setII_90.subsetsWithDup(arr);
        for (List<Integer> c:res) {
            for (Integer tmp:c) {
                System.out.print(tmp+"  ");
            }
            System.out.println();
        }
    }
}
