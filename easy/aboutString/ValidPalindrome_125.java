package aboutString;
/**
* @Description:
        给定一个字符串，让你判断这个字符串是否是回文字符串；
* @Author: chenpeng
* @Date: 15:11 2018/11/28
* @param:
* @return:
*/
public class ValidPalindrome_125 {

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        s = s.toLowerCase();
        int left = 0,right = len-1;
        while (left<right) {
            while ((left<right) && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while ((left<right) &&  !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_125 palindrome_125 = new ValidPalindrome_125();
        String str =
                "A man, a plan, a canal: Panama";
        boolean res = palindrome_125.isPalindrome(str);
        System.out.println(res);
    }

}
