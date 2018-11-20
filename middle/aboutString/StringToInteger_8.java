package middle.aboutString;
/**
* @Description:  给定一个字符串让你将这个字符串转化为int类型的数字，如果不能转化则返回0；
* @Author: chenpeng
* @Date: 11:00 2018/10/24
* @param:
* @return:
*/
public class StringToInteger_8 {
    public int myAtoi(String str) {
        if (str == null || str.trim().length()==0){
            return 0;
        }
        str = str.trim();
        str = getNumberString(str);
        if (str.equals("")){
            return 0;
        }
        boolean isfu = false;
        if (str.startsWith("+")){
            str = str.substring(1,str.length());
        }
        if (str.startsWith("-")){
            str = str.substring(1,str.length());
            isfu = true;
        }
        long val = 0;
        int tlen =  str.length();
        int index = 0;
        int big = 10;
        while (index<tlen) {
            val= val*big + (str.charAt(index)-'0');
            if (isfu && -val <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (!isfu && val>= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            index++;
        }
        val = isfu?-(Long.valueOf(val).intValue()):Long.valueOf(val).intValue();
        if (val>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else if (val<Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)val;
        }
    }
    /**
    * @Description: 截取有效的数字字符串
    * @Author: chenpeng
    * @Date: 11:00 2018/10/24
    * @param:
    * @return:
    */
    public String getNumberString(String str) {
        int len = str.length();
        String res = "";
        for (int i = 0;i<len;i++){
            if (i==0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                res+=str.charAt(i);
            } else if (str.charAt(i)>='0' && str.charAt(i)<='9'){
                res+=str.charAt(i);
            } else {
                break;
            }
        }
        if ( res.equals("-") || res.equals("+")){
            return "";
        }
        return res;
    }

    public static void main(String[] args) {
        String str ="-2147483648";
        StringToInteger_8 toInteger_8 = new StringToInteger_8();
        int res = toInteger_8.myAtoi(str);
        System.out.println(res);
        String tmp = toInteger_8.getNumberString(str);
        System.out.println(tmp);
    }
}
