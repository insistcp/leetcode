package leetcodeAgain.hard;

import java.util.Stack;

/**
 * Created by cp
 * data  2018/9/21.
 * description ：給定一個只包含（）的字符串，让你求最长的有效的括号是多少
 * title: Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 */
public class LongestValidParenteses32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length()<=1) {
            return 0;
        }
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int returnValue = 0,lastValidIndex = 0;

        for (int i = 0;i < len;i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    lastValidIndex = i+1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        returnValue = Math.max(returnValue,i-lastValidIndex+1);
                    } else {
                        returnValue = Math.max(returnValue,i-stack.peek());
                    }
                }
            }
        }

        return returnValue;
    }

    public static void main(String[] args) {
        String str = "(()(((()";
        LongestValidParenteses32 longestValidParenteses32 = new LongestValidParenteses32();
        int res = longestValidParenteses32.longestValidParentheses(str);
        System.out.println(res);
    }
}
