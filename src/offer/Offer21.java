package offer;

import java.util.Arrays;

/**
 * @anthor qpointwang
 * @date 2020/9/4 15:22
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer21 {

    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] % 2 == 1) {
                i++;
                continue;
            }
            if (nums[j] % 2 == 0) {
                j--;
                continue;
            }
            if (nums[i] % 2 == 0 && nums[j] % 2 == 1) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
//        for (int k = 0; k < nums.length; k++) {
//            System.out.println(nums[k]);
//        }
        return nums;
    }

    public static void main(String[] args) {
        Offer21 offer21 = new Offer21();
        offer21.exchange(new int[]{1, 2, 3, 4, 5});
    }
}
