package aboutString;

import java.util.Arrays;

/**
 * Created by cp
 * data  2018/9/12.
 * description： Z字形打印字符串
 *
 */
public class zigZagConversion {
    public static  String convert(String s, int numRows) {
        if (s == null || s.length()<=0) {
            return s;
        }
        if (numRows <=1){
            return s;
        }
        int len  = s.length();
        // 计算一共有多少列
        int col = (len/(numRows+numRows-2)) * (numRows-1);
        // 如果有余数表示我们还需要再增加一列
        int yu = len%((numRows+numRows-2));
        if (yu>numRows) {
            col+=yu-numRows+1;
        } else {
            col++;
        }
        char[][] matrix = new char[numRows][col];
        int index = 0,i = 0,j = 0;

        while (index<len) {
            while (i < numRows &&index<len) {
                matrix[i][j] = s.charAt(index);
                i++;
                index++;
            }
            i--;
            while (i > 0 &&index < len) {
                matrix[--i][++j] = s.charAt(index);
                index++;
            }
            i++;
        }
        String res = "";
        for (int m = 0;m<numRows;m++) {
            System.out.println(Arrays.toString(matrix[m]));
            for (int n = 0;n<col;n++) {
                if (matrix[m][n] != '\u0000'){
                    res+=matrix[m][n];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        String res = convert(str,3);
        System.out.println(res);
    }
}
