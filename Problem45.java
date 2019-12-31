package SwordToOffer;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽取5张牌， 判断是不是一个顺子，即这五张牌是否是连续的，2~10为数字本身，
 * A为1，J为11，Q为12，K为13，大小王为任意数字。
 */
class Solution45 {
    /*
    思路：
    先将数组排序，若有重复数字则不是顺子，
    然后统计数组中0的个数是否大于等于相邻数字中空缺的总数，
    若是则为顺子，否则不是。（将0看作是大小王）
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length != 5){
            return false;
        }
        Arrays.sort(numbers);
        int zeros = 0;
        int gaps = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0){
                zeros++;
            }else{
                if(i != numbers.length-1 && numbers[i] == numbers[i+1]){
                    return false;
                }
                if(i != numbers.length-1 && numbers[i+1] - numbers[i]!=1){
                    gaps += numbers[i+1] - numbers[i] - 1;
                }
            }
        }
        //理论上大小王不会超过两个，但是题中没有限定
        if(zeros > 2){
            return false;
        }
        return zeros >= gaps;
    }

    public static void main(String[] args) {
        Solution45 s = new Solution45();
        System.out.println(s.isContinuous(new int[]{0,0,3,6,7}));//true
        System.out.println(s.isContinuous(new int[]{0,4,5,6,7}));//true
        System.out.println(s.isContinuous(new int[]{0,4,6,7,1}));//false
    }
}
