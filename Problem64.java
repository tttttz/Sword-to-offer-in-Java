package SwordToOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 */
class Solution64 {
    /*
    思路：用一个双端队列，队头元素保存当前窗口的最大值的下标，当该下标不在当前窗口中时，
    删除队头元素，否则从队尾开始和新元素比较，若小于新元素，则删除，然后将新元素加到队尾。
    当新元素下标大于等于size-1时（说明窗口满了），开始将队头最大元素下标代表的值添加到结果表中。
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length == 0 || size <= 0 || size > num.length){
            return res;
        }
        int start;
        ArrayDeque<Integer> maxDeque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            start = i - size + 1;
            if(maxDeque.isEmpty()){
                maxDeque.add(i);
            } else if (start > maxDeque.peekFirst()){
                maxDeque.pollFirst();
            }
            while (!maxDeque.isEmpty() && num[i] >= num[maxDeque.peekLast()]){
                maxDeque.pollLast();
            }
            maxDeque.add(i);
            if (start >= 0){
                res.add(num[maxDeque.peekFirst()]);
            }
        }
        return res;
    }
}