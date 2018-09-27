package leetcodeAgain;

/**
 * Created by cp
 * data  2018/9/13.
 * description
 * 4. 两个排序数组的中位数
 * 采用二分查找，不断的排除较小的数组中的一半的元素
 */
public class TwoSortArrMadium4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null){
            return -1;
        }
        if (nums2 == null|| nums2.length == 0) {
            int len = nums1.length;
            int middle = len/2;
            if ( len%2 == 0) {
                return (nums1[middle]+nums1[middle-1])/2.0;
            } else {
                return nums1[middle];
            }
        } else  if (nums1 == null || nums1.length == 0){
            int len = nums2.length;
            int middle = len/2;
            if ( len%2 == 0) {
                return (nums2[middle]+nums2[middle-1])/2.0;
            } else {
                return nums2[middle];
            }
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1+len2;
        int middle = totalLen / 2;
        int middleP = middle - 1;
        int index = 0;
        int i = 0, j = 0;
        if (totalLen % 2 == 0) {
            int number1 = Integer.MIN_VALUE, number2 = Integer.MIN_VALUE;
            while (i < len1 && j < len2 && index <= middleP) {
                if (nums1[i] < nums2[j]) {
                    if (index == middleP) {
                        number1 = nums1[i];
                    }
                    i++;
                    index++;
                } else {
                    if (index == middleP) {
                        number1 = nums2[j];
                    }
                    j++;
                    index++;
                }
            }
            if (number1 != Integer.MIN_VALUE) {
                if (i < len1 && j < len2) {
                    number2 = nums1[i] > nums2[j] ? nums2[j] : nums1[i];
                } else if (i < len1) {
                    number2 = nums1[i];
                } else if (j < len2) {
                    number2 = nums2[j];
                }

                return (number1 + number2) / 2.0;


            } else {
                while (i < len1 && index <= middleP) {
                    if (index == middleP) {
                        number1 = nums1[i];
                    }
                    i++;
                    index++;

                }
                while (j < len2 && index <= middleP) {
                    if (index == middleP) {
                        number1 = nums2[j];
                    }
                    j++;
                    index++;

                }
                if (i < len1 && j < len2) {
                    number2 = nums1[i] > nums2[j] ? nums2[j] : nums1[i];
                } else if (i < len1) {
                    number2 = nums1[i];
                } else if (j < len2) {
                    number2 = nums2[j];
                }
                return (number1 + number2) / 2.0;
            }
        } else {
            int number1 = Integer.MIN_VALUE;
            while (i < len1 && j < len2 && index <= middle) {
                if (nums1[i] < nums2[j]) {
                    if (index == middle) {
                        number1 = nums1[i];
                    }
                    i++;
                    index++;
                } else {
                    if (index == middle) {
                        number1 = nums2[j];
                    }
                    j++;
                    index++;

                }
            }
            if (number1 != Integer.MIN_VALUE) {
                return number1;
            } else {
                while (i < len1 && index <= middle) {
                    if (index == middle) {
                        number1 = nums1[i];
                    }
                    i++;
                    index++;

                }
                while (j < len2 && index <= middle) {
                    if (index == middle) {
                        number1 = nums2[j];
                    }
                    j++;
                    index++;

                }
                return number1;
            }
        }
    }
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, total / 2 + 1);
        }else {
            return (findKth(nums1, 0, nums2, 0, total / 2) + findKth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
        }
    }
    public int findTheTwoSortArrKth(int[] nums1,int a,int[] nums2,int b,int k) {
        if (nums1.length-a>nums2.length-b) {
            return findTheTwoSortArrKth(nums2,b,nums1,a,k);
        }
        if (nums1.length-a <= 0) {
            return nums2[b+k-1];
        }
        if (k == 1){
            return Math.min(nums1[a],nums2[b]);
        }
        int k1 = Math.min(k/2,nums1.length-a);
        int k2 = k-k1;
        if (nums1[a+k1-1]<nums2[b+k2-1]) {
            return findTheTwoSortArrKth(nums1,a+k1,nums2,b,k-k1);
        }  else if (nums1[a+k1-1]>nums2[b+k2-1]) {
            return findTheTwoSortArrKth(nums1,a,nums2,b+k2,k-k2);
        } else {
            return nums1[a+k1-1];
        }
    }
    public int findKth(int[] nums1, int a, int[] nums2, int b, int k) {
        if (nums1.length - a > nums2.length - b) {
            return findKth(nums2, b, nums1, a, k);
        }
        if (nums1.length - a == 0) {
            return nums2[b + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[a], nums2[b]);
        }
        int k1 = Math.min(nums1.length - a, k / 2);
        int k2 = k - k1;
        if (nums1[a + k1 - 1] < nums2[b + k2 - 1]) {
            return findKth(nums1, a + k1, nums2, b, k - k1);
        }else if (nums1[a + k1 - 1] > nums2[b + k2 - 1]) {
            return findKth(nums1, a, nums2, b + k2, k - k2);
        }else {
            return nums1[a + k1 - 1];
        }
    }
    public static void main(String[] args) {
        int[] num1 = {2,3,4};
        int[] num2 = {1};
        TwoSortArrMadium4 sortArrMadium4 = new TwoSortArrMadium4();
        double res  = sortArrMadium4.findMedianSortedArrays(num1,num2);
        System.out.println(res);
    }

}
