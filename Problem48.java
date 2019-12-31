package SwordToOffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
class Solution48 {
    //思路：使用位运算代替加法运算，按位异或实现逐位相加，按位与再左移实现进位。
    //循环直到没有进位。
    public int Add(int num1,int num2) {
        int plus = num1 ^ num2;
        int hIndex = (num1 & num2)<<1;
        num1 = plus;
        num2 = hIndex;
        while (num2 != 0){
            plus = num1 ^ num2;
            hIndex = (num1 & num2)<<1;
            num1 = plus;
            num2 = hIndex;
        }
        return plus;
    }

    public static void main(String[] args) {
        Solution48 s = new Solution48();
        System.out.println(s.Add(100,5));
    }
}
