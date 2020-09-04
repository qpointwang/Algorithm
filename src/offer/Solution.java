package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @anthor qpointwang
 * @date 2020/9/4 17:02
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return res;
        }
        dfs(root, Integer.toString(root.val));
        return res;
    }

    public String dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path);
            return path;
        }
        System.out.println(root.val);
        if (root.left != null) {
            dfs(root.left, path+"->"+root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, path+"->"+root.right.val);
        }
        return path;
    }

    public static void main(String[] args) {
        Solution solution =new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode2.right = treeNode4;
        treeNode1.right = treeNode3;
        solution.binaryTreePaths(treeNode1);
    }

    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if (root != null){
            preorder(root, res);
        }
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root.left == null && root.right == null) {
            return;
        }
        res.add(root.val);
        if (root.left != null) {
            preorder(root.left, res);
        }
        if (root.right != null) {
            preorder(root.right, res);
        }
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if (root != null){
            inorder(root, res);
        }
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            inorder(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            inorder(root.right, res);
        }
    }

    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if (root != null){
            postorder(root, res);
        }
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            postorder(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            postorder(root.right, res);
        }
    }

    //https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/bian-li-tong-jie-by-long_wotu/
}
