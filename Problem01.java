package SwordToOffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
class Solution01 {
    /*
    思路：
    从右上角（或左下角）开始，若比当前数大则向左（向上）移动，若比当前数小则向下（右）移动。
     */
    public static boolean Find(int target, int [][] array) {
        if(array != null && array.length > 0){
            int j = array[0].length - 1;
            int i = 0;
            while (j >= 0 && i <= array.length - 1){
                if(array[i][j] == target){
                    return true;
                }else if(array[i][j] > target){
                    j--;
                }else {
                    i++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,7,12,19},{8,9,12,20},{10,11,14,22},{15,16,17,23}};
        System.out.println(Find(11,arr));
        System.out.println(Find(24,arr));
    }
}
