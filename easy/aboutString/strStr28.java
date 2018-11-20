package aboutString;

/**
 * Created by cp
 * data  2018/9/21.
 * description��ʵ��һ���ַ������Һ���
 * title:strStr().
 */
public class strStr28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        return haystack.indexOf(needle);
    }
}
