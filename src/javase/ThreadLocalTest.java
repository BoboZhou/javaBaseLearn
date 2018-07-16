package javase;

public class ThreadLocalTest {
    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("bobo");
        threadLocal.set("ggg");
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
        integerThreadLocal.set(1);
        System.out.println(threadLocal.get());
        System.out.println(integerThreadLocal.get());
    }
}
