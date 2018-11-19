package arithmetic.string;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *  ti
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = " abc de f ghi kl ";
        replaceSpace(s);
        System.out.println(getMaxChildStr("abcghfjdfj"));
        System.out.println(lengthOfLongestSubstring("abcdag"));


    }

    public static void replaceSpace(String source) {
        char[] chars = source.toCharArray();
        int newlength = source.length();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                newlength += 2;
            }
        }
        char[] newChar = new char[newlength];
        int p1=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                newChar[p1++] = '%';
                newChar[p1++] = '2';
                newChar[p1++] = '0';
            }else {
                newChar[p1++] = chars[i];
            }
        }
        System.out.println(newChar);


    }

    /**
     * @return
     * @Description : 字符串最长不相同子串
     * @Param :
     * @Author bobo
     * @date: 2018/11/13
     */


    public static String getMaxChildStr(String str) {
        HashSet<Character> set = new HashSet<>();
        if (Objects.isNull(str) || str.length() == 0) {
            return null;
        }
        char[] chars = str.toCharArray();
        int ans = 0, i = 0, j = 0;
        while (i < chars.length && j < chars.length) {
            if (!set.contains(chars[j])) {
                set.add(chars[j++]);
                ans = Math.max(ans, j - i);

            }else {
                set.remove(chars[i++]);
            }

        }
        System.out.println(ans);
        return set.toString();
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            //试图调整[i,j]的范围
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


}
