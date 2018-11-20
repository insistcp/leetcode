package aboutArray;

import java.util.Arrays;

/**
 * Created by cp
 * data  2018/9/20.
 * title: 27:remove Element
 * description:
 * ����һ�����飬�Լ�һ��Ԫ�أ��������������������Ƴ����Ԫ��
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
