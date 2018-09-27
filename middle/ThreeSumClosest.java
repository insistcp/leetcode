package leetcodeAgain.middle;

import java.util.Arrays;

/**
 * Created by cp
 * data  2018/9/15.
 * title:16. 3Sum Closest
 * description
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length<3) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int minDis = Integer.MAX_VALUE;
        int returnV = target;
        for (int i = 0;i<=len-2;i++){
            int t_target = target-nums[i];
            int left = i+1,right = len-1;
            while (left<right) {
                int sumT = nums[left]+nums[right];
                int dis = t_target-sumT;
                if (minDis>Math.abs(dis)){
                    minDis = Math.abs(dis);
                    returnV = sumT+nums[i];
                }
                if (dis == 0) {
                    return target;
                } else if (dis>0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return returnV;
    }

    public static void main(String[] args) {
        //[1,1,1,0]
        //-100
        int[] arr = {1,1,1,0};
        int target = -100;
        ThreeSumClosest sumClosest = new ThreeSumClosest();
        int res = sumClosest.threeSumClosest(arr,target);
        System.out.println(res);
    }
}
