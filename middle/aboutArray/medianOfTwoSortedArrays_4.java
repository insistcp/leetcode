package middle.aboutArray;

/**
* @Description:  给定两个有序的数组，现在让你找到这两个有序数组的中位数；
 * 分情况讨论：
 *  1：如果给出的数组只有一组有效
 *  2：两个数组都有效；
 *      两个数组含有的元素和为奇数和偶数
 *  3：使用下标不断移动
* @Author: chenpeng
* @Date: 10:26 2018/10/23
* @param:
* @return:
*/
public class medianOfTwoSortedArrays_4 {

    /**
    * @Description: 由于总的数组长度既可能是奇数也可能是偶数；
     * 所以调用getKthFromTwoSortArr两次，分别找到（n+m+1）/2 和（n+m+2）/2 位置的数据；
     * 然后取得的结果求和然后再除以2即可得到结果
    * @Author: chenpeng
    * @Date: 10:59 2018/10/23
    * @param:
    * @return:
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n = nums2.length;
        int left = (m+n+1)/2,right = (m+n+2)/2;
        double res1 = getKthFromTwoSortArr(nums1,nums2,0,0,left);
        double res2 = getKthFromTwoSortArr(nums1,nums2,0,0,right);
        return (res1+res2)/2;
    }
    /**
    * @Description: 在两个有序数组中找到第k个数
    * @Author: chenpeng
    * @Date: 10:57 2018/10/23
    * @param:
    * @return:
    */
    public double getKthFromTwoSortArr(int[] nums1,int[] nums2,int i,int j,int k) {
        if (i >= nums1.length) {
            return nums2[j+k-1];
        }
        if (j >= nums2.length) {
            return nums1[i+k-1];
        }
        if (k == 1) {
            return Math.min(nums1[i],nums2[j]);
        }
        int midVali = (i+k/2-1<nums1.length)?nums1[i+k/2-1]:Integer.MAX_VALUE;
        int midValj = (j+k/2-1<nums2.length)?nums2[j+k/2-1]:Integer.MAX_VALUE;
        if (midVali<midValj) {
            return getKthFromTwoSortArr(nums1,nums2,i+k/2,j,k-k/2);
        }  else {
            return getKthFromTwoSortArr(nums1,nums2,i,j+k/2,k-k/2);
        }
    }
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        if (nums1==null || nums1.length == 0) {
            int len2 = nums2.length;
            int mid = len2/2;
            if (len2%2 == 0) {
                return (nums2[mid]+nums2[mid-1])/2.0;
            } else {
                return nums2[mid];
            }
        }
        if (nums2==null || nums2.length == 0) {
            int len1 = nums1.length;
            int mid = len1/2;
            if (len1%2 == 0) {
                return (nums1[mid]+nums1[mid-1])/2.0;
            } else {
                return nums1[mid];
            }
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1+len2;
        if ( total % 2 == 0) {
            int mid  = total/2;
            int index = 0,i = 0,j=0;
            int number1 = nums1[0];
            int number2 = nums2[0];
            while (i<len1 && j<len2 && index<=mid-1) {
                if (nums1[i]<nums2[j]) {
                    number1 = nums1[i];
                    i++;
                } else {
                    number1 = nums2[j];
                    j++;
                }
                index++;
            }
            if (index<=mid-1) {
                if (i<len1) {
                    while(index<=mid-1 && i<len1){
                        number1 = nums1[i];
                        i++;
                        index++;
                    }
                    number2 = nums1[i];

                } else if (j<len2) {
                    while(index<=mid-1 && j<len2){
                        number1 = nums2[j];
                        j++;
                        index++;
                    }
                    number2 = nums2[j];
                }
                return (number1+number2)/2.0;
            } else {
                if (i<len1 && j<len2){
                    number2 = Math.min(nums1[i],nums2[j]);
                } else if (i<len1) {
                    number2 = nums1[i];
                } else if (j<len2) {
                    number2 = nums2[j];
                }
                return (number1+number2)/2.0;
            }


        } else {
            int mid  = total/2;
            int index = 0,i = 0,j=0;
            int number1 = nums1[0];
            while (i<len1 && j<len2 && index<=mid) {
                if (nums1[i]<nums2[j]) {
                    number1 = nums1[i];
                    i++;
                } else {
                    number1 = nums2[j];
                    j++;
                }
                index++;
            }

            while(index<=mid && i<len1){
                number1 = nums1[i];
                i++;
                index++;
            }

            while(index<=mid && j<len2){
                number1 = nums2[j];
                j++;
                index++;
            }
            return number1;

        }
    }

    public static void main(String[] args) {
        int[] arr1= {2,3};
        int[] arr2= {1};
        medianOfTwoSortedArrays_4 twoSortedArrays_4 = new medianOfTwoSortedArrays_4();
        double res = twoSortedArrays_4.findMedianSortedArrays(arr1,arr2);
        System.out.println(res);
    }
}
