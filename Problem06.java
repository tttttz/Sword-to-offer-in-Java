package SwordToOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

import java.util.ArrayList;
class Solution06 {
    public static int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]<min){
                min = array[i];
                break;
            }
        }
        return min;
    }
    /*
    思路：
    双指针指i，j指向最左和左右。
    执行如下循环：
    若i值小于j值则返回i值（i必为最小值，可以反证），否则取mid值，
    若mid值大于i值，则最小值必定在mid+1到j，若mid值小于i值，则最小值必定在i到mid。
     */
    public static int minNumberInRotateArray2(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            if(array[i] < array[j]){
                return array[i];
            }
            int mid = (i + j)>>1;
            if(array[mid] > array[i]){
                i = mid + 1;
            }else if (array[mid] < array[i]){
                j = mid;
                i++;//i已经不可能是最小值下标了故可以+1
            }else{
                i++;
            }
        }
        return array[i];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,2,2,1,2,2};
        System.out.println(minNumberInRotateArray2(arr));
    }
}
