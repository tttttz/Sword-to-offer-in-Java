package SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */


class Solution38 {
    /*
    先使用递归思想
     */
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left >= right? left + 1:right + 1;
    }

    /*
    非递归实现。
    使用树的层次遍历，使用队列进行辅助。
    用count记录当前遍历到该层的节点数，用nextCount记录该层的总节点数。
    当count = nextCount时，层数+1。
    更新count为0，nextCount更新为队列的长度（之前的节点都弹出了）。
     */
    public int TreeDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        int count = 0;//记录目前已经遍历的节点数
        int nextCount = 1;//记录一层有多少节点
        while(queue.size() != 0){
            TreeNode t = queue.poll();
            count++;
            if(t.left != null){
                queue.add(t.left);
            }
            if(t.right != null){
                queue.add(t.right);
            }
            if(count == nextCount){
                depth++;
                nextCount = queue.size();
                count = 0;
            }
        }
        return depth;
    }
}
