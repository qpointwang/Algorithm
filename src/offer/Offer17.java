package offer;


/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Offer17 {


    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] res = new int[max - 1];
        for (int i = 0; i < max - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }


    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 'H') {
            return;
        }
        grid[r][c] = 'H';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == 'S') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }



    public int maxValue(int[] W, int[] V, int K, int N) {
        int valueLen = K + 1;//列值长度加1，是因为最后一列要保证重量值为lenColumn
        int maxValue = 0;
        int[][] v = new int[N][valueLen];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < valueLen; j++) {
                if (i == 0) {
                    v[i][j] = 0;
                } else if (j == 0) {
                    v[i][j] = 0;
                } else {
                    if (W[i] > j) {
                        v[i][j] = v[i - 1][j];

                    } else if (W[i] <= j) {
                        v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - W[i]] + V[i]);
                    }
                    maxValue = v[i][j];
                }

            }

        }
        return maxValue;
    }



    public static void main(String[] args) {
        Offer17 offer17 = new Offer17();
        System.out.println(offer17.numIslands(new char[][]{{'S', 'S', 'H', 'H', 'H'},
                {'S', 'S', 'H', 'H', 'H'},
                {'H', 'H', 'S', 'H', 'H'},
                {'H', 'H', 'H', 'S', 'S',}
        }));

        System.out.println(offer17.maxValue(new int[]{2, 2, 4, 6, 3}, new int[]{3, 4, 8, 9, 6}, 9, 5));
    }
}
