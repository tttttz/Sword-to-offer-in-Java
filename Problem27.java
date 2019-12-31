package SwordToOffer;


/**
 *输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */


import java.util.ArrayList;

import java.util.TreeSet;

class Solution27 {
    //使用递归，将字符串分为第一个字符和其余字符两部分，然后分别交换。
    public static ArrayList<String> Permutation(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        ArrayList<String> result = PermutationHelp(strBuilder);
        return result;
    }

    public static ArrayList<String> PermutationHelp(StringBuilder str){
        TreeSet<String> result = new TreeSet<>();
        if(str.length() == 1)
            result.add(str.toString());
        else{
            for(int i = 0; i < str.length(); i++){
                if(i == 0  || str.charAt(i) != str.charAt(0)){
                    char temp = str.charAt(i);
                    str.setCharAt(i, str.charAt(0));
                    str.setCharAt(0, temp);
                    ArrayList<String> newResult = PermutationHelp(new StringBuilder(str.substring(1)));
                    for(int j =0; j < newResult.size(); j++)
                        result.add(str.substring(0,1)+newResult.get(j));
                    //用完还是要放回去的
                    temp = str.charAt(0);
                    str.setCharAt(0, str.charAt(i));
                    str.setCharAt(i, temp);
                }
            }
            //需要在做一个排序操作

        }
        ArrayList<String> res = new ArrayList<>();
        res.addAll(result);
        return res;
    }

    public static ArrayList<String> Permutation2(String str) {
        TreeSet<String> res = new TreeSet<>();
        ArrayList<String> result = new ArrayList<>();
        if(str == null || "".equals(str)){
            return result;
        }
        char[] c = str.toCharArray();
        Permutation2Help(c,0,res);
        result.addAll(res);
        return result;
    }
    public static void Permutation2Help(char[] c, int index, TreeSet<String> res){
        if(index == c.length - 1){
            res.add(String.valueOf(c));
        }else {
            for (int i = index; i < c.length; i++) {
                if(c[index] == c[i] && i != index){
                    continue;
                }
                char temp = c[i];
                c[i] = c[index];
                c[index] = temp;
                Permutation2Help(c,index+1,res);
                temp = c[i];
                c[i] = c[index];
                c[index] = temp;
            }
        }

    }


    public static void main(String[] args) {
        System.out.println( Permutation2("cba"));
    }
}
