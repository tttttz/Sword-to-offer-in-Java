package SwordToOffer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
class Solution52 {

    /*
    思路：
    递归，且当下一个模式为*且当前模式匹配时有三种情况可以选择，只要其中一个匹配就返回true。
    具体思路看题解或者《剑指offer》125页
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }

    public boolean matchCore(char[] str, char[] pattern, int s, int p) {
        if (s == str.length && p == pattern.length) {
            return true;
        }
        if (s != str.length && p >= pattern.length) {
            return false;
        }
        if (p < pattern.length - 1 && pattern[p + 1] == '*') {
            if ((s != str.length && pattern[p] == str[s]) || (pattern[p] == '.' && s != str.length)) {
                return matchCore(str, pattern, s + 1, p + 2)
                        || matchCore(str, pattern, s + 1, p)
                        || matchCore(str, pattern, s, p + 2);
            } else {
                return matchCore(str, pattern, s, p + 2);
            }
        }
        if ((s != str.length && pattern[p] == str[s]) || (pattern[p] == '.' && s != str.length)) {
            return matchCore(str, pattern, s + 1, p + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution52 s = new Solution52();
        //"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
        System.out.println(s.match(new char[]{'a','b'}, new char[]{'.', '*'}));
    }
}
