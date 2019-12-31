package SwordToOffer;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
class Solution62 {
    /*
    思路：
    二叉搜索树的中序遍历即从小到大排序，故只需要中序遍历到第k个节点即可返回结果。
    二叉树的中序遍历可以使用递归或者非递归，但是递归版本需要在函数外设置一个计数变量。
    此处分别使用了两种方法实现
     */
    //非递归
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0){
            return null;
        }
        TreeNode t = pRoot;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while(!stack.isEmpty() || t!= null){
            if(t != null){
                stack.push(t);
                t = t.left;
            } else {
                t = stack.pop();
                count++;
                if(count == k){
                    return t;
                }
                t = t.right;
            }
        }
        return null;
    }
    //递归
    int count = 0;
    TreeNode KthNode2(TreeNode pRoot, int k){
        if(pRoot != null){
            TreeNode t = KthNode2(pRoot.left, k);
            if(t != null){
                return t;
            }
            count++;
            if(count == k){
                return pRoot;
            }
            t = KthNode2(pRoot.right, k);
            if(t != null){
                return t;
            }
        }
        return null;
    }
}