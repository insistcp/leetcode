
/**
* @Description:  给定一个整数，现在让你讲他逆序输出，超过int类型的最大值和最小值都会给你返回0；
* @Author: chenpeng
* @Date: 10:26 2018/10/24
* @param:
* @return:
*/
public class reverseInteger_7 {
    public int reverse(int x) {
        boolean flag = false;
        if (x<0){
            if (x == Integer.MIN_VALUE){
                return 0;
            }
            flag = true;
            x = Math.abs(x);
        }
        String str = x+"";
        if (str.length() < 2){
            return Integer.valueOf(x);
        }
        int len  = str.length();
        char[] arr = str.toCharArray();
        int left = 0,right = len-1;
        while (left<right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        Long rtvalue = Long.valueOf(new String(arr));
        if (rtvalue>Integer.MAX_VALUE || (flag&&-rtvalue<Integer.MIN_VALUE)){
            return 0;
        }
        int  res = rtvalue.intValue();
        return flag?-res:res;
    }

    public static void main(String[] args) {
        int number = -2147483648;
        reverseInteger_7 integer_7 = new reverseInteger_7();
        int res = integer_7.reverse(number);
        System.out.println(res);
    }
}
