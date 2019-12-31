package SwordToOffer;

import java.util.HashMap;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
class Solution07 {

    //暴力递归
    public static int Fibonacci(int n) {
        if(n < 0 || n > 39){
            return -1;
        }
        if(n == 0 ||n == 1){
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci( n - 2);
    }

    //hashmap 迭代
    public static int Fibonacci2(int n) {
        if(n < 0 || n > 39){
            return -1;
        }
        if(n == 0 ||n == 1){
            return n;
        }
        HashMap<Integer,Integer> fib = new HashMap<>();
        fib.put(0,0);
        fib.put(1,1);
        for (int i = 2; i <= n; i++) {
            fib.put(i,fib.get(i-1) + fib.get(i-2));
        }
        return fib.get(n);
    }
    //数组迭代
    public static int Fibonacci3(int n) {
        if(n < 0 || n > 39){
            return -1;
        }
        if(n == 0 ||n == 1){
            return n;
        }
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
    //优化空间
    public static int Fibonacci4(int n) {
        if(n < 0 || n > 39){
            return -1;
        }
        if(n == 0 ||n == 1){
            return n;
        }
        int p = 0;
        int q = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = p + q;
            p = q;
            q = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci4(4));
        System.out.println(Fibonacci4(5));
        System.out.println(Fibonacci4(0));
        System.out.println(Fibonacci4(40));
    }
}
