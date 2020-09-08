package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @anthor qpointwang
 * @date 2020/9/8 14:47
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class Offer28 {

    // 这种思想是想使用中序遍历对称的方法，但是这样是错误，比如[1,2,2,2,null,2]，中序遍历对称，但是却不是对称二叉树
//    public boolean isSymmetric(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        in(root, res);
//        int i = 0;
//        int j = res.size() - 1;
//        while (i < j) {
//            if (res.get(i) != res.get(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//
//    public void in(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        if (root.left != null) {
//            in(root.left, res);
//        }
//        res.add(root.val);
//        if (root.right != null) {
//            in(root.right, res);
//        }
//    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
