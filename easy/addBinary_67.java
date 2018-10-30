/**
* @Description: 给定两个二进制的字符串，让你求这两个二进制字符串的和
* @Author: chenpeng
* @Date: 13:39 2018/10/30
* @param:
* @return:
*/
public class addBinary_67 {

    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return a;
        }
        if (a == null) {
            return b;
        }
        if ( b == null) {
            return a;
        }
        int alen = a.length();
        int blen = b.length();
        int i = alen-1,j = blen-1;
        StringBuilder res = new StringBuilder();
        int yu = 0;
        while (i>=0 && j >= 0) {
            int at = a.charAt(i)-'0';
            int bt = b.charAt(j)-'0';
            int tt = at+bt+yu;
            if (tt > 1) {
                if (tt>2) {
                    res.append(1);
                    yu = tt-2;
                } else {
                    res.append('0');
                    yu = tt-1;
                }

            } else {
                res.append(tt);
                yu = 0;
            }
            i--;
            j--;
        }
        while(i>=0) {
            int at = a.charAt(i)-'0';
            int tt = at+yu;
            if (tt > 1) {
                if (tt>2) {
                    res.append(1);
                } else {
                    res.append('0');
                }
                yu = tt-1;
            } else {
                res.append(tt);
            }
            i--;
        }
        while(j>=0) {
            int bt = b.charAt(j)-'0';
            int tt = bt+yu;
            if (tt > 1) {
                if (tt>2) {
                    res.append(1);
                } else {
                    res.append('0');
                }
                yu = tt-1;
            } else {
                res.append(tt);
            }
            j--;
        }
        if (yu!=0) {
            res.append(yu);
        }
        return res.reverse().toString();
    }
//"1010"
//"1011"
    public static void main(String[] args) {
        String str1 = "1010";
        String str2 = "1011";
        addBinary_67 binary_67 = new addBinary_67();
        String res = binary_67.addBinary(str1,str2);
        System.out.println(res);
    }
}
