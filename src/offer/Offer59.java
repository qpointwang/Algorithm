package offer;

import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        LinkedList<Integer> deque = new LinkedList<>();

        int n = nums.length;
        int[] res = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k && nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (deque.size() > 0 && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            if (i >= k - 1) {
                res[j++] = deque.peekFirst();
            }
            System.out.println(deque);
        }
        for (int i = 0; i < n - k + 1; i++) {
            System.out.println(res[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new Offer59().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
    }
}
