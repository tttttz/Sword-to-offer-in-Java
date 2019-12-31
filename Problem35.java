package SwordToOffer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */

class Solution35 {
    /*
    思路：
    使用递归，归并排序的思想，两段内部有序的数比较最后一个节点，若左边的大，
    则将右边节点的左部分（包括自己）的个数加入逆序数的总数，并将左半部分指针向左移动一位。
    若右边节点大，则右边节点指针向左移动一位。
     */
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length-1);
        return count;
    }
    public int InversePairsCore(int[] data, int[] copy, int start, int end){
        if(start == end){
            copy[start] = data[start];
            return 0;
        }
        int mid = (end + start)>>1;
        int left = InversePairsCore(copy, data, start, mid);
        int right = InversePairsCore(copy, data, mid+1, end);

        int i = mid;
        int j = end;
        int copyIndex = end;
        int count = 0;
        while(i >= start && j > mid){
            if(data[i] > data[j]){
                copy[copyIndex--] = data[i--];
                count += j - mid;
                if(count > 1000000007){
                    count %= 1000000007;
                }
            }else {
                copy[copyIndex--] = data[j--];
            }
        }
        while(i >= start){
            copy[copyIndex--] = data[i--];
        }
        while(j > mid){
            copy[copyIndex--] = data[j--];
        }
        return (left + right + count) % 1000000007;
    }

    public static void main(String[] args) {
        Solution35 s= new Solution35();
        int[] a = new int[]{3,2,1};
        System.out.println(s.InversePairs(a));
    }
}