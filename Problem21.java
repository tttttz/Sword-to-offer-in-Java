package SwordToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
class Solution21 {
    //将pusha中的元素循环压入help栈中，每次判断若栈顶元素和popa中当前元素相等且popa下标未越界，
    // 则循环弹出栈顶元素，最后判断help栈，为空则为true，否则为false。
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> help = new Stack<>();
        if(pushA.length == 0 || popA.length == 0 || pushA.length != popA.length){
            return false;
        }
        for (int i = 0,j = 0; i < pushA.length; i++) {
            help.push(pushA[i]);
            while (j < popA.length && help.peek() == popA[j]){
                help.pop();
                j++;
            }
        }
        return help.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{2};
        int[] pop2 = new int[]{4,5,3,2,1};
        System.out.println(IsPopOrder(push,pop));
        System.out.println(IsPopOrder(push,pop2));
    }
}
