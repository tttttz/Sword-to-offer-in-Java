package SwordToOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
class Solution23 {
    //递归思想
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return isSquence(sequence,0,sequence.length-1);
    }

    public static boolean isSquence(int [] sequence, int start, int root){
       int i = start;
       while(i < root && sequence[i] < sequence[root]){
           i++;
       }
       int j = i;
       while(j < root){
           //若大于根节点的部分中有小于根节点的值，则返回false
           if(sequence[j] < sequence[root]){
               return false;
           }
           j++;
       }
       boolean left = true;
       boolean right = true;
       if(i > start){
           left = isSquence(sequence, start, i-1);
       }
       if(i < root){
           right = isSquence(sequence,i,root-1);
       }
       return left && right;
    }
}