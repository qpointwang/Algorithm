package offer;

/**
 * @anthor qpointwang
 * @date 2020/9/10 19:07
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 *  
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return verify(0, postorder.length, postorder);
    }

    public boolean verify(int start, int end, int[] postorder) {
        if (end - start == 1) {
            return true;
        }
        int root = postorder[end - 1];
        boolean x = false;
        boolean y = false;
        for (int i = start; i < end - 1; i++) {
            if (postorder[i] < root) {
                x = true;
                if (y) {
                    return false;
                }
            }
            if (postorder[i] > root) {
                y = true;
            }
        }
        if ((!x && y) || (!y && x)) {
            return verify(start, end - 1, postorder);
        }
        for (int i = start; i < end - 1; i++) {
            if (x && y && postorder[i] < root && postorder[i + 1] > root) {
                return verify(start, i + 1, postorder) && verify(i + 1, end - 1, postorder);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Offer33().verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(new Offer33().verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }
}
