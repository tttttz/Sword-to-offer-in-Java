package SwordToOffer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 */
class Solution49 {
    /*
    思路：
    难点在于考虑溢出情况，因为Integer的最小值的绝对值比最大值大1，
    所以所有数字都先当做负数处理，考虑溢出情况时，若当前结果值小于小于最小值的1/10，则溢出，
    若等于最小值的1/10且当前值小于最小值除以10的余数，则溢出。
    然后判断若为正数且当前值为最小值，也溢出。
    最后根据符号返回结果。
     */
    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] nums = str.toCharArray();
        if(!isValid(nums)){
            return 0;
        }
        int res = 0;
        int cur = 0;
        boolean positive = true;
        int minq = Integer.MIN_VALUE/10;
        int minr = Integer.MIN_VALUE%10;
        if(nums[0] == '-'){
            positive = false;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == '-' || nums[i] == '+'){
                continue;
            }
            cur = '0' - nums[i];
            if(res < minq || (res == minq && cur < minr)){
                return 0;
            }
            res = res * 10 + cur;
        }
        if(positive && res == Integer.MIN_VALUE){
            return 0;
        }
        return positive?-res:res;
    }
    public boolean isValid(char[] chars){
        if(chars[0] != '+' && chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')){
            return false;
        }
        if((chars[0] == '+' || chars[0] == '-') && (chars.length == 1 || (chars.length == 2 && chars[1] == '0'))){
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] < '0' || chars[i] > '9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution49 s = new Solution49();
        System.out.println(s.StrToInt("2147483648"));
    }
}