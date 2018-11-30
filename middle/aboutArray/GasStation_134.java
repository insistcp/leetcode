package middle.aboutArray;
/**
* @Description:  给定两个数组gas 和cost ,其中gas代表每一个加油站现有的油量，cost代表从当前加油站到下一个加油站需要消耗的油量；
 * 现在问题从哪一个位置出发可以走遍所有加油站
* @Author: chenpeng
* @Date: 10:08 2018/11/30
* @param:
* @return:
*/
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null ||gas.length==0)
        {
            return 0;
        }
        int len = gas.length;

        for (int i = 0;i<len;i++) {
            int pace = 1;
            int hasGas = 0;
            int start = i;
            while (pace<=len) {
                hasGas+= gas[start];
                int mCost = cost[start];
                if (hasGas<mCost) {
                    break;
                }
                hasGas-=mCost;
                start++;
                if (start == len) {
                    start = 0;
                }
                pace++;
            }
            if (pace > len) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        GasStation_134 gasStation_134 = new GasStation_134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int res = gasStation_134.canCompleteCircuit(gas, cost);
        System.out.println(res);
    }
}
