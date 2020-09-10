package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @anthor qpointwang
 * @date 2020/9/10 16:39
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        if (A == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (queue.size() > 0) {
            TreeNode cur = queue.poll();
            if (cur.val == B.val) {
                if (is(cur, B)) {
                    return true;
                }
            }
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return false;
    }

    boolean is(TreeNode A, TreeNode B) {
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        queueA.add(A);
        queueB.add(B);
        while (queueB.size() > 0) {
            TreeNode curA = queueA.poll();
            TreeNode curB = queueB.poll();
            if (curA.val != curB.val) {
                return false;
            }
            if (curB.left != null) {
                queueB.add(curB.left);
                if (curA.left != null) {
                    queueA.add(curA.left);
                } else {
                    return false;
                }
            }
            if (curB.right != null) {
                queueB.add(curB.right);
                if (curA.right != null) {
                    queueA.add(curA.right);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
