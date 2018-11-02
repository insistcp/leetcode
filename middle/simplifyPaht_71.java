package middle;

import java.util.ArrayList;
import java.util.List;
/** 
* @Description: 给定一个linux的路径，现在让你计算这个路径的最终结果；
 * 例如：
      /a/b/c/../../ ---> /a
      //a//b//c///./ -->/a/b/c
* @Author: chenpeng
* @Date: 11:04 2018/11/1  
* @param: 
* @return:  
*/  
public class simplifyPaht_71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() <= 0) {
            return path;
        }
        String[] arrstr = path.split("/");
        int len = arrstr.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (arrstr[i].trim().equals("") || arrstr[i].trim().equals(".")) {
                continue;
            } else if (arrstr[i].trim().equals("..")) {
                if (res.size()>0) {
                    res.remove(res.size()-1);
                }

            }else {
                res.add("/"+arrstr[i]);
            }
        }
        String str = "";
        for (String s:res) {
            str+=s;
        }
        if (str.equals("")) {
            str="/";
        }
        return str;
    }

    public static void main(String[] args) {
        simplifyPaht_71 paht_71 = new simplifyPaht_71();
        paht_71.simplifyPath("///..");
    }
}
