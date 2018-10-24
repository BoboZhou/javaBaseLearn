package arithmetic.stack;

import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class StackLearn {

    public static void main(String[] args) throws Exception {
        String s = "{([{}])}";
        String s1 = "[{{}]";
        System.out.println(isLegaSymbol(s));
        System.out.println(isLegaSymbol(s1));
//
//        for (int i = 0; i < 10; i++) {
//            TwoStackForQuee.put(i);
//
//        }
//        System.out.println(TwoStackForQuee.take());
//        TwoStackForQuee.put(88);
//        TwoStackForQuee.put(99);
//        System.out.println(TwoStackForQuee.take());
//        while (!TwoStackForQuee.isEmpty()) {
//            System.out.println(TwoStackForQuee.take());
//        }


        for (int i = 0; i < 10; i++) {
            TwoQUeueForStack.add(i);
        }
        TwoQUeueForStack.add(4000);

        while (!TwoQUeueForStack.isEmpty()) {
            System.out.println(TwoQUeueForStack.poll());
        }
    }

    /**
     * 判断合法括号
     */
    public static boolean isLegaSymbol(String s) {
        if (null == s || s.length() == 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(')');
            else if (ch == '[') stack.push(']');
            else if (ch == '{') stack.push('}');
            else if (stack.pop() != ch) return false;
        }
        return stack.isEmpty();
    }

    /**
     * 两个栈实现队列
     */
    static class TwoStackForQuee {
        static Stack<Integer> outPut = new Stack<>();
        static Stack<Integer> inPut = new Stack<>();

        static void put(Integer a) {
            inPut.push(a);
        }

        static Integer take() {
            if (outPut.isEmpty()) {
                while (!inPut.isEmpty()) {
                    outPut.push(inPut.pop());
                }
            }
            return outPut.pop();
        }

        static boolean isEmpty() {
            return outPut.isEmpty() && inPut.isEmpty();
        }

    }

    /**
     * 两个队列实现栈
     */

    static class TwoQUeueForStack {
        private static ArrayBlockingQueue<Integer> in = new ArrayBlockingQueue<Integer>(100);
        private static ArrayBlockingQueue<Integer> out = new ArrayBlockingQueue<Integer>(100);

        public static void add(Integer a) throws Exception {
            in.put(a);
            for (int i = 1; i < in.size(); i++) {
                Integer poll = in.poll();
                in.add(poll);
            }

        }

        public static Integer poll() throws Exception {
            return in.poll();
        }

        public static boolean isEmpty() {
            return in.size() == 0;
        }

    }

    /**
     * @Author: bobo
     * @Description 最小栈
     * @Date :下午2:13 2018/10/24
     */

    static class minStack {
        private Integer min = Integer.MAX_VALUE;
        private Stack<Integer> stack = new Stack<>();
        public void push(Integer a) {
            if (a <= min) {
                stack.push(min);
                min = a;
            }
            stack.push(a);


        }

        public Integer pop() {
            Integer pop = stack.pop();
            if (Objects.equals(pop, min)) {
                min = stack.pop();
            }
            return pop();
        }
    }

}
