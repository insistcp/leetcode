
import java.util.Arrays;
/**
* @Description:
 * 给定两个有序数组arr1,arr2现在让你将这两个有序数组进行合并；arr2 merge 到arr1中；
* @Author: chenpeng
* @Date: 10:53 2018/11/8
* @param:
* @return:
*/
public class mergeSortedArray_88 {
    /***
     *  转换思路，从后面想前面填充
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        int i = m-1;
        int j = n-1;
        int totallen = m+n-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i]>nums2[j]) {
                nums1[totallen] = nums1[i];
                i--;
            } else {
                nums1[totallen] = nums2[j];
                j--;
            }
            totallen--;
        }
        while (j>=0) {
            nums1[totallen] = nums2[j];
            j--;
            totallen--;
        }
    }

    /***
     * 利用插入排序的思想，将数组二中的元素依次插入到数组1中
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int moLen = m;
        for (int i = 0;i<n;i++) {
            boolean isfind = false;
            for (int j = 0;j<moLen;j++) {
                if (nums1[j] >= nums2[i]) {
                    isfind = true;
                    moLen++;
                    for (int w = moLen-1;w>j;w--) {
                        nums1[w] = nums1[w-1];
                    }
                    nums1[j] = nums2[i];
                    break;
                }
            }
            if (!isfind) {
                nums1[moLen] = nums2[i];
                moLen++;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0,0,0};
        int[] arr2 = {2,5,6};
        mergeSortedArray_88 sortedArray_88 = new mergeSortedArray_88();
        sortedArray_88.merge(arr1,3,arr2,3);
    }
}
