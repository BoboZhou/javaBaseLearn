package arithmetic.string;

import java.util.Stack;

/**
 * 字符串的全排列和组合
 */
class FullPerMutation {
    /**
     * 全排列
     *
     * @param arr
     * @param begin
     */
    void peiMutation(char[] arr, int begin) {
        char temp;
        if (begin == arr.length - 1) {
            System.out.println(arr);
        } else {
            for (int i = begin; i < arr.length; i++) {
                temp = arr[begin];
                arr[begin] = arr[i];
                arr[i] = temp;
                peiMutation(arr, begin + 1);
                temp = arr[begin];
                arr[begin] = arr[i];
                arr[i] = temp;
            }
        }

    }

    public void combine(char chs[]) {
        if (chs.length == 0) return;

        Stack<Character> stack = new Stack<>();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, stack);
        }
    }

    /**
     * 全组合
     */
    //从字符数组中第begin个字符开始挑选number个字符加入stack中
    public static void combine(char[] chs, int begin, int number, Stack<Character> stack) {
        if (number == 0) {
            System.out.println(stack.toString());
            return;
        }
        if (begin == chs.length) {
            return;
        }
        Character push = stack.push(chs[begin]);
        combine(chs, begin + 1, number - 1, stack);
        Character pop = stack.pop();
        combine(chs, begin + 1, number, stack);
    }


}

public class StringArithmetic {
    public static void main(String[] args) {
        FullPerMutation full = new FullPerMutation();
        char[] arr = "abc".toCharArray();
//        full.peiMutation(arr, 0);
//        full.combine(arr);
        full.combine(arr,0,2,new Stack<>());
    }
}
