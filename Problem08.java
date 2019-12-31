package SwordToOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
class Solution08 {

    //暴力递归
    public static int JumpFloor(int target) {
        if(target <= 0){
            return 0;
        }
        if(target <= 2){
            return target;
        }
        return JumpFloor(target-1) + JumpFloor(target - 2);
    }

    //动态规划
    public static int JumpFloor2(int target) {
        if(target <= 0){
            return 0;
        }
        if(target <= 2){
            return target;
        }
        int p = 1;
        int q = 2;
        int methods = 0;
        for (int i = 3; i <= target; i++) {
            methods = p + q;
            p = q;
            q = methods;
        }
        return methods;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor2(4));
    }
}
