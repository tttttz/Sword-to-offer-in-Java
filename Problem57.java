package SwordToOffer;


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
class Solution57 {
    /*
    思路：
    一个树节点的中序遍历的下一个节点有两种情况：
    1.若有右子树，则下一个节点为右子树中最左的节点。
    2.若没有右子树，则向上找，若该节点为父节点的左孩子，则返回父节点，否则继续向上找。
        若找到没有父节点了，则返回null。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        if(pNode.right != null){
            TreeLinkNode t = pNode.right;
            while (t.left != null){
                t = t.left;
            }
            return t;
        }
        if(pNode.next == null){
            return null;
        }
        TreeLinkNode t = pNode;
        while(t.next != null && t.next.right == t){
            t = t.next;
        }
        return t.next;
    }
}
