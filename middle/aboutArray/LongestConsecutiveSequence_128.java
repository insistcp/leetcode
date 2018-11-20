package middle.aboutArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:  给定一个没有排序的数组，现在让你计算出这个数组中最长连续数字，要求O(n)时间复杂度
* @Author: chenpeng
* @Date: 10:34 2018/10/15
* @param:
* @return:
*/

public class LongestConsecutiveSequence_128 {
    /**
    * @Description:  O(nlog(n))
    * @Author: chenpeng
    * @Date: 10:33 2018/10/15
    * @param:
    * @return:
    */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int max = 0,curr = 0;
        for (int i = 1;i<len;i++) {
            if (nums[i]-nums[i-1] == 0) {
                continue;
            }
            if (nums[i]-nums[i-1] == 1) {
                curr++;
            } else {
                if (curr > max) {
                    max = curr;
                }
                curr = 0;
            }
        }

        if (curr>max) {
            max = curr;
        }

        return max+1;
    }
    /**
    * @Description: 时间复杂度 O(n) 空间复杂度O（n）
    * @Author: chenpeng
    * @Date: 10:35 2018/10/15
    * @param:
    * @return:
    */
    public int longestConsecutive1(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if ( !map.containsKey(n) ) {
                int left = map.containsKey(n-1) ? map.get(n-1): 0;
                int right = map.containsKey(n+1) ? map.get(n+1) : 0;
                int sum  = left+right + 1;
                if (sum > res) {
                    res = sum;
                }
                map.put(n,sum);
                map.put(n-left, sum);
                map.put(n+right, sum);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4,1,2,3,5,6,7,8,9};
        LongestConsecutiveSequence_128 longestConsecutiveSequence_128 = new LongestConsecutiveSequence_128();
        int res = longestConsecutiveSequence_128.longestConsecutive1(arr);
        System.out.println(res);
    }
}
