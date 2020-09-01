package offer;


/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (x == 0.0) {
            return 0.0;
        }
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        if (N == 1) {
            return x;
        }
        long i = 1;
        double res = x;

        while (i <= N / 2) {

            res = res * res;
            i = i * 2;
        }
        long j = N - i;
        if (j > i / 2) {
            res = res * res;
            for (long k = 0; k < i - j; k++) {
                res = res / x;
            }
        } else {
            for (long k = 0; k < j; k++) {
                res = res * x;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Offer16 offer16 = new Offer16();
        System.out.println(offer16.myPow(1.0, -2147483648));
    }
}
