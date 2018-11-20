package aboutArray;

import java.util.Arrays;

/**
 * Created by cp
 * data  2018/9/11.
 * description
 *  * 88. �ϲ�������������
 *  �������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣
 *  �Ӻ������������ǰ�ƶ�Ԫ��
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
