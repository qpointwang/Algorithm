package offer;

/**
 * @anthor qpointwang
 * @date 2020/9/4 16:23
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode before = new ListNode(Integer.MIN_VALUE);
        ListNode res = before;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                res.next = a;
                a = a.next;
            } else {
                res.next = b;
                b = b.next;
            }
            res = res.next;
        }
        if (a != null) {
            res.next = a;
        }
        if (b != null) {
            res.next = b;
        }
        return before.next;
    }
}
