package hard.aboutString;

import java.util.*;

/**
 * Created by cp
 * data  2018/9/20.
 * description
 * title : 30:Substring with Concatenation of All Words
 * 给定一个字符串以及一个字符串数组现在让你找出这个字符串数组拼接成的字符串在sourStr中是否存在，
 * 如果存在返回对应的下标
 */
public class subStringWithConcatenationOfAllWords30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list  = new ArrayList<>();
        if (s == null || words == null || s.length() <=0 || words.length<=0){
            return list;
        }
        int len = words.length,n = s.length();
        int pace = words[0].length();
        Map<String,Integer> map = new HashMap<>();
        for (int i= 0;i<len;i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for (int i =0;i<pace;i++) {
            Map<String,Integer> tmpMap = new HashMap<>();
            int low = i;
            int count = 0;
            for (int j= i;j+pace<=n;j+=pace) {
                String subSting = s.substring(j,j+pace);
                if (map.containsKey(subSting)) {
                    tmpMap.put(subSting,tmpMap.getOrDefault(subSting,0)+1);
                    count++;
                    while(tmpMap.get(subSting)>map.get(subSting)){
                        String strt = s.substring(low,low+pace);
                        tmpMap.put(strt,tmpMap.get(strt)-1);
                        count--;
                        low = low+pace;
                    }
                    if (count == len) {
                        list.add(low);
                        String strt = s.substring(low,low+pace);
                        tmpMap.put(strt,tmpMap.get(strt)-1);
                        count--;
                        low = low+pace;
                    }
                } else {
                    tmpMap.clear();
                    low=j+pace;
                    count = 0;
                }
            }
        }
        return list;
    }
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (s.isEmpty() || s == null || words.length == 0) return res;
        int wl = words[0].length(), n = s.length(), m = words.length;
        HashMap<String, Integer> map = new HashMap<>();

        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);

        for (int i = 0; i < wl; i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            int count = 0;
            int lo = i;
            for (int hi = i; hi + wl <= n; hi += wl) {
                String sHi = s.substring(hi, hi + wl);
                if (map.containsKey(sHi)) {
                    temp.put(sHi, temp.getOrDefault(sHi, 0) + 1);
                    count++;
                    while (temp.get(sHi) > map.get(sHi)) {
                        String sLo = s.substring(lo, lo + wl);
                        temp.put(sLo, temp.get(sLo) - 1);
                        count--;
                        lo += wl;
                    }
                    if (count == m) {
                        res.add(lo);
                        String sLo = s.substring(lo, lo + wl);
                        temp.put(sLo, temp.get(sLo) - 1);
                        count--;
                        lo += wl;
                    }
                } else {
                    temp.clear();
                    count = 0;
                    lo = hi + wl;
                }
            }
        }

        return res;
    }
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return list;
        }
        findAllComb(list,words,s,0);
        return list;
    }
    public void findAllComb (List<Integer> list,String[] words,String sourStr,int start) {
        if (start>=words.length) {
            String str = "";
            int len = words.length;
            for (int i = 0;i<len;i++) {
                str+=words[i];
            }
            int index = sourStr.indexOf(str);
            while (index>=0) {
                if (!list.contains(index)){
                    list.add(index);
                }
                index = sourStr.indexOf(str,index+1);

            }
        } else {
            for (int i = start; i < words.length; i++) {
                String tmp = words[i];
                words[i] = words[start];
                words[start] = tmp;
                findAllComb(list, words, sourStr, start + 1);
                String tmpF = words[i];
                words[i] = words[start];
                words[start] = tmpF;
            }
        }
    }

    /**
     *"pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel"
     ["dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"]
     * @param args
     */
    public static void main(String[] args) {
        subStringWithConcatenationOfAllWords30 concatenationOfAllWords30 = new subStringWithConcatenationOfAllWords30();
        String str = "aaa";
        String[] strs = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        String[] strs1 = {"a","a" };
        List<Integer> list = concatenationOfAllWords30.findSubstring(str,strs1 );
        for (Integer tmp:list) {
            System.out.println(tmp);
        }
    }
}
