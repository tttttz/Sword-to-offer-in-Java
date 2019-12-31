package SwordToOffer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
class Solution65 {
    /*
    思路：
    回溯法，遍历矩阵每个元素，找到和路径中第一个元素相同的字符就开始查找，
    设置一个布尔数组用来记录某个元素是否已经在路径中，
    若不在路径中则与当前元素比较，相等则递归比较当前元素的上下左右四个元素。
    若当前找到str的最后一个字符，则返回true。
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix == null || matrix.length == 0 || str == null || str.length == 0 || rows <= 0 || cols <= 0 || rows * cols != matrix.length){
            return false;
        }
        boolean[] flags = new boolean[matrix.length];//boolean默认初始值为false
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(hasPathCore(matrix, rows, cols, i, j, flags, str, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int curRows, int curCols, boolean[] flags, char[] str, int k){
        int index = curRows * cols + curCols;
        if(curRows < 0 || curRows >= rows || curCols < 0 || curCols >= cols || matrix[index] != str[k] || flags[index] == true){
            return false;
        }
/*        System.out.println(curRows + "," + curCols);
        System.out.println(matrix[index]);
        System.out.println(str[k]);*/
        if(k == str.length - 1){
            return true;
        }
        flags[index] = true;
        if(hasPathCore(matrix, rows, cols, curRows + 1, curCols, flags, str, k + 1)
                ||hasPathCore(matrix, rows, cols, curRows - 1, curCols, flags, str, k + 1)
                ||hasPathCore(matrix, rows, cols, curRows, curCols + 1, flags, str, k + 1)
                ||hasPathCore(matrix, rows, cols, curRows, curCols - 1, flags, str, k + 1)){
            return true;
        }
        flags[index] = false;//入过当前位置不可行记得复原flag
        return false;
    }

    public static void main(String[] args) {
        Solution65 s = new Solution65();
        String str1 = "ABCESFCSADEE";
        String str2 = "ABCCED";
        char[]  c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        System.out.println(s.hasPath(c1, 3,4,c2));
    }
}