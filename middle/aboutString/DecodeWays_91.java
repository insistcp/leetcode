package middle.aboutString;

/**
* @Description: 给定一个字符串先让让你对这个字符串进行分割；
 * 使得字符串使得分割后的字符串每一个子字符串都再1-26之间，问题有多少种分割方式；
* @Author: chenpeng
* @Date: 10:57 2018/11/9
* @param:
* @return:
*/
public class DecodeWays_91 {
    public int numDecodings2(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        for (int i = len-1;i>=0;i--) {
            if(s.charAt(i)=='0')
                dp[i]=0;
            else {
                dp[i] = dp[i+1];
                if(i<len-1 && (s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7'))
                    dp[i]+=dp[i+2];
            }
        }
        return dp[0];
    }
    public int numDecodings(String s) {
        int p = 1, pp = 0, n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int cur = s.charAt(i)== '0' ? 0 : p;
            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7'))
                cur += pp;
            pp = p;
            p = cur;
        }
        return s.isEmpty() ? 0 : p;
    }
    private int res = 0;
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        if (s.charAt(0)=='0') {
            return res;
        }
        getAllComb(s,0);
        return res;
    }
    public void getAllComb(String s,int index) {
        if (index>=s.length()) {
            res++;
        } else {
            for (int j = 1;j<=2;j++) {
                if (index+j>s.length()) {
                    continue;
                }
                int sub = Integer.valueOf(s.substring(index,index+j));
                if (sub == 0) {
                    return;
                }
                if (sub<=26 && sub>0) {
                    getAllComb(s,index+j);
                }
            }
        }
    }

    public static void main(String[] args) {
        DecodeWays_91 ways_91 = new DecodeWays_91();
        String str = "101";
        int res =  ways_91.numDecodings2(str);
        System.out.println(res);
    }
}
