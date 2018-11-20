package aboutNumber;

/**
 * Created by cp
 * data  2018/9/14.
 * title :9. Palindrome Number
 * description
 *  Determine whether an integer is a palindrome.
 *  An integer is a palindrome when it reads the same backward as forward.
 */
public class isPalindromeNumber {
    public boolean isPalindrome(int x) {
        String str  = x+"";
        if (str.length() == 0) {
            return false;
        }
        int left = 0,right = str.length()-1;
        while (left<right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindromeNumber palindromeNumber = new isPalindromeNumber();
        boolean res = palindromeNumber.isPalindrome(0);
        System.out.println(res);
    }
}
