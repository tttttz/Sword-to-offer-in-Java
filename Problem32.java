package SwordToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
class Solution32 {

    /*
    更改比较规则，若ab拼接小于ba拼接，则a小于b，按照此规则将原数组排序。
    此处使用比较器Comparator，其中的compare(String s1, String s2)方法
    若返回正值则代表s1>s2，负值为s1<s2,0则s1=s2.
    排序后ArrayList中的值按顺序拼接后即为最小值。
     */
    public static String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        ArrayList<String> help = new ArrayList<>();
        for (int number : numbers) {
            help.add(number + "");
        }
        Collections.sort(help, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(Integer.parseInt(s1 + s2) < Integer.parseInt(s2 + s1)){
                    return -1;
                }else if (Integer.parseInt(s1 + s2) > Integer.parseInt(s2 + s1)){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        StringBuilder res = new StringBuilder();
        for (String s : help) {
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,32,321};
        System.out.println(PrintMinNumber(nums));
    }
}
