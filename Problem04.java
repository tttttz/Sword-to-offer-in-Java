package SwordToOffer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */



import java.util.Arrays;


class Solution04 {
    /*
    思路：递归
    先序遍历的当前节点为根节点，在中序遍历中找到该节点，
    中序遍历中该节点的左半部分在先序遍历中必定都在中序遍历中该节点的右半部分在先序遍历中的前面。
    故可以将各部分复制到一个新的数组中进行递归。
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre.length == 0 || pre == null || in.length == 0 || in == null){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]){
                //Arrays.copyOfRange()函数的范围为左闭右开
                treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return treeNode;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
