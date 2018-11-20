package aboutArray;

import java.util.Arrays;

public class plusOne_66 {
    public int[] plusOne(int[] digits) {
        if (digits == null){
            return digits;
        }
        int len = digits.length;
        int yu = 0;
        for (int i = len-1;i>=0;i--) {
            int tmp = digits[i]+yu;
            if (i==len-1) {
                tmp = tmp+1;
            }
            yu = tmp/10;
            digits[i] = tmp%10;
        }
        if (yu<=0) {
            return digits;
        } else {
            int[] res = new int[len+1];
            res[0] = yu;
            for(int i =1;i<len+1;i++){
                res[i] = digits[i-1];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,9,9};
        plusOne_66 one_66 = new plusOne_66();
        int[] res = one_66.plusOne(arr);
        System.out.println(Arrays.toString(res));
    }
}
