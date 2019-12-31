package SwordToOffer;


/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
class Solution09 {
    /*
    思路：
    由题意可以得
    当n>2时
    f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(2) + f(1) + f(0)
    f(n-1) = f(n-2) + f(n-3) + f(n-4) + ... + f(2) + f(1) + f(0)
    两式相减：f(n) - f(n-1) = f(n-1)
         即：f(n) = 2f(n-1)
         则可以得到递推公式。
     */
    public static int JumpFloorII(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        int k = 1;
        int methods = 0;
        for (int i = 2; i <= target ; i++) {
            methods = k * 2;
            k = methods;
        }
        return methods;
    }

    //递推可以得公式
    public static int JumpFloorII2(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        //return Math.pow(2,target-1);
        return 2<<target-2;//位运算
    }

    public static void main(String[] args) {

        System.out.println(JumpFloorII2(3));
        System.out.println(JumpFloorII(3));
    }
}
