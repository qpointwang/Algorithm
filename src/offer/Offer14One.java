package offer;


/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer14One {
    // https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
    // ① 当所有绳段长度相等时，乘积最大。② 最优的绳段长度为 3。
    // 解法一 数学推导
    public int cuttingRope(int n) {
        // n=3a+b
        int a = n / 3;
        int b = n % 3;
        if (n <= 3) {
            return n - 1;
        }
        if (b == 0) {
            return (int) Math.pow(3.0, a);
        } else if (b == 1) {
            return (int) Math.pow(3.0, a - 1) * 4;
        } else {
            return (int) Math.pow(3.0, a) * 2;
        }
    }

    // https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/shu-xue-zhi-shi-he-dong-tai-gui-hua-liang-chong-fa/
    // dp[i] = max(dp[i], (max(j, dp[j])) * (max(i - j, dp[i - j])));
    public int cuttingRopeDP(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = 0;
        }
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Offer14One offer14One = new Offer14One();
        System.out.println(offer14One.cuttingRope(8));
        System.out.println(offer14One.cuttingRopeDP(8));
    }
}
