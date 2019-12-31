package SwordToOffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
/*
    利用辅助栈，记录每一个元素在栈顶时栈内的最小值。
    辅助栈与数据栈同高。
 */
class Solution20 {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> help = new Stack<>();

    public void push(int node) {
        data.push(node);
        if(help.isEmpty() || node < help.peek()){
            help.push(node);
        }else {
            help.push(help.peek());
        }
    }

    public void pop() {
        if(data.isEmpty()){
           return;
        }
        data.pop();
        help.pop();
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }else {
            return 0;
        }
    }

    public int min() {
        if (!help.isEmpty()){
            return help.peek();
        }else{
            return Integer.MAX_VALUE;
        }
    }
}
