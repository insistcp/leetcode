package aboutString;

/**
* @Description:  给定一个字符串让你求这个字符串最后一个单词的长度
* @Author: chenpeng
* @Date: 11:09 2018/10/24
* @param:
* @return:
*/
public class lengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length()<1){
            return 0;
        }
        s = s.trim();
        int len = s.length(),count = 0;
        for (int i= len-1;i>=0;i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = " ";
        lengthOfLastWord_58 lastWord_58 = new lengthOfLastWord_58();
        int res =  lastWord_58.lengthOfLastWord(str);
        System.out.println(res);
    }
}
