package offer;

/**
 * @anthor qpointwang
 * @date 2020/9/4 9:52
 * <p>
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer19 {

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    dp[i][j] = i == 0;
                } else {
                    // j-1位置是 *
                    if (p.charAt(j - 1) == '*') {
                        // 与i无关，只要保证p有两个字符
                        if (j >= 2) {
                            dp[i][j] = dp[i][j - 2];
                        }
                        // i>=1表示s至少有一个字符，j>=2表示p至少要有两个字符，包含一个*
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                        System.out.println(j-1+" "+p.charAt(j - 1));
                    } else { // j-1位置是 普通字符或者 .
                        if (i >= 1 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
                System.out.println("s为 \""+s.substring(0,i) + "\" p为\"" + p.substring(0,j) + "\"时 " + dp[i][j]);
            }
        }
        /**
         * 关于为什么用|=，比如这段代码： //碰到 * 了，分为看和不看两种情况 //不看 if (j >= 2) { f[i][j] |= f[i][j - 2]; //可用可不用，因为dp矩阵初始化默认为false，本质上和=一样 } //看 if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) { f[i][j] |= f[i - 1][j]; //必须使用，否则不能ac }
         *
         * 其中，第一步先算的是不看‘*’的情况，然后第二步再算看‘*’的情况。也就是说，对于f[i][j]我们会算两次。如果在第一次，即不看'*'的时候，就已经算出来TURE了。那在第二步看'*'的时候。不管结果是ture还是false，都保持true不变，这是合理的，因为只要其中有一种情况能完整匹配，结果就为true。这就是为什么要用或符号。 这个不难证明，举个例子 "ba" "baa*" 这种情况下直接用=号过不了。
         * */
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Offer19 offer19 = new Offer19(); //
        System.out.println(offer19.isMatch("aaa", "ab*a*c*a"));
    }
}

/**
 * 解题思路
 * 假设主串为 AA，模式串为 BB 从最后一步出发，需要关注最后进来的字符。假设 AA 的长度为 nn ，BB 的长度为 mm ，关注正则表达式 BB 的最后一个字符是谁，它有三种可能，正常字符、*∗ 和 .（点），那针对这三种情况讨论即可，如下：
 * <p>
 * 如果 BB 的最后一个字符是正常字符，那就是看 A[n-1]A[n−1] 是否等于 B[m-1]B[m−1]，相等则看 A_{0..n-2}A
 * 0..n−2
 * ​
 * 与 B_{0..m-2}B
 * 0..m−2
 * ​
 * ，不等则是不能匹配，这就是子问题。
 * <p>
 * 如果 BB 的最后一个字符是.，它能匹配任意字符，直接看 A_{0..n-2}A
 * 0..n−2
 * ​
 * 与 B_{0..m-2}B
 * 0..m−2
 * ​
 * <p>
 * <p>
 * 如果 BB 的最后一个字符是*它代表 B[m-2]=cB[m−2]=c 可以重复0次或多次，它们是一个整体 c*c∗
 * <p>
 * 情况一：A[n-1]A[n−1] 是 00 个 cc，BB 最后两个字符废了，能否匹配取决于 A_{0..n-1}A
 * 0..n−1
 * ​
 * 和 B_{0..m-3}B
 * 0..m−3
 * ​
 * 是否匹配
 * 情况二：A[n-1]A[n−1] 是多个 cc 中的最后一个（这种情况必须 A[n-1]=cA[n−1]=c 或者 c='.'c=
 * ′
 * .
 * ′
 * ），所以 AA 匹配完往前挪一个，BB 继续匹配，因为可以匹配多个，继续看 A_{0..n-2}A
 * 0..n−2
 * ​
 * 和 B_{0..m-1}B
 * 0..m−1
 * ​
 * 是否匹配。
 * 转移方程
 * f[i] [j]f[i][j] 代表 AA 的前 ii 个和 BB 的前 jj 个能否匹配
 * <p>
 * 对于前面两个情况，可以合并成一种情况 f[i][j] = f[i-1][j-1]f[i][j]=f[i−1][j−1]
 * <p>
 * 对于第三种情况，对于 c*c∗ 分为看和不看两种情况
 * <p>
 * 不看：直接砍掉正则串的后面两个， f[i][j] = f[i][j-2]f[i][j]=f[i][j−2]
 * 看：正则串不动，主串前移一个，f[i][j] = f[i-1][j]f[i][j]=f[i−1][j]
 * 初始条件
 * 特判：需要考虑空串空正则
 * <p>
 * 空串和空正则是匹配的，f[0][0] = truef[0][0]=true
 * 空串和非空正则，不能直接定义 truetrue 和 falsefalse，必须要计算出来。（比如A=A= '' '' ,B=a*b*c*B=a∗b∗c∗）
 * 非空串和空正则必不匹配，f[1][0]=...=f[n][0]=falsef[1][0]=...=f[n][0]=false
 * 非空串和非空正则，那肯定是需要计算的了。
 * 大体上可以分为空正则和非空正则两种，空正则也是比较好处理的，对非空正则我们肯定需要计算，非空正则的三种情况，前面两种可以合并到一起讨论，第三种情况是单独一种，那么也就是分为当前位置是 *∗ 和不是 *∗ 两种情况了。
 * <p>
 * 结果
 * 我们开数组要开 n+1n+1 ，这样对于空串的处理十分方便。结果就是 f[n][m]f[n][m]
 * <p>
 * 作者：jerry_nju
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zhu-xing-xiang-xi-jiang-jie-you-qian-ru-shen-by-je/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
