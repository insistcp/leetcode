package aboutArray;

/**
 * Created by cp
 * data  2018/9/10.
 * description
 * 81-������ת�������� II
 * �Ѷȣ��е�
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * ( ���磬���� [0,0,1,2,2,5,6] ���ܱ�Ϊ [2,5,6,0,0,1,2] )��
 * ��дһ���������жϸ�����Ŀ��ֵ�Ƿ�����������С������ڷ��� true�����򷵻� false��
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
