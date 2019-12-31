package SwordToOffer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *  * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
class Solution56 {
    /*
    思路：
    用一个虚拟节点模拟头节点，两个工作节点用来找不同的节点并拼接，
    最后返回虚拟节点的下一个节点就是头结点。
    此题还可以用递归
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode p = new ListNode(0);
        p.next = pHead;
        ListNode pLast = p;
        ListNode pThis = pLast.next;
        while (pThis != null){
            if(pThis.next != null && pThis.val == pThis.next.val){
                while (pThis.next != null && pThis.val == pThis.next.val){
                    pThis = pThis.next;
                }
                pLast.next = pThis.next;
                pThis = pThis.next;
            } else {
                pLast = pLast.next;
                pThis = pThis.next;
            }
        }
        return p.next;
    }

    //递归解法
    public ListNode deleteDuplication2(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        if (pHead.next.val == pHead.val){
            ListNode p = pHead.next;
            while (p != null && p.val == pHead.val){
                p = p.next;
            }
            return deleteDuplication(p);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}