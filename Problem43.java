package SwordToOffer;

import java.util.Arrays;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
class Solution43 {
    //方法1：使用StringBuilder
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n < 0){
            return new String("");
        }
        n = n % str.length();
        char[] c = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < c.length; i++) {
            sb.append(c[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(c[i]);
        }
        return sb.toString();
    }
    //方法2，先翻转数组前n项，再翻转后n到length-1项，然后翻转整个数组。
    public String LeftRotateString2(String str,int n){
        if(str == null || str.length() == 0 || n < 0){
            return new String("");
        }
        char[] c = str.toCharArray();
        reverse(c, 0, n-1);
        reverse(c, n, c.length-1);
        reverse(c, 0, c.length - 1);
        return new String(c);
    }
    public void reverse(char[] c, int start, int end){
        while (start < end){
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }

}