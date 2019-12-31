package SwordToOffer;

import java.util.ArrayList;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
class Solution51 {
    /*
    遍历两次数组，一次正序一次逆序，
    第一次将每个数左侧所有的数连乘后赋给当前值，
    第二次将每个数右侧所有的数连乘后赋给当前值，
    因为上一个值记录过之前数连乘的值，故每次只需要和前一个值相乘即可。
     */
    public int[] multiply(int[] A) {
        if(A == null || A.length == 0){
            return new int[]{};
        }
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        for (int i = len - 2; i >= 0 ; i--) {
            temp *= A[i+1];
            B[i] *= temp;
        }
        return B;
    }
}