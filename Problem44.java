package SwordToOffer;


/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */

class Solution44 {

    /*
    思路：
    先翻转整个字符串，然后翻转每个单词。
    （注意边界条件，先判断high是否到达最后，再判断high+1是否为空格）
     */
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return new String();
        }
        char[] c = str.toCharArray();
        reverse(c, 0, c.length - 1);
        int low = 0;
        int high = 0;
        while(low < c.length){
            while (high != c.length - 1 && c[high + 1] != ' '){
                high ++;
            }
            reverse(c, low, high);
            low = high + 2;
            high = low;
        }
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

    public static void main(String[] args) {
        Solution44 s = new Solution44();
        String a = s.ReverseSentence("I am a student.");
        System.out.println(a);
    }
}
