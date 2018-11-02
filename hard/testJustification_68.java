package hard;

import java.util.ArrayList;
import java.util.List;
/**
* @Description: 給定一個字符串數組，以及一个长度maxlen，现在让你将这个字符串数组进行格式化处理，
 * 要求格式化后的数组每一行的长度为maxlen,单词长度不够的用" "填充；
* @Author: chenpeng
* @Date: 10:42 2018/11/1
* @param:
* @return:
*/
public class testJustification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int len = words.length;
        int i = 0;
        while (i < len) {
            String tstr = words[i++];
            for (;i<len;i++) {
                if ((tstr+" "+words[i]).length()<=maxWidth) {
                    tstr = tstr+" "+words[i];
                }else {
                    break;
                }
            }
            res.add(tstr);
        }
        List<String> res1 = new ArrayList<>();
        for (int m =0;m<res.size()-1;m++){
            String str = res.get(m);
            String[] strs = str.split(" ");
            int usedLen = str.length()-strs.length+1;
            int spaceLen = maxWidth-usedLen;
            int eveSpace = 0;
            int qianSpace = 0;
            if (strs.length==1) {
                eveSpace = spaceLen;
            } else {
                eveSpace =  spaceLen/(strs.length-1);
                qianSpace =  spaceLen%(strs.length-1);
            }
            String ttstr = "";
            for (int j= 0;j<strs.length;j++) {
                ttstr+=strs[j];
                if (strs.length!=1 && j == strs.length-1) {
                    break;
                }
                for(int s=1;s<=eveSpace;s++) {
                    ttstr+=".";
                }
                if (qianSpace-->0) {
                    ttstr+=".";
                }
            }

            res1.add(ttstr);
        }
        String lasStr = res.get(res.size()-1);
        int spaceLe = maxWidth-lasStr.length();
        for(int s=1;s<=spaceLe;s++) {
            lasStr+=".";
        }
        res1.add(lasStr);
        return res1;
    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        testJustification_68 justification_68 = new testJustification_68();
        List<String> res = justification_68.fullJustify(words, 16);
        for (String str:res) {
            System.out.println(str);
        }
    }
}
