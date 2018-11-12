package middle;

import java.util.ArrayList;
import java.util.List;
/**
* @Description: 给定一个由数字组成的字符串，现在让你将这个字符串进行分割，使得分割后的字符串能够组成合法的IP地址
 * 让你返回所有可能的组合；
* @Author: chenpeng
* @Date: 11:45 2018/11/12
* @param:
* @return:
*/
public class restoreIPAddress_93 {
    /***
     * 求解组合的通用解法，递归；
     * 由于每一个IP地址的一个数字只能出现1-3位，对于前3个位我们一次截取1-3，然后进行合法性判断；
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        GetAllIllegalIP(res,s,0, new ArrayList<>());
        return res;
    }
    public void GetAllIllegalIP(List<String> res,String s,int index,List<String> arr) {
        if (arr.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i<3;i++) {
                sb.append(arr.get(i));
                sb.append(".");
            }
            sb.append(arr.get(3));
            res.add(sb.toString());
        } else {
            if (s.length()-index>3*(4-arr.size())) {
                return;
            }
            if (arr.size() == 3) {
                String tmp = s.substring(index);
                if (isIllegalNumber(tmp)) {
                    arr.add(tmp);
                    GetAllIllegalIP(res, s, s.length(), arr);
                    arr.remove(arr.size() - 1);
                }
            } else {
                for (int i = 1; i <= 3; i++) {
                    int end = s.length()>(index+i)?index+i:s.length();
                    String tmp = s.substring(index, end);
                    if (isIllegalNumber(tmp)) {
                        arr.add(tmp);
                        GetAllIllegalIP(res, s, end, arr);
                        arr.remove(arr.size() - 1);
                    }
                }
            }
        }
    }
    public boolean isIllegalNumber(String str) {
        if (str.isEmpty()) {
            return false;
        }
        if (str.length()>1 && str.startsWith("0")) {
            return false;
        }
        Integer val = Integer.valueOf(str);
        if (val>255 || val<0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        restoreIPAddress_93 ipAddress_93 = new restoreIPAddress_93();
        String str = "010010";
        List<String> res = ipAddress_93.restoreIpAddresses(str);
        for (String s:res) {
            System.out.println(s);
        }
    }
}
