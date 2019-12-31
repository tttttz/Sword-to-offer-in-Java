package SwordToOffer;


/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

class Solution39 {

    /*
    思路：
    递归思想，后序遍历平衡二叉树，
    若左右子树都是平衡二叉树且高度差为1，则是平衡二叉树。
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return false;
        }
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        if(left == -1){
            return -1;
        }
        int right = getDepth(root.right);
        if(right == -1){
            return -1;
        }
        return Math.abs(left - right) <= 1?1+Math.max(left, right):-1;
    }
}
