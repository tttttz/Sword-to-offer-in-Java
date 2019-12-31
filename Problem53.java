package SwordToOffer;

/**
 *请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
class Solution53 {
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0){
            return false;
        }
        boolean isNum = false;
        int index = 0;
        index = isInteger(str, index);
        if(index > 0){
            isNum = true;
        }
        if(index < str.length && str[index] == '.'){
            index++;
            if(index == str.length){
                return isNum;
            }
            int tempIndex = isUnsignedInteger(str, index);
            isNum = (tempIndex > index) || isNum;
            index = tempIndex;
        }
        if(index < str.length-1 && (str[index] == 'e' || str[index] == 'E')){
            index++;
            int tempIndex = isInteger(str, index);
            isNum = isNum && (tempIndex > index);
            index = tempIndex;
        }
        return isNum && (index == str.length);
    }

    //返回第一个遇到的符号的index
    public int isUnsignedInteger(char[] str, int index){
        while(index < str.length && str[index] >= '0' && str[index] <= '9'){
            index++;
        }
        return index;
    }
    //返回第一个遇到的符号的index
    public int isInteger(char[] str, int index){
        if(str[index] == '+' || str[index] == '-'){
            index = index + 1;
        }
        return isUnsignedInteger(str, index);
    }

    public static void main(String[] args) {
        Solution53 s = new Solution53();
        String str = "1a3.14";
        char[] c = str.toCharArray();
        System.out.println(s.isNumeric(c));
    }
}