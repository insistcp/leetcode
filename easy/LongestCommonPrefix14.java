package leetcodeAgain.easy;

/**
 * Created by cp
 * data  2018/9/15.
 * description
 * title:14. Longest Common Prefix
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        int minLens =Integer.MAX_VALUE;
        for (int i = 0;i<len;i++){
            if (strs[i].length()<minLens){
                minLens = strs[i].length();
            }
        }
        StringBuilder sb =new StringBuilder();
        for (int i=0;i<minLens;i++){
            char stander = strs[0].charAt(i);
            for (int j = 1;j < len;j++) {
                if (stander != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(stander);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"","aedd",""};
        LongestCommonPrefix14 commonPrefix14 = new LongestCommonPrefix14();
        String res = commonPrefix14.longestCommonPrefix(strs);
        System.out.println(res);
    }
}
