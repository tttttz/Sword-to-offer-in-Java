package SwordToOffer;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
class Solution66 {
    /*
    思路：回溯
    若一个点在合法值范围之外或者已经走过该点，则返回0，
    否则递归获取上下左右四个点是否能走的值 + 1。
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows <= 0 || cols <= 0){
            return 0;
        }
        boolean[] flags = new boolean[rows * cols];
        return movingCountCore(threshold, rows, cols, 0, 0, flags);
    }
    private int movingCountCore(int threshold, int rows, int cols, int curRow, int curCol, boolean[] flags){
        int index = curRow * cols + curCol;
        if(curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols || flags[index] == true
        || !canReach(threshold, curRow, curCol)){
            return 0;
        }
        flags[index] = true;
        return movingCountCore(threshold, rows, cols, curRow + 1, curCol, flags)
                + movingCountCore(threshold, rows, cols, curRow - 1, curCol, flags)
                + movingCountCore(threshold, rows, cols, curRow, curCol + 1, flags)
                + movingCountCore(threshold, rows, cols, curRow, curCol - 1, flags)
                +1;
    }
    public boolean canReach(int k, int curRow, int curCol){
        int sum = 0;
        while(curRow > 0){
            sum += curRow % 10;
            curRow /= 10;
        }
        while (curCol > 0){
            sum += curCol % 10;
            curCol /= 10;
        }
        if(sum > k){
            return false;
        } else {
            return true;
        }
    }

}