package leetcodeAgain;

/**
 * Created by cp
 * data  2018/9/10.
 * description
 * 81-搜索旋转排序数组 II
 * 难度：中等
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 */
public class rotateArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length==0) {
            return false;
        }
        int index  = getIndexOfMin(nums);
        if (nums[index] == target) {
            return true;
        }
        if (nums[index]>target) {
            return false;
        }
        if (index == 0) {
            if (target>nums[nums.length-1]) {
                return false;
            }
            int indexT = getIndex(nums,0,nums.length-1,target);
            if (indexT != -1) {
                return true;
            } else {
                return false;
            }
        } else {
            if (nums[index-1]<target) {
                return false;
            }
            if (index == nums.length-1) {
                int res = getIndex(nums,0,index-1,target);
                if (res != -1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (target > nums[nums.length-1]) {
                    int res = getIndex(nums,0,index-1,target);
                    if (res != -1) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    int res = getIndex(nums,index+1,nums.length-1,target);
                    if (res != -1) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

    }
    public int getIndex(int[] arr,int left ,int right,int target) {
        while (left<=right) {
            int index = left+(right-left)/2;
            if (arr[index] == target) {
                return index;
            } else if (arr[index] > target) {
                right = index-1;
            } else {
                left = index+1;
            }
        }
        return -1;
    }
    public int getIndexOfMin(int[] arr) {
        int left = 0,right = arr.length-1;
        while (left < right && arr[left]>= arr[right]){
            if (arr[left] <= arr[left+1]) {
                left = left+1;
            } else {
                return left+1;
            }
            if (arr[right] >= arr[right-1]) {
                right = right-1;
            } else {
                return right;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0};
        rotateArrayII arrayII = new rotateArrayII();
        boolean index = arrayII.search(arr,1);
        System.out.println(index);
    }
}
