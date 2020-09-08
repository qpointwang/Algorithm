package offer;

/**
 * @anthor qpointwang
 * @date 2020/9/8 16:32
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return new int[]{};
        }
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] res = new int[m * n];
        int index = 0;
        int i = 0;
        int j = 0;
        int flag = 1;
        while (index != m * n) {
            if (!visited[i][j]) {
                // System.out.println("dddd"+index+" "+matrix[i][j]);
                res[index++] = matrix[i][j];
                visited[i][j] = true;
            }
            if (flag % 4 == 1) {
                // System.out.println(flag + " " + matrix[i][j] + " " + index + " " + i + " " + j);
                if (j == n - flag / 4 - 1) {
                    flag++;
                } else {
                    j++;
                }
            } else if (flag % 4 == 2) {
                // System.out.println(flag + " " + matrix[i][j] + " " + index + " " + i + " " + j);
                if (i == m - flag / 4 - 1) {
                    flag++;
                } else {
                    i++;
                }
            } else if (flag % 4 == 3) {
                // System.out.println(flag + " " + matrix[i][j] + " " + index + " " + i + " " + j);
                if (j == flag / 4) {
                    flag++;
                } else {
                    j--;
                }
            } else if (flag % 4 == 0) {
                // System.out.println(flag + " " + matrix[i][j] + " " + index + " " + i + " " + j);
                if (i == flag / 4) {
                    flag++;
                } else {
                    i--;
                }
            }
        }
        for (int k = 0; k < res.length; k++) {
            System.out.println(res[k]);
        }
        return res;
    }

    public static void main(String[] args) {
        new Offer29().spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}});
    }
}
