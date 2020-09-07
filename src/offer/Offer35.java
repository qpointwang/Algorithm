package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @anthor qpointwang
 * @date 2020/9/7 15:01
 */
public class Offer35 {

    /*public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Integer> loc = new HashMap<>();
        Map<Integer, Node> loc2 = new HashMap<>();
        Node result = new Node(-1);
        Node origin = head;
        Node now = result;
        int index = 0;
        while (origin != null) {
            loc.put(origin, index);
            Node cur = new Node(origin.val);
            loc2.put(index, cur);
            origin = origin.next;
            now.next = cur;
            now = now.next;
            index++;
        }
        origin = head;
        now = result.next;
        while (origin != null) {
            now.random = loc2.get(loc.get(origin.random));
            now = now.next;
            origin = origin.next;
        }
        return result.next;
    }*/

    // 深度优先遍历
    // https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/lian-biao-de-shen-kao-bei-by-z1m/
    public Node copyRandomList(Node head) {
        Map<Node, Node> visited = new HashMap();
        return dfs(head, visited);
    }

    public Node dfs(Node head, Map<Node, Node> visited){
        if (head==null){
            return null;
        }
        if (visited.containsKey(head)){
            return visited.get(head);
        }
        Node copy = new Node(head.val);
        visited.put(head, copy);
        copy.next = dfs(head.next, visited);
        copy.random = dfs(head.random, visited);
        return copy;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}