package middle;
/**
* @Description: 给定一个数组，以及一个数字现在让你判断这个数字是否在这个数组中出现；
* @Author: chenpeng
* @Date: 11:32 2018/11/7
* @param:
* @return:
*/
public class searchInRotatedSortedArrayII_81 {
    /***
     *  设置两个point，left和right；不断移动left和right；
     *  取数组的中点，对有序的一半数组先做处理；
     *  如果两边均无序，则移动终点位置；
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0,right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                return true;
            }
            // 右边有序，左边无序
            if (nums[mid]<nums[right] || nums[mid]<nums[left]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
                // 左边有序，右边无序
            } else if (nums[mid]>nums[left] || nums[mid]>nums[right]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                right--;
            }
        }
        return false;
    }
    public boolean search1(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                //any of the two sides won't change the result but can help remove duplicate from
                //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        return false;
    }

    public int getMin(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int left = 0,right = arr.length-1;
        int minIndex = 0;
        if (arr[left]<arr[right]) {
            return left;
        }
        while (left <= right) {
            if (right-left == 1) {
                minIndex = right;
                break;
            }
            int mid = (left+right)/2;
            if (arr[mid] == arr[left] && arr[mid] ==arr[ right]) {
                minIndex = minInorder(arr,left,right);
                break;
            }
            if (arr[left]<arr[mid]) {
                left = mid;
            } else if (arr[right] > arr[mid]){
                right = mid;
            } else {
                left++;
                right--;
            }
            

        }
        return minIndex;
    }

    private int minInorder(int[]array,int p1,int p2)
    {
        int min = p1;
        for (int i = p1 + 1; i <= p2; i++)
        {
            if(array[min] > array[i])
            {
                min =i;
            }
        }
        return min;
    }


    //2,5,6,0,0,1,2
    //[1,1,2,2,0,0]
    //0
    public static void main(String[] args) {
        int[] arr = {1,1,3,1};
        searchInRotatedSortedArrayII_81 sortedArrayII_81 = new searchInRotatedSortedArrayII_81();
        int res = sortedArrayII_81.getMin(arr);
        System.out.println(res);
        boolean res1 = sortedArrayII_81.search(arr,3);
        System.out.println(res1);
    }
}
