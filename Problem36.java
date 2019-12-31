package SwordToOffer;


/**
 * 输入两个链表，找出它们的第一个公共结点。
 */

class Solution36 {
    /*
    思路很简单：
    先遍历一次两个链表，获得长度差k，
    第二次较长的链表先遍历k个节点，然后两个链表同时遍历，遇到相等的节点就返回。
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int length = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null){
            length++;
            p1 = p1.next;
        }
        while (p2 != null){
            length--;
            p2 = p2.next;
        }
        p1 = pHead1;
        p2 = pHead2;
        if(length > 0){
            for (int i = 0; i < length; i++) {
                p1 = p1.next;
            }
        }
        if(length < 0){
            length = -length;
            for (int i = 0; i < length; i++) {
                p2 = p2.next;
            }
        }
        while(p1 != null){
            if (p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}