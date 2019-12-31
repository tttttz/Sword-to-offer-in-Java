package SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树.
 */
class Solution60 {
    String Serialize(TreeNode root) {
        if(root == null){
            return new String();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        s.append(root.val + ",");
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left != null){
                queue.add(temp.left);
                s.append(temp.left.val + ",");
            } else {
                s.append("#,");
            }
            if(temp.right != null){
                queue.add(temp.right);
                s.append(temp.right.val + ",");
            } else {
                s.append("#,");
            }
        }
        return s.toString().substring(0,s.length() - 1);
    }
    TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        String[] nodes = str.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        int i = 1;
        while (i < nodes.length){
            TreeNode temp = queue.poll();
            if("#".equals(nodes[i])){
                temp.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                temp.left = left;
                queue.add(left);
            }
            i ++;
            if(i < nodes.length){
                if("#".equals(nodes[i])){
                    temp.right = null;
                } else {
                    TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                    temp.right = right;
                    queue.add(right);
                }
                i ++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = null;
        t2.right = null;
        t3.left = t4;
        t3.right = t5;
        t4.left = null;
        t4.right = null;
        t5.left = null;
        t5.right = null;
        Solution60 s = new Solution60();
        String str = s.Serialize(t1);
        System.out.println(str);
        TreeNode root = s.Deserialize(str);
        System.out.println(s.Serialize(root));
    }
}