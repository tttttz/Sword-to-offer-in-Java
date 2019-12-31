package SwordToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
class Solution59 {
    /*
    思路：
    准备两个栈，s1用来存放奇数层，s2用来存放偶数层。
    从s1取节点时，按照先左孩子后右孩子的顺序将节点存入s2，
    从s2取节点时，按照先右孩子后左孩子的顺序将节点存入s1。
    当两个栈都为空时结束循环。
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        //s1存放奇数层,s2存放偶数层
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int layer = 1;
        s1.push(pRoot);
        while(!s1.isEmpty() || !s2.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            if(layer % 2 == 1){
                TreeNode treeNode = null;
                while(!s1.isEmpty()){
                    treeNode = s1.pop();
                    temp.add(treeNode.val);
                    if(treeNode.left != null){
                        s2.push(treeNode.left);
                    }
                    if(treeNode.right != null){
                        s2.push(treeNode.right);
                    }
                }
                res.add(temp);
                layer++;
            } else {
                TreeNode treeNode = null;
                while (!s2.isEmpty()){
                    treeNode = s2.pop();
                    temp.add(treeNode.val);
                    if(treeNode.right != null){
                        s1.push(treeNode.right);
                    }
                    if(treeNode.left != null){
                        s1.push(treeNode.left);
                    }
                }
                res.add(temp);
                layer++;
            }
        }
        return res;
    }
}