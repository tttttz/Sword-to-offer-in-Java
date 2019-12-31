package SwordToOffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
class Solution10 {
    //实质上还是斐波那契数列
    public static int RectCover(int target) {
        if(target < 1){
            return 0;
        }
        if(target <= 2){
            return target;
        }
        int m = 1;
        int n = 2;
        for (int i = 3; i <= target; i++) {
            n = n + m;
            m = n - m;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }
}
