package SwordToOffer;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */


class Solution33 {

    /*
    思路：
    一个数是丑数，则这个数乘以2,3,5以后也是丑数。
    用三个变量分别记录最小的可能乘以2,3,5以后大于当前最大丑数的值的下标，
    从第一个丑数开始，分别乘以2,3,5后取出最小的那个值放在数组最后，实现丑数的有序。
    然后该下标中的值乘以2,3,5中的某个值后不可能比当前最大的丑数大，故该下标+1。
    直到记录丑数的数组到达N-1的位置停止，该下标中的值即为所求丑数。
     */
    public static int GetUglyNumber_Solution(int index) {
        if(index < 1){
            return -1;
        }
        int[] uglyNum = new int[index];
        uglyNum[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < index; i++) {
            int n2 = uglyNum[i2] * 2;
            int n3 = uglyNum[i3] * 3;
            int n5 = uglyNum[i5] * 5;
            uglyNum[i] = Math.min(n2, Math.min(n3, n5));
            if(uglyNum[i] == n2){
                i2 ++;
            }
            if(uglyNum[i] == n3){
                i3 ++;
            }
            if(uglyNum[i] == n5){
                i5++;
            }
        }
        return uglyNum[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(100));
    }
}
