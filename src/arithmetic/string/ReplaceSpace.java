package arithmetic.string;

/**
 *  ti
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = " abc de f ghi kl ";
        replaceSpace(s);

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
}
