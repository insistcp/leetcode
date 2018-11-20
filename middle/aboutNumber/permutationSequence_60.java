package middle.aboutNumber;

import java.util.*;
/**
* @Description: 给定一个数字n和一个数字k,现在让你用1到n所有的数字进行组合，按照从小到大的顺序排列后的第k个数字返回回来
 *
* @Author: chenpeng
* @Date: 10:57 2018/10/25
* @param:
* @return:
*/
public class permutationSequence_60 {
    /**
    * @Description:   通过找规律，我们发现来定位每一位上的数字；
     * 规律：从高到低的每一位出现的次数是f(n) = (n-1)!次；我们先用一个数组存储每一位出现的次数，
     * 然后找到位置对应的下标；最终返回对应的值。
    * @Author: chenpeng
    * @Date: 10:58 2018/10/25
    * @param:
    * @return:
    */
    public String getPermutation(int n, int k) {
        if (n<=0 || k <= 0) {
            return "";
        }
        List<Integer> num = new ArrayList<>();
        for (int i = 1;i<=n;i++){
            num.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i=1;i<n;i++) {
            fact[i] = i*fact[i-1];
        }
        //将下标归为0；
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n;i>0;i--){
            int index = k/fact[i-1];
            k = k %fact[i-1];
            sb.append(num.get(index));
            num.remove(index);
        }
        return sb.toString();
    }
    public String getPermutation1(int n, int k) {
        if (n<=0 || k <= 0) {
            return "";
        }
        String str = "";
        for(int i=1;i<=n;i++) {
            str+=i;
        }
        char[] arr  = str.toCharArray();
        TreeSet<String> res = new TreeSet<>() ;
        getAllComb(res,arr,0);

        int i =1;
        for (String s:res){
            if (i == k){
                return s;
            }
            i++;
        }
        return "";
    }
    public void getAllComb(Set<String> list,char[] arr,int start  ) {

        if (start>=arr.length){
            list.add(new String(arr));

        } else {
            for (int i = start;i<arr.length;i++) {
                exchange(arr,start,i);
                getAllComb(list,arr,start+1);
                exchange(arr,start,i);
            }
        }

    }
    public void exchange(char[] arr,int i,int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        permutationSequence_60 sequence_60 = new permutationSequence_60();
        String res = sequence_60.getPermutation(3,4);
        System.out.println(res);
    }
}
