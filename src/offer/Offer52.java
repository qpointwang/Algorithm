package offer;

/**
 *
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @anthor qpointwang
 * @date 2020/9/7 5:17
 */
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            a = a.next;
            lenA++;
        }
        while (b != null) {
            b = b.next;
            lenB++;
        }
        if (lenB > lenA) {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        } else if (lenB < lenA) {
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static void main(String[] args) {

    }
}
