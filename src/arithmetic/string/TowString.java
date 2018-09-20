package arithmetic.string;

import java.util.*;

/**
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * <p>
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * <p>
 * 返回所有不常用单词的列表。
 * <p>
 * 您可以按任何顺序返回列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 * 示例 2：
 * <p>
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 */
public class TowString {
    public static void main(String[] args) {
        String str = "JKTUKMYVBNHUOPUIJTY";
        int length = lengthOfLongestSubstring(str);

        System.out.println(length);
        for (int i = 0; i < 20; i++) {
            System.out.println((0x61c88647 -i) & 16);

        }

        System.out.println(getSubStrMin(str));
        System.out.println(checkIsPalindromic("qwewq"));
        System.out.println(checkIsPalindromic("qwwq"));
        System.out.println(checkIsPalindromic("qwttwq"));


    }

    /**
     * 最长子字符串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static Set<Character> getSubStrMin(String s) {
        int n = s.length();

        int i = 0, j = 0, ans = 0;
        LinkedHashSet<Character> set = new LinkedHashSet();
        LinkedHashSet<Character> s1 = new LinkedHashSet();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                if (s1.size() < set.size()) {
                    s1.removeAll(s1);
                    s1.addAll(set);
                }
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return s1;
    }

    /**
     * 判断一个字符知否是回文串
     */

    public static boolean checkIsPalindromic(String target) {
        if (Objects.isNull(target) || target.length() == 0 || Objects.equals("", target)) {

            return false;
        }
        int length = target.length();

        int left = 0, right = length - 1;

        while (left <= right) {
            if (target.charAt(left++) != target.charAt(right--)) {
                return false;
            }
        }


        return true;
    }

    /**
     * 无重复最长子串
     */
//    public Object maxSubStr(String target) {
//        if (Objects.isNull(target) || Objects.equals("", target)) {
//            return null;
//        }
//        int i = 0, j = 0;
//        LinkedHashSet<Object> resSet = new LinkedHashSet<>();
//        HashSet set = new HashSet();
//        while (i < j && j < target.length()) {
//            if (!set.contains(target.charAt(j))) {
//                set.add(target.charAt(j++));
//            }else {
//
//            }
//        }
//    }
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba"也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     */
}
