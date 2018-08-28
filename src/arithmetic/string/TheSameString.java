package arithmetic.string;

public class TheSameString {
    public static void main(String[] args) {
        String obj = "abcaefc";
        String target = "ghigkli";
        System.out.println(isTheSame(obj, target));

    }

    public static boolean isTheSame(String obj, String target) {
        if (obj == null || target == null) {
            return false;
        }
        char[] objs = obj.toCharArray();
        char[] targets = target.toCharArray();
        if (objs.length != targets.length) {
            return false;
        }
        char[] mapChar = new char[255];
        for (int i = 0; i < objs.length; i++) {
            if (mapChar[objs[i]] != 0) {
                if (mapChar[objs[i]] != targets[i]) {
                    return false;
                }
            } else {
                mapChar[objs[i]] = targets[i];
            }

        }
        return true;

    }

}
