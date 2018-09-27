package leetcodeAgain;

import java.util.Arrays;

/**
 * Created by cp
 * data  2018/9/11.
 * description
 *  * 88. 合并两个有序数组
 *  给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *  从后面出发依次向前移动元素
 */
public class mergeSortArr {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = nums1.length-1;
        int i = m-1,j = n-1;
        while (i>=0 && j>=0) {
            if (nums1[i] >= nums2[j]) {
                nums1[index] = nums1[i];
                i--;
                index--;
            } else {
                nums1[index] = nums2[j];
                j--;
                index--;
            }
        }
        while (i>=0) {
            nums1[index--] = nums1[i--];
        }
        while (j>=0) {
            nums1[index--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0};
        int[] arr2 = {1};
        mergeSortArr sortArr = new mergeSortArr();
        sortArr.merge(arr1,0,arr2,1);
        System.out.println(Arrays.toString(arr1));
    }
}
