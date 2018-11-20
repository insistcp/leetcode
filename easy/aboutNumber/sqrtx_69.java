package aboutNumber;

/**
* @Description: 给定一个数字让你求这个数字的开方
* @Author: chenpeng
* @Date: 11:13 2018/10/31
* @param:
* @return:
*/
public class sqrtx_69 {
    /**
     * 使用二分法查找
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 1,right = x;
        while (left<right) {
            int middel = left+(right-left)/2;
            if (middel > x/middel) {
                right = middel-1;
            } else {
                if (middel+1 > x/(middel+1)) {
                    return middel;
                }
                left = middel+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int number = 6;
        sqrtx_69 sqrtx_69 = new sqrtx_69();
        int res = sqrtx_69.mySqrt(number);
        System.out.println(res);
    }
}
