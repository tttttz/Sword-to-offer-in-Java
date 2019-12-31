package SwordToOffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
class Solution11 {

    /**
     *     最巧妙的方法：
     *     该数每次减一后与原数做逻辑与，可以将该数中最后一个1变为0；
     *     当把所有1变为0时，循环结束，可以得到1的个数，循环次数即为1的个数，
     *     总共循环的次数为1的个数。
     *
     *     普通解法，让a = 1与该数逻辑与，若结果为1则1的个数加一，然后将a左移一位
     *     一直到a为0时停止，即可得到1的个数，总共需循环int类型的比特位（4*8）。
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        if(n == 0){
            return 0;
        }
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(9));
        System.out.println(NumberOf1(1));
        System.out.println(NumberOf1(-1));
        System.out.println(Integer.toBinaryString(-1));
    }
}
