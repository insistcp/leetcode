package hard.aboutNumber;
/**
* @Description: 给定一个数字让你判断这个数组是否是有效的数字
* @Author: chenpeng
* @Date: 10:26 2018/10/31
* @param:
* @return:
*/
public class validNumber_65 {
    /**
     * 设置4个变量分别是
     * hasE= false e是否出现
     * hasP = false, .是否出现
     * hasNum = false, 是否有数字
     * ehasAfterNumber = false, e后面是否有数字出现
     * 规则
     * 1：小数点和e都只能出现一次
     * 2：小出现出现在e的前面
     * 3：e后面必须有数字
     * 4：+-号只能出现在第一位或者e的后面
     * @param s
     * @return
     */
    public boolean isNumber2(String s) {
        if(s == null) {
            return false;
        }
        s = s.trim();
        int len = s.length();
        boolean hasE= false, hasP = false,hasNum = false,ehasAfterNumber = false;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i)>='0'&& s.charAt(i)<='9') {
                hasNum = true;
                ehasAfterNumber = true;
            } else if (s.charAt(i) == '.') {
                if (hasE || hasP) {
                    return false;
                }
                hasP  = true;
            } else if (s.charAt(i) == 'e') {
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                ehasAfterNumber = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return hasNum && ehasAfterNumber;
    }
    public boolean isNumber1(String s) {
        if ( s == null ) {
            return false;
        }
        s = s.trim();
        int len = s.length();
        if (len <= 0) {
            return false;
        }
        boolean hasE = false,hasP = false,hasNu = false,eLea = false,pLea = false,pPosZ = false;
        int ep = -1;
        for (int i = 0;i<len;i++) {
            char tmp = s.charAt(i);
            if (i == 0 && (tmp=='+' || tmp == '-')) {
                continue;
            }
            if ((hasP || hasE) && tmp == '.') {
                return false;
            }
            if (tmp == 'e') {
                if (!hasNu || hasE) {
                    return false;
                }
                if (i == len-1 || (pPosZ && hasP && !pLea)) {
                    return false;
                }
                hasE = true;
                ep = i;
                continue;
            }
            if (tmp == '.') {
                if (i == 0) {
                   pPosZ = true;
                }
                hasP = true;
                continue;
            }
            if ((tmp == '-'|| tmp == '+') && hasE && (i-1==ep)) {
                continue;
            }
            if (tmp>'9' || tmp < '0') {
                return false;
            }
            hasNu = true;
            if (hasE) {
                eLea = true;
            }
            if (hasP) {
                pLea = true;
            }
        }
        if(!hasNu || (hasE &&! eLea)) {
           return false ;
        }

        return true;
    }
    // 6e-1
    public static void main(String[] args) {
        String str1 ="459277e38+";
        validNumber_65 number_65 = new validNumber_65();
        boolean  res = number_65.isNumber2(str1);
        System.out.println(res);
    }
}
