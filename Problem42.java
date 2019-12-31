package SwordToOffer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
class Solution42 {

    /*
    思路：双指针
    一个low指针指向数组开头，一个high指针指向数组结尾。
    当low<high时执行循环，
    两个位置数字和若为sum，则记录这两个数以及他们的乘积，然后low指针右移，high指针左移，
    若小于sum，则low指针右移，获得一个更大的值，因为high已经是最大值（数组已经排序）所以不可能左移。
    若大于sum，则high指针左移，获得一个更小的值，因为low已经是最小。
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length < 2){
            return res;
        }
        int low = 0;
        int high = array.length - 1;
        int first = array[low];
        int second = array[high];
        int muti = Integer.MAX_VALUE;
        while(low < high){
            int cur = array[low] + array[high];
            if(cur == sum){
                if(array[low] * array[high] < muti){
                    first = array[low];
                    second = array[high];
                    muti = first * second;
                }
                low++;
                high--;
            }else if (cur < sum){
                low++;
            }else if (cur > sum){
                high--;
            }
        }
        if(first + second == sum){
            res.add(first);
            res.add(second);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution42 s = new Solution42();
        int[] arr = new int[]{1,2,4,7,11,15};
        ArrayList<Integer> res = s.FindNumbersWithSum(arr, 15);
        System.out.println(res.get(0));
        System.out.println(res.get(1));
    }
}