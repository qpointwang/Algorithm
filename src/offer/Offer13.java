package offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
 */
public class Offer13 {
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, m, n, 0, 0, k);
    }

    int dfs(boolean[][] visited, int m, int n, int i, int j, int k) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (visited[i][j]) {
            return 0;
        }
        if (sum(i) + sum(j) <= k) {
            visited[i][j] = true;
            return 1 + dfs(visited, m, n, i + 1, j, k) + dfs(visited, m, n, i, j + 1, k);
        }

        return 0;
    }

    public static void main(String[] args) {
        new Offer13().movingCount(3, 1, 0);
    }

    int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x = x / 10;
        }
        return res;
    }
}
