package middle.aboutGraph;

/**
* @Description:  题目描述：
 * 给定一个字符串str以及一个数字number现在让你将这个字符串打印成number行，
* @Author: chenpeng
* @Date: 14:00 2018/10/23
* @param:
* @return:
*/
public class ZigZagConversion_6 {
    /**
    * @Description:  找规律计算出这个矩阵的列数，然后依次按照之字形填充这个矩阵
    * @Author: chenpeng
    * @Date: 14:02 2018/10/23
    * @param:
    * @return:
    */
    public String convert1(String s, int numRows) {
        if (s == null || numRows == 1) {
            return s;
        }
        int len = s.length();
        int col = (len/(numRows+numRows-2)) * (numRows-1);
        int yu = len%((numRows+numRows-2));
        if (yu>numRows) {
            col+=yu-numRows+1;
        } else {
            col++;
        }
        char[][] dict = new char[numRows][col];
        int idx = 0;
        int i =0 ,j = 0;
        while (idx<len) {
            while (idx<len && i<numRows) {
                dict[i++][j] = s.charAt(idx++);
            }
            i--;
            for (int m = 0;m<numRows-2 && idx<len;m++){
                dict[--i][++j] = s.charAt(idx++);
            }
            --i;
            ++j;
        }
        String res = "";
        for (int m = 0;m<numRows;m++) {

            for (int n = 0;n<col;n++) {
                if (dict[m][n] != '\u0000'){
                    res+=dict[m][n];
                }
            }
        }
        System.out.println(res);
        return res;

    }
    /**
    * @Description:  按照之字形打印字符串；
    * @Author: chenpeng
    * @Date: 13:59 2018/10/23
    * @param:
    * @return:
    */
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();
        int index = 0;
        while(index < s.length()){
            for(int i = 0; i < numRows && index < s.length() ; i++){
                sbs[i].append(s.charAt(index++));
            }
            for(int i = numRows-2; i >=1 && index < s.length(); i--){
                sbs[i].append(s.charAt(index++));
            }
        }
        for (StringBuilder str: sbs) {
            System.out.println(str.toString());
        }
        for(int i = 1; i < sbs.length; i++){
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
    public static void main(String[] args) {
        ZigZagConversion_6 conversion_6 = new ZigZagConversion_6();
        conversion_6.convert("PAYPALISHIRING",2);
    }
}
