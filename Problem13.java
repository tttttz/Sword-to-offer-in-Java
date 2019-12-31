package SwordToOffer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
class Solution13 {
    //因为要求相对位置不变，故只能用循环加冒泡之类的，无法使用快排的划分思想。
    public static void reOrderArray(int [] array) {
        if(array.length == 0){
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i ; j--) {
                if((array[j] & 1) != 0 && (array[j-1]&1) == 0){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
