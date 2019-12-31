package SwordToOffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
class Solution54 {
    //使用linkedHashMap记录字符流的当前字符出现个数，最后遍历linkedHashMap找到第一个出现一次的字符即可
    private LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        if(linkedHashMap.containsKey(ch)){
            linkedHashMap.put(ch, linkedHashMap.get(ch) + 1);
        }else {
            linkedHashMap.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return '#';
    }
}
