package SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
class Solution61 {
    /*
    思路：二叉树的层次遍历，使用队列实现，
    同时用一个变量记录下一层节点个数，可以保证一次循环遍历一层。
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int layerSum = 1;
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            TreeNode t = null;
            int sum = 0;//记录下一层节点数
            for (int i = 0; i < layerSum; i++) {
                t = queue.poll();
                temp.add(t.val);
                if(t.left != null){
                    queue.add(t.left);
                    sum++;
                }
                if(t.right != null){
                    queue.add(t.right);
                    sum++;
                }
            }
            res.add(temp);
            layerSum = sum;
        }
        return res;
    }

}
