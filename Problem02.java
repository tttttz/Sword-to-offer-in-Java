package SwordToOffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
class Solution02 {
    //用自带函数，面试不可行
    public static String replaceSpace(StringBuffer str) {
        if(str!=null && !str.equals("")){
            return str.toString().replace(" ","%20");
        }
        return null;
    }

    /**
     * 数组扩容后从后往前替换，时间复杂度O(n)
     * @param str
     * @return
     */
    public static String replaceSpace2(StringBuffer str) {
        if(str!=null && !str.equals("")){
            int space = 0;
            int oldLength = str.length();
            //找出空格数量
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' '){
                    space++;
                }
            }
            int newLength = oldLength + 2*space;//扩容
            str.setLength(newLength);
            int oldIndex = oldLength - 1;
            int newIndex = newLength - 1;
            while(oldIndex >= 0 && oldLength < newLength){
                if(str.charAt(oldIndex) != ' ') {
                    str.setCharAt(newIndex--, str.charAt(oldIndex));
                }else{
                    str.setCharAt(newIndex--,'0');
                    str.setCharAt(newIndex--,'2');
                    str.setCharAt(newIndex--,'%');
                }
                oldIndex--;
            }
            return str.toString();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("we are happy")));
        System.out.println(replaceSpace2(new StringBuffer("we are happy")));
    }
}
