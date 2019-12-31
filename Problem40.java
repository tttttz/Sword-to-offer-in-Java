package SwordToOffer;


import java.util.ArrayList;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */

class Solution40 {

    /*
    思路：
    利用异或运算：一个数异或自身为0，且异或运算具有交换律和结合律。
    只有两个数出现一次，其他数都出现了两次，则所有数异或之后的值即为两个只出现一次的数异或的结果。
    且这个值必定不为0，则其二进制一定有一位为1，说明这两个数的这一位的值不同。
    据此可以将数组中的数分为两部分且每个部分各有一个出现次数为1的数，所有出现两次的数的两个数也肯定都在同一组。
    在分别将两部分数进行异或运算，则可得到这两个只出现了一次的数。
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int res = 0;
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            res ^= array[i];
        }
        int index = getFirstBitIs1(res);
        for (int i = 0; i < array.length; i++) {
            if(IsBit1(array[i], index) == true){
                list1.add(array[i]);
            }else{
                list2.add(array[i]);
            }
        }
        for (Integer integer : list1) {
            num1[0] ^= integer;
        }
        for (Integer integer : list2) {
            num2[0] ^= integer;
        }
    }

    //返回某数二进制从右开始第n个数是否为1。
    public boolean IsBit1(int num, int n){
        num = num>>n;
        return (num&1)==1;
    }

    //找到某个数二进制从右开始第一个1，并返回从右数的个数。
    public int getFirstBitIs1(int num){
        int n = 0;
        while((num&1)==0){
            num = num>>1;
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int[] arr = new int[]{2,4,3,6,3,2,5,5};
        Solution40 s = new Solution40();
        s.FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
