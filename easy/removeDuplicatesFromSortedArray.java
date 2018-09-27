package leetcodeAgain.easy;

import java.util.Arrays;

/**
 * Created by cp
 * data  2018/9/18.
 * description
 */
public class removeDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length<0){
            return 0;
        }
        int len = nums.length;
        int count = len;
        for(int i= 1;i<count;i++){
            boolean isRepeat = false;
            int start = i;
            int end = count;
            while (nums[start] == nums[start-1]) {
                start++;
                count--;
                isRepeat = true;
                if (start>=end){
                    break;
                }
            }
            if(isRepeat) {
                int index = i;
                for(int j = start;j<len;j++){
                   nums[index++] = nums[j];
                }
            }
        }

        return count;
    }
    public int removeDuplicateEle(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int start = 0;
        int len = arr.length;
        for(int i = 1;i<len;i++) {
            if(arr[start] != arr[i]){
                arr[++start] = arr[i];
            }
        }
        return start+1;
    }
    public static void main(String[] args) {
        removeDuplicatesFromSortedArray duplicatesFromSortedArray = new removeDuplicatesFromSortedArray();
        int[] arr = {0,0};
        int res0 = duplicatesFromSortedArray.removeDuplicateEle(arr);
        System.out.println(res0);
        System.out.println(Arrays.toString(arr));

    }
}

