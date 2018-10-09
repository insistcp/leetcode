package middle;

import java.util.*;
/**
* @Description:
 * 给定一个数组，让你求这个数组的所有的排列组合，不包含重复的元素
 * 使用递归的方式去做，创建一个新的used数组来表示某一个遍历是否使用过该元素
 * 但是注意这次递归不用下标去做终止判断而是以是否找到了一组合适的排列作为判断。
* @Author: chenpeng
* @Date: 10:26 2018/10/9
* @param:
* @return:
*/
public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        getAllPermute(nums,new ArrayList<Integer>(),res,used);
        return res;
    }
    public void getAllPermute(int[] nums,List<Integer> curre,List<List<Integer>> res,boolean[] used) {
        if (curre.size()>=nums.length) {
            res.add(new ArrayList<>(curre));
        } else {
            for (int i = 0;i<nums.length;i++) {
                if (used[i] || (i>0 && nums[i] == nums[i-1] && used[i-1]) ) {
                    continue;
                }
                curre.add(nums[i]);
                used[i] = true;
                getAllPermute(nums,curre,res,used);
                used[i] = false;
                curre.remove(curre.size()-1);
            }
        }
    }
    public void exchange(int[] nums,int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        PermutationsII_47 permutationsII_47 = new PermutationsII_47();
        int[] arr = {1,1,2};
        List<List<Integer>> res = permutationsII_47.permuteUnique(arr);
        for (List<Integer> list:res) {
            for (int tmp:list) {
                System.out.print(tmp+" ");
            }
            System.out.println();
        }
    }
}
