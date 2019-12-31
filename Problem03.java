package SwordToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
class Solution03 {
    /*
    思路1：用栈实现逆序返回
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return new ArrayList<>();
        }
        ListNode head = listNode;
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
    //该思路使用了集合ArrayList的头插法，不太好
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ListNode head = listNode;
        ArrayList<Integer> res = new ArrayList<>();
        while(head != null){
            res.add(0,head.val);
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        System.out.println(printListFromTailToHead(n1));
        System.out.println(printListFromTailToHead2(n1));
        System.out.println(printListFromTailToHead(null));
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
