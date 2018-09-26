package arithmetic;

import javax.swing.*;
import java.util.*;

public class StackLearn {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     * Example 1:
     */
    public static void main(String[] args) {
        System.out.println(isTheSame("[{}]"));

        MinStackItem minStack = new MinStackItem();
        minStack.push(15);
        minStack.push(25);


        minStack.push(35);
        minStack.push(13);
        minStack.push(5);
        minStack.push(3);
        minStack.push(60);
        minStack.push(2);

        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

        System.out.println(removeSameChar("bcabc"));
        reviceSoutString("abcdef", "abcdef".length() - 1);

        MyStack myStack = new MyStack();
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 3; i++) {
            myStack.push(i);

        }
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
    }

    /**
     * 合法括号   * <p>
     *
     * @param source
     * @return
     */
    public static boolean isTheSame(String source) {
        if (Objects.isNull(source) || Objects.equals("", source))
            return false;
        Stack<Character> characterStack = new Stack<>();
        for (char c : source.toCharArray()) {
            if (c == '(')
                characterStack.push(')');
            else if (c == '{')
                characterStack.push('}');
            else if (c == '[')
                characterStack.push(']');
            else if (characterStack.isEmpty() || characterStack.pop() != c) {
                return false;
            }

        }
        return characterStack.isEmpty();

    }

    /**
     * Example 1:
     * <p>
     * Input: "bcabc"
     * Output: "abc"
     * Example 2:
     * <p>
     * Input: "cbacdcbc"
     * Output: "acdb"
     *
     * @param item
     */
    public static String removeSameChar(String item) {
        char[] index = new char[255];
        char[] chars = item.toCharArray();
        char[] data = new char[255];

        for (int i = 0; i < chars.length; i++) {
            if (index[chars[i]] != 0) {
                continue;
            }
            data[chars[i]] = chars[i];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                stringBuilder.append(data[i]);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 倒序打印字符串
     */


    public static void reviceSoutString(String s, int i) {
        if (i == 0) {
            System.out.println(s.charAt(i));
            return;
        }
        System.out.println(s.charAt(i));
        reviceSoutString(s, --i);
    }

    /**
     * todo
     */

    public static Set theLongSame(String target) {
        char[] chars = target.toCharArray();
        Stack<Character> characters = new Stack<>();
        int max = 0;
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        LinkedHashSet<Character> tempset = new LinkedHashSet<>();

        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] == ')' || chars[i] == '(') && characters.isEmpty() && i != 0) {
                continue;
            }
            if (chars[i] == '(') {
                Character push = characters.push(chars[i]);
                tempset.add(push);
            } else {
                Character pop = characters.pop();
                tempset.add(pop);
            }
            if (characters.isEmpty()) {
                if (set.size() < tempset.size()) {
                    set.removeAll(set);
                    set.addAll(tempset);
                }
            }

        }
        return set;
    }

    static class MinStackItem {
        Integer min = Integer.MAX_VALUE;
        Stack<Integer> date = new Stack<Integer>();


        public void push(Integer item) {
            if (item < min) {
                date.push(min);
                min = item;
            }
            date.push(item);
        }

        public Integer pop() {
            Integer pop = date.pop();
            if (pop == min) {
                min = date.pop();
            }
            return pop;
        }

        public Integer getMin() {
            return min;
        }
    }

    /**
     * 最小元素栈
     */
    static class MinStack {
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<Integer>();

        public void push(int x) {
            // only push the old minimum value when the current
            // minimum value changes after pushing the new value x
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            // if pop operation could result in the changing of the current minimum value,
            // pop twice and change the current minimum value to the last minimum value.
            if (stack.pop() == min)
                min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    static class MyQueue {
        Stack<Integer> input = new Stack<Integer>();
        Stack<Integer> output = new Stack<Integer>();
        /** Push element x to the back of queue. */
        public void push(int x) {
            input.push(x);
        }
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return output.pop();
        }
        /** Get the front element. */
        public int peek() {
            if(output.isEmpty()){
                while(!input.isEmpty())
                    output.push(input.pop());
            }
            return output.peek();
        }
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

    static class MyStack {

        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();

        /** Push element x onto stack. */
        public void push(int x) {
            if(q1.isEmpty()){
                q1.add(x);
                for(int i = 0; i < q2.size(); i++){
                    q1.add(q2.poll());
                }
            }else{
                q2.add(x);
                for(int i = 0; i < q1.size(); i++){
                    q2.add(q1.poll());
                }
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q1.isEmpty() ? q2.poll() : q1.poll();
        }

        /** Get the top element. */
        public int top() {
            return q1.isEmpty() ? q2.peek() : q1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }




}
