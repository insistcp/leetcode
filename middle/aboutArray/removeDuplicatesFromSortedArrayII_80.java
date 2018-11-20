package middle.aboutArray;

/**
* @Description:
    给定一个排序的数组，现在让你重构这个数组，要求每一个元素出现的次数最多2次；
* @Author: chenpeng
* @Date: 11:08 2018/11/6
* @param:
* @return:
*/
public class removeDuplicatesFromSortedArrayII_80 {
    /***
     * 遍历数组一次对比当前元素值和前一个元素的值来进行判断
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length==0) {
            return 0;
        }
        int n = nums.length;
        int i = 1;
        int orgi = nums[0];
        int count = 1;
        int indx = 1;
        while (i < n) {
            if (nums[i] == orgi) {
                count++;
                if (count<=2) {
                    nums[indx++] = nums[i];
                }
            } else {
                orgi = nums[i];
                count = 1;
                nums[indx++] = nums[i];
            }
            i++;
        }
        return indx;
    }

    /***
     * 更巧的方式：利用数组的有序的特性，设置一个全局的下表，让当前遍历的元素比他前面两个元素都大时表示该元素可以放入到队列中；
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
       int i = 0;
       for (int num:nums) {
           if (i<2 || num>nums[i-2]) {
               nums[i++] = num;
           }
       }
       return i;
    }
    public int removeDuplicates1(int[] nums) {
        if(nums==null ||nums.length==0)return 0;
        int i=1,ind=1,count=1;
        int original=nums[0];
        int n=nums.length;

        while(i<n){
            if(nums[i]==original){
                original=nums[i];
                count++;
                if(count<=2){
                    nums[ind++]=nums[i];
                }
                i++;
            } else{
                original=nums[i];
                count=1;
                nums[ind++]=nums[i];
                i++;
                //System.out.println("i: "+i+" count:"+count+ " ind: "+ind+"num: "+nums[i]);

            }
        }
        return ind;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        removeDuplicatesFromSortedArrayII_80 duplicatesFromSortedArrayII_80 = new removeDuplicatesFromSortedArrayII_80();
        int res = duplicatesFromSortedArrayII_80.removeDuplicates(arr);
        System.out.println(res);
    }
}
