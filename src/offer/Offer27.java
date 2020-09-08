package offer;

/**
 * @anthor qpointwang
 * @date 2020/9/8 14:22
 * <p>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer27 {
//    public TreeNode mirrorTree(TreeNode root) {
//        if (root==null){
//            return null;
//        }
//        TreeNode newTree = new TreeNode(root.val);
//        dfs(root, newTree);
//        return newTree;
//    }
//
//    public void dfs(TreeNode root, TreeNode newTree) {
//        if (root == null){
//            return;
//        }
//        if (root.left!=null){
//            newTree.right = new TreeNode(root.left.val);
//            dfs(root.left, newTree.right);
//        }
//        if (root.right!=null){
//            newTree.left = new TreeNode(root.right.val);
//            dfs(root.right, newTree.left);
//        }
//    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
