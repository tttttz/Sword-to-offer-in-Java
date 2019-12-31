package SwordToOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
class Solution12 {
    //使用递归
    public static double Power(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        if(base == 0){
            return 0;
        }
        double result = Power(base, Math.abs(exponent) >> 1);
        result*= result;
        if((exponent & 1) == 1){
            result = result * base;
        }
        if(exponent > 0){
            return result;
        }else{
            return 1/result;
        }
    }

    public static void main(String[] args) {
        System.out.println(Power(2,-3));
        System.out.println(Power(0,-3));
    }
}
