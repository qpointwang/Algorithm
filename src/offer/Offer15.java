package offer;


/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
//        String num = Integer.toBinaryString(n);
//        int res = 0;
//        for (int i = 0; i < num.length(); i++) {
//            if (num.charAt(i) == '1')
//                res++;
//        }
//        return res;
        /**
         * 1、>>:右移运算符，num >> 1,相当于num除以2。按二进制形式把所有的数字向右移动对应位数，低位移出（舍弃），高位的空位补符号位，即正数补零，负数补1。符号位不变。
         * 如：-1在32位二进制中表示为：11111111 11111111 11111111 11111111，-1>>1：按位右移，符号位不变，仍旧得到11111111 11111111 11111111 11111111，因此值仍为-1
         * 2、>>>:二进制右移补零操作符，左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充，如value&nbsp;>>>&nbsp;num中，num指定要移位值value&nbsp;移动的位数。
         * 扩展资料“>>”和“>>>”等移位运算符的运算规则：1、无符号右移，忽略符号位，空位都以0补齐。value&nbsp;>>>a，a是要移位值value&nbsp;移动的位数。无符号右移的规则只记住一点：忽略了符号位扩展，0补最高位&nbsp;&nbsp;无符号右移运算符>>>&nbsp;只是对32位和64位的值有意义。
         * 2、右移位运算符>>，若操作的值为正，则在高位插入0；若值为负，则在高位插入1。右移补零操作符>>>，无论正负，都在高位插入0。
         * */
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >>> 1;
        }
        return res;


    }

    public static void main(String[] args) {
        Offer15 offer15 = new Offer15();
        System.out.println(offer15.hammingWeight(-1));
    }
}
