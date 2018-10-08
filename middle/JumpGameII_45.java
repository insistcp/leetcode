package middle;

/**
* @Description:  跳跃游戏，给定一个数组，数组中的每一个元素代表当前你能跳跃的最远距离，
 * 现在让你计算从起始位置调到数组尾部所需要跳跃的最短距离;
* @Author: chenpeng
* @Date: 11:27 2018/10/8
* @param:
* @return:
*/
public class JumpGameII_45 {
    public int jump1(int[] nums) {
        int n = nums.length;
        int last= 0,curr = 0,res = 0;
        for (int i =0; i<n; i++) {
            if (i>last) {
                res++;
                last = curr;
            }
            curr = Math.max(curr,i+nums[i]);
        }
        return res;
    }
    public int jump(int A[]) {
        int n = A.length;
        int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < n; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = Math.max(curr, i+A[i]);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] arr =  {0};
        JumpGameII_45 jumpGameII_45 = new JumpGameII_45();
        int res = jumpGameII_45.jump1(arr);
        System.out.println(res);
    }
}
