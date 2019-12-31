package SwordToOffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
class Solution14 {
    //注意保证代码的鲁棒性，即各种边界条件。
    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0){
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 1; i < k; i++) {
            if(second.next == null){
                return null;
            }
            second = second.next;
        }
        while(second.next != null){
            second = second.next;
            first = first.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(FindKthToTail(n1,6).val);
    }
}
