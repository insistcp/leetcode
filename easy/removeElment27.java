package leetcodeAgain.easy;

import java.util.Arrays;

/**
 * Created by cp
 * data  2018/9/20.
 * title: 27:remove Element
 * description:
 * 给定一个数组，以及一个元素，现在让你从这个数组中移除这个元素
 */
public class removeElment27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int len = nums.length;
        for (int i = 0;i<len;i++) {
            if (nums[i] != val) {
                nums[start++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        removeElment27 elment27 = new removeElment27();
        int res = elment27.removeElement(arr,3);
        System.out.println(res);
    }
}
