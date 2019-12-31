package SwordToOffer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
class Solution28 {

    //思路：若times为0，则出现的新数字设置为候选答案数字，当times不为0时
    //当前数字和前一个数字相同，则times+1，否则times-1.
    //若一个数字出现的次数超过总数组长度的一半，则必定是最后一个将time设置为1的数
    //但是还需要最后看一下该数的次数是否超过一半。
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array.length<2){
            return 0;
        }
        int res = 0;
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if(times == 0){
                res = array[i];
                times++;
            }else{
                if(array[i] == res){
                    times++;
                }else{
                    times--;
                }
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == res){
                times++;
            }
        }
        if(times > array.length>>1){
            return res;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}