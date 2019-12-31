package SwordToOffer;

import java.util.HashSet;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

class Solution55 {
    //方法1：hashset 不多解释
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = pHead;
        while (p != null){
            if(set.contains(p)){
                return p;
            }else {
                set.add(p);
            }
            p = p.next;
        }
        return null;
    }

    //方法2：快慢指针法，(空间复杂度o（1）)一个指针一次走一步，一个指针一次走两步，
    // 两者第一次相遇时，一个指针回到头结点，两者同时每次走一步，
    // 再第一次相遇时的节点即为环的入口节点
    public ListNode EntryNodeOfLoop2(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next.next;
        }
/*        if(fast == null || slow == null){
            return null;
        }*/
        fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
