package offer;


/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 2 <= n <= 1000
 * */
public class Offer14Two {
    public int cuttingRope(int n) {
        int a = n / 3;
        int b = n % 3;
        if (n <= 3) {
            return n - 1;
        }
        long res = 1;
        int p = 1000000007;
        for (int i = 0; i < a - 1; i++) {
            res = res * 3 % 1000000007;
        }
        if (b == 0) {
            return (int) (res * 3 % p);
        } else if (b == 1) {
            return (int) (res * 4 % p);
        } else {
            return (int) (res * 6 % p);
        }
    }

    public static void main(String[] args) {
        Offer14Two offer14Two = new Offer14Two();
        System.out.println(offer14Two.cuttingRope(1000));
    }
}
