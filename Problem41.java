package SwordToOffer;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
class Solution41 {
    /*
    思路：
    双指针，一个small指向序列最小值，big指向序列最大值，若当前和curSum与sum相等，
    将small到big生成，一个序列。
    若curSum>sum，small++，若curSum<sum，big++。
    当small>sum/2时循环停止。
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum < 3){
            return res;
        }
        int small = 1;
        int big = 2;
        int curSum = 3;
        int mid = (sum+1)>>1;
        while (small < mid){
            if(curSum == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                res.add(list);
                big++;
                curSum += big;
            }else if (curSum > sum){
                curSum -= small;
                small++;
            }else if (curSum < sum){
                big++;
                curSum += big;
            }
        }
        return res;
    }
}