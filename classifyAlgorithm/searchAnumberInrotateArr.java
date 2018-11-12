package classifyAlgorithm;
/**
* @Description:  给定一个有序的数组，现在对这个数组进行一定的旋转，
 * 现在让你找到这个数组中最小元素
* @Author: chenpeng
* @Date: 14:11 2018/11/7
* @param:
* @return:
*/
public class searchAnumberInrotateArr {
    public int findMin(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int left = 0,right = arr.length-1;
        int minIndex = 0;
        while (left <= right) {
            int mid = (left+right)/2;
            if (right-left == 1) {
                minIndex =  right;
                break;
            }
            if (arr[left] == arr[mid] && arr[right] == arr[mid]) {
                minIndex =  getMinIndex(arr, left, right);
                break;
            }
            if (arr[left] <arr[mid]) {
                left = mid;
            } else if (arr[right]>arr[mid]) {
                right = mid;
            } else {
                left++;
                right--;
            }
        }
        return minIndex;
    }
    public int getMinIndex(int[] arr,int left,int right) {
        int min = left;
        for (int i = left+1;i<=right;i++) {
            if (arr[i]<arr[min]) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        searchAnumberInrotateArr inrotateArr = new searchAnumberInrotateArr();
        int res = inrotateArr.findMin(arr);
        System.out.println(res);
    }
}
