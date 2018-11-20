package classifyAlgorithm;

import java.util.Arrays;

/**
* @Description: topN问题的求解方式：给定一个数组让你求解这个数组的最大或者最小的前n个数字
* @Author: chenpeng
* @Date: 9:44 2018/11/16
* @param:
* @return:
*/
public class topN {
    /***
     *  利用大顶堆或者小顶堆来解决
     *  1：先构建k大小的堆
     *      采用向上浮动的算法
     *  2：再遍历后面的元素跟头结点进行比较
     *      如果比头结点大（topN）则下沉，如果比头结点小则（minN）下沉
     * @param arr
     * @param k
     */
    public void constructStack(int[] arr ,int k) {
        if (k>=arr.length) {
            return;
        }
        for (int i= k-1;i>=0;i--) {
            floatUp(arr,i);
        }
        int len = arr.length;
        for (int i= k;i<len;i++) {
            if (arr[i]>arr[0]) {
                arr[0] = arr[i];
                sink(arr,k);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public void sink (int[] arr,int k) {
        int index = 0;
        while (index<k) {
            int left = 2*index+1;
            int right = left+1;
            if (right<k && arr[right]<arr[left]) {
                left = right;
            }
            if (left>=k || arr[left]>=arr[index]) {
                break;
            }
            exchange(arr,index,left);
            index = left;
        }
    }
    public void floatUp (int[] arr,int i) {
        while (i>0) {
            int father = (i-1)/2;
            if (father>=0 && arr[i]<arr[father]) {
                exchange(arr,i,father);
                i = father;
            } else{
                break;
            }
        }
    }
    public void exchange(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void getTopN(int[] arr,int k) {
        if (arr == null || arr.length<=k) {
            return;
        }

    }

    /***
     * 快速排序：
     * @param arr
     * @param left
     * @param right
     */
    public void fastSort(int[] arr,int left,int right,int k ) {
        if (left>=right) {
            return;
        }
        int index = partation(arr,left,right);
        if (index<(arr.length-k)) {
            return;
        }
        fastSort(arr,left,index-1,k);
        fastSort(arr,index+1,right,k);
    }

    /***
     * 利用快速排序的思想：寻找前k小个数
     * @param a
     * @param start
     * @param end
     * @param k
     * @return
     */
    public int selectK(int a[],int start,int end,int k)
    {
        int index = 0;
        if (start<end) {
            index = partation(a,start,end);
            if (index == k-1) {
                index = k;
            } else if (index<k-1) {
                index= selectK(a,index+1,end,k-index);
            } else {
                index= selectK(a,start,index-1,k);
            }
        }
        return index;
    }

    public int partation(int[] arr,int left,int right) {
        int comp  =arr[left];
        while (left<right) {
            while (left<right && arr[right]>=comp) {
                right--;
            }
            arr[left] = arr[right];
            while (left<right && arr[left]<=comp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = comp;
        return left;
    }
    public static void main(String[] args) {
        int[] arr = {7,4,3,3,2,1,1,8,9,10};
        topN topN = new topN();
       // topN.constructStack(arr,5);
        topN.selectK(arr,0,arr.length-1,4);
        System.out.println(Arrays.toString(arr));

    }
}
