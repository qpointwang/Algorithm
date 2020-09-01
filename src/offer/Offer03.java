package offer;


/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer03 {
    // https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int i =0;
        while (i<n){
            if (nums[i] == i){
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]){
                return nums[i];
            }

            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;

//            for (int j = 0; j < n; j++) {
//                System.out.print(nums[j]+" ");
//
//            }
//            System.out.println();
        }
        return -1;
    }

    public static void main(String[] args) {
        Offer03 offer03 = new Offer03();
        System.out.println(offer03.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
