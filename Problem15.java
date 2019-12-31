package SwordToOffer;

import java.util.List;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */

class Solution15 {
    public static ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode i = null;
        ListNode j = head;
        ListNode k = head.next;
        while (k != null){
            j.next = i;
            i = j;
            j = k;
            k = k.next;
        }
        j.next = i;
        return j;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode newHead = ReverseList(n1);
        while (newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
        ListNode m1 = new ListNode(5);
        System.out.println(ReverseList(m1).val);
        ListNode m2 = new ListNode(6);
        m1.next = m2;
        newHead = ReverseList(m1);
        System.out.println(newHead.val);
        System.out.println(newHead.next.val);
    }
}