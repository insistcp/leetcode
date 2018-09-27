package leetcodeAgain;

/**
 * Created by cp
 * data  2018/9/12.
 * description:7. 反转整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 */
public class reverseInteger7 {
    public int reverse(int x) {

        int left = 0;
        if (x<0) {
            left++;
        }
        char[] str = (x+"").toCharArray();
        if (str.length<=1){
            return Integer.valueOf(x);
        }
        int len = str.length;
        int right = len-1;
        while (left<right){
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
        Long res =Long.valueOf(new String(str));
        if (res>Integer.MAX_VALUE ||res<Integer.MIN_VALUE){
            return 0;
        }
        return res.intValue();
    }

    public static void main(String[] args) {
        int str = 483648;
        reverseInteger7 integer7 = new reverseInteger7();
        int res = integer7.reverse(str);
        System.out.println(res);
    }
}
