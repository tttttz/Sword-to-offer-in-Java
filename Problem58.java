package SwordToOffer;



/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
class Solution58 {
    /*
    思路：
    先序遍历的对称遍历，若两者相同（包括你null值），
    则是对称的二叉树，否则不是对称的。
    此处使用递归。
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        return Symmetrical(pRoot, pRoot);
    }

    boolean Symmetrical(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.val != t2.val){
            return false;
        }
        return Symmetrical(t1.left, t2.right) && Symmetrical(t1.right, t2.left);
    }
}