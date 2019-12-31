package SwordToOffer;
/**
 * 旋转打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;
//要注意左上和右下坐标的横坐标或者纵坐标相等时的情况
class Solution19 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length <= 0){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int r1 = 0;
        int c1 = 0;
        int r2 = matrix.length-1;
        int c2 = matrix[0].length-1;
        while(r1 <= r2 && c1 <= c2){
            getEdge(matrix,r1++,c1++,r2--,c2--,res);
        }
        return res;
    }

    public static void getEdge(int [][] matrix, int r1, int c1, int r2, int c2, ArrayList<Integer> res){
        if (r1 == r2){
            for (int i = c1; i <= c2 ; i++) {
                res.add(matrix[r1][i]);
            }
            return;
        }
        if(c1 == c2){
            for (int i = r1; i <= r2; i++) {
                res.add(matrix[i][c1]);
            }
            return;
        }
        for (int i = c1; i < c2; i++) {
            res.add(matrix[r1][i]);
        }
        for (int i = r1; i < r2; i++) {
            res.add(matrix[i][c2]);
        }
        for (int i = c2; i > c1; i--) {
            res.add(matrix[r2][i]);
        }
        for (int i = r2; i >r1 ; i--) {
            res.add(matrix[i][c1]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] a = new int[][]{{1}};
        System.out.println(printMatrix(a).toString());
        //System.out.println(printMatrix(matrix).toString());
    }
}