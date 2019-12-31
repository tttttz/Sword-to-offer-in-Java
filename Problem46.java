package SwordToOffer;

import java.util.ArrayList;

/**
 * (约瑟夫环)
 * 0到n-1这n个数字排成一个圆圈，
 * 从数字0开始，每次从这个圆圈中取走第m个数，
 * 求这个圆圈里剩下的最后一个数字。
 * 如果没有数字，请返回-1
 */
class Solution46 {
    //方法1：使用一个数组或者list模拟环，最后返回数组中剩的那一个数。
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int rest = n;
        int cur = 0;
        while(rest != 1){
           cur = (cur + m - 1)%rest;
           list.remove(cur);
           rest--;
        }
        return list.get(0);
    }
    //方法2:使用数学推导得出有n个数时，（每次移动m），最后剩余那个数的坐标
    //与有n-1个数时最后一个数的坐标的映射关系为f(n,m)=(f(n-1,m)+m)%n
    //则可以根据递推公式，使用循环或者递归得出结果。
    public int LastRemaining_Solution2(int n, int m){
        if(n < 1 || m < 1){
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n ; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}