package SwordToOffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
class Solution16 {

    //注意代码的鲁棒性以及函数的各种边界。
    public static ListNode Merge(ListNode list1,ListNode list2) {
//        if(list1 == null && list2 == null){
//            return null;
//        }else if (list1 == null){
//            return list2;
//        }else if (list2 == null){
//            return list1;
//        }
//        ListNode l1 = list1;
//        ListNode l2 = list2;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null){
            tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(10);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        ListNode l9 = null;
        ListNode head = Merge(l1,l5);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
