package javacurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println("boss wait");
                countDownLatch.await();
                System.out.println("begin meeting");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        long count = countDownLatch.getCount();
        System.out.println(count);
        for (long i = 0; i < count; i++) {

            long finalI = i;
            new Thread(() -> {
                System.out.println("empleoyee " + finalI + "come in ");
                countDownLatch.countDown();
                System.out.println(finalI +" has come");
            }).start();
        }
    }

}
