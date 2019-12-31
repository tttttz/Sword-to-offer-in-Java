package SwordToOffer;



import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
class Solution26 {
    public TreeNode Convert(TreeNode pRootOfTree) {

        /*
        二叉搜索树的中序遍历刚好是排序的，
        中序遍历同时，将节点的左指针指向前一个节点，右指针指向后一个节点。
         */
        if(pRootOfTree == null){
            return null;
        }

        TreeNode head = pRootOfTree;
        while (head.left!= null){
            head = head.left;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode first = head;
        TreeNode t = pRootOfTree;
        while (!stack.isEmpty() || t != null){
            while(t!=null){
                stack.push(t);
                t = t.left;
            }
            if(!stack.isEmpty()){
                t = stack.pop();
                if(t != head){
                    first.right = t;
                    t.left = first;
                    first = t;
                }
                t = t.right;
            }
        }
        return head;
    }
}