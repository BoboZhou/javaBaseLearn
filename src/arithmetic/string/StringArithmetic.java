package arithmetic.string;

/**
 * 字符串的全排列和组合
 */
class FullPerMutation {
    void peiMutation(char[] arr, int begin ) {
        char temp;
        if (begin == arr.length-1) {
            System.out.println(arr);
        } else {
            for (int i = begin; i < arr.length; i++) {
                temp = arr[begin];arr[begin] = arr[i];arr[i] = temp;
                peiMutation(arr, begin + 1);
                temp = arr[begin];arr[begin] = arr[i];arr[i] = temp;
            }
        }

    }

}

public class StringArithmetic {
    public static void main(String[] args) {
        FullPerMutation full = new FullPerMutation();
        char[] arr = "abc".toCharArray();
        full.peiMutation(arr, 0);
    }
}
