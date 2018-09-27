package leetcodeAgain.easy;

/**
 * Created by cp
 * data  2018/9/22.
 * description: 1 11 21 1211 111221 312211 13112221 用数字描述前面的一个数
 * title : count and Say 38
 *
 */
public class CountAndSay38 {
    public String countAndSay(int n) {
        if (n <= 0){
            return "";
        }
        String res = "1";
        while (--n>0){
            String curr = "";
            for (int i = 0;i<res.length();i++) {
                int currC = 1 ;
                while (i+1<res.length()&&res.charAt(i) == res.charAt(i+1)) {
                    i++;
                    currC++;
                }
                curr+=currC+""+res.charAt(i);
            }
            res = curr;
        }
        return res;
    }

    public static void main(String[] args) {
        CountAndSay38 countAndSay38 = new CountAndSay38();
        for (int i =1;i<11;i++){
            String res =  countAndSay38.countAndSay(i);
            System.out.println(res);
        }
    }
}
