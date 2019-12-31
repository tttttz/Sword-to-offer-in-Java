package SwordToOffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
class Solution47 {
    //思路：使用逻辑与的短路效果实现判断，使用递归实现循环。
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n>0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        Solution47 s = new Solution47();
        System.out.println(s.Sum_Solution(100));
    }
}