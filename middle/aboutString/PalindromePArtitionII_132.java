package middle.aboutString;

/**
* @Description:  给定一个字符串，现在让你将这个字符串进行分割，
 * 要求分割后的字符串每一个都是一个回文字符串，让你找到最少的分割次数
* @Author: chenpeng
* @Date: 12:38 2018/10/18
* @param:
* @return:
*/
public class PalindromePArtitionII_132 {
    /**
    * @Description: 时间复杂度O(nlog(n)) ;空间复杂度 O（n^2）
    * @Author: chenpeng
    * @Date: 12:44 2018/10/18
    * @param:
    * @return:
    */
    public int minCut(String s) {
        if (s == null || s.length() == 1 || isPalindrome(s)) {
            return 0;
        }
        int len = s.length();
        int[] stArr = new int[len];
        boolean[][] dp = new boolean[len][len];
        for (int i =0;i<len;i++) {
            int min = i;
            for (int j = 0;j<=i;j++) {
                if (s.charAt(j) == s.charAt(i) && (j+1 > i-1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if (j==0) {
                        min = 0;
                    } else {
                        min = Math.min(min,stArr[j-1]+1);
                    }
                }
            }
            stArr[i] = min;
        }
        return stArr[len-1];
    }


    private int max = Integer.MAX_VALUE;
    public int minCut1(String s) {
        if (s == null || s.length() == 1 || isPalindrome(s)) {
            return 0;
        }
        getAllCombine(0,s,0);
        return max-1;
    }
    public void getAllCombine( int start, String str,int cut) {
        if (start >= str.length()) {
            if(max > cut){
                max = cut;
            }
            return;
        } else {
            for (int i = start;i<str.length();i++){
                String tmp = str.substring(start,i+1);
                if (isPalindrome(tmp)) {
                    cut++;
                    getAllCombine( i+1,str,cut);
                    cut--;
                }
            }
        }
    }
    public boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return true;
        }
        int left = 0,right = str.length()-1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePArtitionII_132 pArtitionII132 = new PalindromePArtitionII_132();
        String str = "abb";
        int res = pArtitionII132.minCut(str);
        System.out.println(res);
    }
}
