package SwordToOffer;

import java.util.ArrayList;
import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class Solution25 {
    //使用map结构记录新旧节点的对应关系
    //时间复杂度O(n),空间复杂度O(n)
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode p = pHead;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }
        p = pHead;
        while (p != null) {
            if (p.next != null) {
                map.get(p).next = map.get(p.next);
            } else {
                map.get(p).next = null;
            }
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(pHead);
    }

    //空间复杂度O(1)的解法。
    public static RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }

        p = pHead;

        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;//若p为空则无next指针，可以避免空指针异常
            p = p.next.next;
        }
        p = pHead;
        RandomListNode newHead = pHead.next;
        RandomListNode q = newHead;
        while (p != null) {
            p.next = q.next;
            p = p.next;
            q.next = p == null ? null : p.next;//若p为空则无next指针，可以避免空指针异常
            q = q.next;
        }
        return newHead;
    }


    public static RandomListNode Clone3(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = n3;
        n2.random = n5;
        n3.random = null;
        n4.random = n2;
        n5.random = null;
        RandomListNode newhead = Clone2(n1);
        while (newhead != null) {
            System.out.println(newhead.label);
            if(newhead.random == null){
                System.out.println("null");
            }else {
                System.out.println(newhead.random.label);
            }
            newhead = newhead.next;
        }
    }
}
