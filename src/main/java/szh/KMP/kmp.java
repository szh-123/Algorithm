package szh.KMP;

public class kmp {
    public static void main(String[] args) {
        String a="abcabbaa";
        String b="bba";
        int n=getIndexOf(a,b);
        System.out.println(n);
    }
    //获得next数组，一个字符前后缀相等的最大字符串长度
    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;//next数组的位置
        int cn = 0;
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {//当前跳到cn位置的字符和i-1位置字符配不上
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    //获得位置
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);//O(M)
        //O(N)
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {//str2对比的位置无法往前跳
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        //i1越界或者i2越界了
        return i2 == str2.length ? i1 - i2 : -1;

    }
}

