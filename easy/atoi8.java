package leetcodeAgain;

/**
 * Created by cp
 * data  2018/9/13.
 *  description
 *  将一个字符串转化为一个int类型的数字，要求大于int范围的返会最大或者最小值
 */
public class atoi8 {
    public int myAtoi(String str) {
        if(str.length()<=0){
            return 0;
        }
        str  =str.trim();
        if( str.length()<=0){
            return 0;
        }
        int len1 = str.length();
        int i =0;
        for (;i<len1;i++) {
            if (i == 0){
                if (str.charAt(i)=='+' || str.charAt(i) == '-') {
                    if(i==len1-1){
                        return 0;
                    }
                    continue;
                } else if (str.charAt(i)<'0' || str.charAt(i)>'9'){
                    return 0;
                }
                continue;
            }
            if (str.charAt(i)<'0' || str.charAt(i)>'9') {
                break;
            }
        }
        boolean isPositive = true;
        if (str.charAt(0) == '+'){
            str = str.substring(1,i);
            if (str.length()==0) {
                return 0;
            }

        } else if (str.charAt(0) == '-'){
            str = str.substring(1,i);
            isPositive = false;
            if (str.length()==0) {
                return 0;
            }
        } else {
            str = str.substring(0,i);
        }

        double res = 0;
        for (int j = 0;j<str.length();j++) {
            res = res*10+(str.charAt(j)-'0');
        }
        if (!isPositive) {
            res=-res;
        }
        if (res>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        } else {
            return (int)res;
        }
    }

    public static void main(String[] args) {
        String str = "+-2";
        atoi8 atoi  = new atoi8();
        int res = atoi.myAtoi(str);
        System.out.println(res);
    }
}
