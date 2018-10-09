package middle;
/**
* @Description:  给定一个double类型的数，现在让你求解这个数的n次方
* @Author: chenpeng
* @Date: 11:20 2018/10/9
* @param:
* @return:
*/
public class Pow_50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return x / x;
        }
        if (n<0){
            n = -n;
            x = -x;
        }
        return n%2==0 ? myPow(x*x,n/2):x*myPow(x*x,n/2);
    }
    public double myPowFei(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) {
                ans *= x;
            };
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
    //2.00000, -2 2.10000, 3  2.00000, 10 0.00001
    //2147483647
    public static void main(String[] args) {
        Pow_50 pow_50 = new Pow_50();
        double number = 2.00000;
        int n = 10;
        System.out.println(pow_50.myPowFei(number,n));
    }
}
